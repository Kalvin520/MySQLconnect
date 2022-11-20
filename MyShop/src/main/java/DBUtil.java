import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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


    //SQLset
    static String strset = "create table member (" + "id Integer primary key," + "name varchar(10)," + "sex varchar(10))";

    //SQLcre
    static String strcre = "insert into mysql_DB.member (id, name, sex) values (?, ?, ?)";

    //SQL查詢語法
    static String strRead = " select * from mysql_DB.member  ";

    //SQL更新語法
    static String strUpdate = " update mysql_DB.member set name = 'kevin' where name = 'john' ";

    //SQL刪除語法
    static String strDel = " delete from mysql_DB.member where name = 'kevin' ";



    //建立取得資料庫連街物件靜態方法
    public static  Connection getConnection() {
        //取得資料庫連接物件
        Connection connection = null;
        try {
            //與資料庫連接
            connection = DriverManager.getConnection(url, user, password);

            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();

            //獲取SQL語法
            PreparedStatement preparedStatement = connection.prepareStatement(strcre);
            System.out.println("connection open.");


            //新增物件
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"john");
            preparedStatement.setString(3,"男");
            int countcre = preparedStatement.executeUpdate();
            System.out.println("新增："+ countcre + "筆");

            //查詢物件
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);
            jdbcRowSet.setCommand(strRead);
            jdbcRowSet.execute();
            while (jdbcRowSet.next()){
                System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getString(3));
            }

            //更新物件
            int countup = preparedStatement.executeUpdate(strUpdate);
            System.out.println("更新" + countup +"筆");

            //刪除物件
//            int countdel = preparedStatement.executeUpdate(strDel);
//            System.out.println("刪除" + countdel +"筆");
//
            System.out.println("member表格重新完成部署");

//        //取得欄位數量
//        int columns = rs.getMetaData().getColumnCount();
//        for (int i = 1; i <= columns; i++){
//            System.out.print(rs.getMetaData().getColumnName(i) + ":");//取得欄位名稱
//            System.out.println(rs.getMetaData().getColumnTypeName(i));//取得欄位資料型態
//        }




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