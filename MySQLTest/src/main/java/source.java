import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class source {
    public static String url = "jdbc:mysql://localhost:3306/mysql_DB?";
    public static String user = "root";
    public static String password = "tv228222";
    //在屬性區宣告靜態區塊(類別建立只能引入一次)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("程式驅動找不到");

            e.printStackTrace();

        }
    }
    //建立取得資料庫連結物件靜態方法
    public static Connection getConnection() {
        Connection connection = null;
        //取得資料庫連接物件
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection open.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    //      關閉資料
    public static void close(Connection connection){
        try {
            connection.close();
            System.out.println("connection close.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
