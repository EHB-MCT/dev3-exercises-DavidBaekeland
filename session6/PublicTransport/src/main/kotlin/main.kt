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

    val statement = connection.prepareStatement("SELECT * FROM orders")
    val result =  statement.executeQuery()


    while(result.next()) {
        val stringResult = result.getString("status")
        println(stringResult)
    }




}
