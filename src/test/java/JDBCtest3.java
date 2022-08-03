import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCtest3 {
    private static Connection connection = null;
    //ввести адрес БД + добавить драйвера через Open Module Setting
    private static String URL = "jdbc:postgresql://localhost/postgres";
    // Ввести логин и пароль от БД
    private static String Username = "postgres";
    private static String password = "111";


    public static void main(String[] args) throws SQLException {
        Statement sql = null;
        ResultSet result = null;
        String value = "";
        String SQL = "";

        try {
            System.out.println("Соединение с БД");
            connection = DriverManager.getConnection(URL, Username, password);

            for (int i = 0; i < 3; i++){
                String city = "Челябинск";
            SQL = String.format("update datan"
                    + " set city = \'%s\'", city)
                    + " where city = \'Москва\' and personid between 0 and 10";

            sql = connection.createStatement();
            sql.execute(SQL);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            System.out.println("Соединение закрыто");
        }
    }
}
