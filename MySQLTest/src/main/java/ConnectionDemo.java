import java.sql.Connection;

public class ConnectionDemo {

    public static void main(String[] args) {
        Connection connection = source.getConnection();
        source.close(connection);
        System.out.println("Done.");
    }
}
