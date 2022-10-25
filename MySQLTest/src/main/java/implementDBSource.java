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
    public implementDBSource() throws IOException, ClassNotFoundException{
        this("jdbc.properties");
    }

    public implementDBSource(String configFile) throws IOException, ClassNotFoundException{
        properties = new Properties();
        properties.load(new FileInputStream(configFile));
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
