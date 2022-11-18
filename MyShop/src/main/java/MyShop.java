import java.sql.Connection;

public class MyShop {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();

        //傳入物件進行關閉
        DBUtil.close(connection);
    }
}
