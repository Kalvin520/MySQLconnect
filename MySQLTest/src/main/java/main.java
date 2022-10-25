import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) {
        Connection connection = source.getConnection();
        source.close(connection);
        System.out.println("Done.");
    }
}
