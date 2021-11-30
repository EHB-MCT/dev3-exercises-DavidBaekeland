import java.sql.*
import java.util.*

fun main() {
    println("test")


    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()

    val credential = Credentials()

    // Prepare credentials
    val connectionProps = Properties()
    connectionProps["user"] = credential.user
    connectionProps["password"] = credential.password

    // Create the connection: this will allow us to run queries on it later
    val connection =  DriverManager.getConnection(
        "jdbc:" + "mysql" + "://" +
                "dt5.ehb.be" +
                ":" + "3306" + "/" +
                credential.databaseName,
        connectionProps)

    val statement = connection.prepareStatement("SELECT * FROM rides")
    val result =  statement.executeQuery()


    while(result.next()) {
        val stringResult = result.getString("id")
        val trainId = result.getString("train_id")
        print(stringResult + " ")
        println(trainId)
    }
    ask2(connection)
}

// connection: Connection -> Connection: type -> String, int
fun ask(connection: Connection) {
    print("Which city do you like to go? ")
    val answer = readLine()

    // ? -> geen verkeerde query doorsturen -> bv data verloren
    // Zoekt naar id van stad
    val statement = connection.prepareStatement("SELECT id FROM cities WHERE name = ?")
    statement.setString(1, answer)
    val result =  statement.executeQuery()

    while(result.next()) {
        val stringResult = result.getString("id")
        println(stringResult)

        // zoekt naar vroegste rit naar die stad
        val statement2 = connection.prepareStatement("SELECT MIN(rides.departure_time) FROM rides WHERE destination_city = ?")
        statement2.setString(1, stringResult)
        val result2 =  statement2.executeQuery()

        // Er is maar 1 tabel bij result2
        while(result2.next()) {
            val stringResult2 = result2.getString("MIN(rides.departure_time)")
            println(stringResult2)
        }
        println(answer)
    }
}

fun ask2(connection: Connection) {
    print("Which city do you like to go? ")
    val answer = readLine()

    // ? -> geen verkeerde query doorsturen -> bv data verloren
    // https://stackoverflow.com/questions/3839982/row-with-minimum-value-of-a-column/3840011
    val statement = connection.prepareStatement("SELECT * FROM rides INNER JOIN cities on rides.destination_city = cities.id WHERE cities.name = ? AND rides.departure_time in (SELECT MIN(rides.departure_time) FROM rides)")
    statement.setString(1, answer)
    val result =  statement.executeQuery()

    while(result.next()) {
        val stringResult = result.getString("train_id")
        val stringResult2 = result.getString("departure_time")
        val stringResult3 = result.getString("departure_city")
        val stringResult4 = result.getString("destination_city")
        print(stringResult + " ")
        print(stringResult2 + " ")
        print(stringResult3 + " ")
        println(stringResult4)
    }
}
