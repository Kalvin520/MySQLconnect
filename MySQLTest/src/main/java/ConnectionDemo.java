import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) {
        try {
            DBSource dbSource = new implementDBSource();
            Connection connection = dbSource.getconnection();
            if (!connection.isClosed()){
                System.out.println("資料庫連接已開啟.");
            }
            dbSource.closeConnection(connection);
            if (connection.isClosed()){
                System.out.println("資料庫連接已關閉.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
