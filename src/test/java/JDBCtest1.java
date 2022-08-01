import java.sql.*;

public class JDBCtest1 {

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
            connection = DriverManager.getConnection(URL,Username,password);

            //запрос на создание таблицы
          /* SQL = "CREATE TABLE  (PersonID int, FirstName varchar(255), City varchar(255));";*/

            //запрос на добавление в таблицу
           SQL = "INSERT INTO persons (personid, firstname, city)"
                    + "VALUES ('5', 'Дмитрий', 'Калуга');";

            sql = connection.createStatement();

            sql.execute(SQL);

        }  catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
            System.out.println("Соединение закрыто");
        }
    }


}
