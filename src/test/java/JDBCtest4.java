import java.sql.*;

public class JDBCtest4 {
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

            SQL = "delete from datan" + " where firstname = 'Дмитрий' and city = 'Питер\'";

            sql = connection.createStatement();
            sql.execute(SQL);

            SQL = "select *  from datan";

            result = sql.executeQuery(SQL);

            while (result.next()) {
                String valueN = result.getString("firstname");
                String valueC = result.getString("city");

                System.out.println(valueN + " " + valueC);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            System.out.println("Соединение закрыто");
        }
    }
}