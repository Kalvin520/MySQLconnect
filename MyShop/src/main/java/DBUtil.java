import com.mysql.cj.util.EscapeTokenizer;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Kalvin
 */
public class DBUtil {
    public static String url = "jdbc:mysql://localhost:3306/mysql_DB?useSSL=false ";
    public static String user = "root";
    public static String password = "tv228222";

    //載入驅動
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("找不到驅動程式類別");
            e.printStackTrace();
        }
    }

    //SQL查詢語法
    static String str = "select * from mysql_DB.member";

    //建立取得資料庫連街物件靜態方法
    public static Connection getConnection() {
        //取得資料庫連接物件
        Connection connection = null;
        try {
            //與資料庫連接
            connection = DriverManager.getConnection(url, user, password);
            //獲取SQL語法
            //ResultSet.TYPE_SCROLL_INSENSITIVE:使結果可以來回查看
            //ResultSet.CONCUR_UPDATATABLE:指定可以更新結果集
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //設定資料長度
            // String str = "create table member (" + "id Integer primary key," + "name varchar(10)," + "sex varchar(10))";
            // statement.executeUpdate(str);

            //建立查詢物件
            ResultSet rs = statement.executeQuery(str);
            System.out.println("資料庫連線成功");

            while (rs.next()){
                System.out.println("第" + rs.getRow() + "筆");
                System.out.println(rs.getInt("id") + "\t");
                System.out.println(rs.getString("name") + "\t");
                System.out.println(rs.getString("sex") + "\t");
            }


        //System.out.println("member 資料表已建立");

        String[] str ={
//                "insert into mysql_DB.member(id,name,sex) values(2,\"jerry\",\"男\")"
        };

//        int count ;
//        for(String tmp:str){
//            count = statement.executeUpdate(tmp);
//            System.out.println("新增："+ count + "筆");
//        }
        //移到資料庫結尾
        rs.last();
        if (rs.isLast()){
            System.out.println("資料庫結尾");
        }

        //移到資料庫開頭
        rs.first();
        if (rs.isFirst()){
            System.out.println("資料庫結開頭");
        }

        //移到資料庫第二筆
        rs.absolute(2);
        System.out.println(rs.getString("name") + "\t");
        System.out.println();

        //取得欄位數量

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
    //關閉資料
    public static void close(Connection connection){
        try {
            connection.close();
            System.out.println("connection close.");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}