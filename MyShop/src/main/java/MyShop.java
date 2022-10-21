
public class MyShop {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("jdbc init!");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("done.");
        System.out.println("今天放風");
    }
}
