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
    ask(connection)
}

// connection: Connection -> Connection: type -> String, int
fun ask(connection: Connection) {
    print("Which city do you like to go? ")
    var answer = readLine()

    // ? -> geen verkeerde query doorsturen -> bv data verloren
    val statement2 = connection.prepareStatement("SELECT * FROM rides WHERE id = ?")
    statement2.setString(1, answer)
    val result2 =  statement2.executeQuery()

    while(result2.next()) {
        val stringResult = result2.getString("id")
        println(stringResult)
    }
    println(answer)
}
