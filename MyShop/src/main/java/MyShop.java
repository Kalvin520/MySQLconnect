import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyShop {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        //傳入物件進行關閉
        DBUtil.close(connection);
        System.out.println("done.");
    }
}
