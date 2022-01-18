import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hb-03-one-to-many?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String username = "rizal";
        String password = "3748";

        try {
            System.out.println("Connecting to Mysql database");
            Connection myConn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection : " + myConn + " is successfull");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
