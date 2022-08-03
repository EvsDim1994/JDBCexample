import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
          SQL = "CREATE TABLE datan (PersonID int, FirstName varchar(255), City varchar(255));";
          sql = connection.createStatement();
          sql.execute(SQL);



            List<String> cities = new ArrayList<>();
            cities.add("Москва");
            cities.add("Калуга");
            cities.add("Волгоград");
            cities.add("Питер");
            cities.add("Воронеж");
            cities.add("Ростов");
            cities.add("Иркутск");
            cities.add("Калуга");
            cities.add("Москва");
            cities.add("Калуга");

            List<String> names = new ArrayList<>();
            names.add("Вадим");
            names.add("Анатолий");
            names.add("Эдуард");
            names.add("Дмитрий");
            names.add("Андрей");
            names.add("Вадим");
            names.add("Петр");
            names.add("Влад");
            names.add("Ашот");
            names.add("Карен");

            for (int i = 0; i < 10; i++) {
                String city = cities.get(i);
                String name = names.get(i);
                //запрос на добавление в таблицу
                SQL = String.format("INSERT INTO datan (personid, firstname, city)"
                        + "VALUES ('%s', '%s', '%s')", i, name, city );

                sql.execute(SQL);
            }

        }  catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
            System.out.println("Соединение закрыто");
        }
    }


}
