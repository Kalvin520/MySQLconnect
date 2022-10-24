import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
    public static String url = "jdbc.mysql://localhost:3306/mysql_DB";
    public static String user = "root";
    public static String password = "tv228222";

    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
