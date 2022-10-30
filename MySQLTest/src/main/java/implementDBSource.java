import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;

public class implementDBSource implements DBSource{
    private Properties properties;
    private static String url = "jdbc:mysql://localhost:3306/mysql_DB?";
    private static String user = "root";
    private static String password = "tv228222";
    public implementDBSource() {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("日常偷懶xD...");
            System.out.println("驅動以連接完成");
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("程式驅動找不到");
        }

    }
    @Override
    public Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
