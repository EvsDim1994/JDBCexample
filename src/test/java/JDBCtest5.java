import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCtest5 {
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
            //запрос на создание таблицы №2 для проверки join
            SQL = "CREATE TABLE datan2 (PersonID int, FirstName varchar(255), Goods varchar(255));";
            sql = connection.createStatement();
            sql.execute(SQL);

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


            List<String> goods = new ArrayList<>();
            goods.add("Кровать");
            goods.add("Стул");
            goods.add("Посуда");
            goods.add("Кровать");
            goods.add("Посуда");
            goods.add("Стул");
            goods.add("Кровать");
            goods.add("Диван");
            goods.add("Кресло");
            goods.add("Стол");

                for (int i = 0; i < 10; i++) {
                String name = names.get(i);
                String good = goods.get(i);
                //запрос на добавление в таблицу
                SQL = String.format("INSERT INTO datan2 (personid, firstname, goods)"
                        + " VALUES ('%s', '%s', '%s')", i, name, good);

                sql.execute(SQL);
            }

                SQL = "select datan2.personid, datan2.goods, datan.city"
                        + " from datan2"
                        + " right join datan on datan.personid = datan2.personid"
                        + " order by datan.city";

                result = sql.executeQuery(SQL);

                while (result.next()){
                    int perid = result.getInt("personid");
                    String city = result.getString("city");
                    String goods2 = result.getString("goods");

                    System.out.println(perid +" "+ city + " " + goods2);
                }

        }

        catch(Exception e){
                e.printStackTrace();
            } finally{
                connection.close();
                System.out.println("Соединение закрыто");
            }
    }
}