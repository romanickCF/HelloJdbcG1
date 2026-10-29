package cesur.dam.g1.data;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {

    private static String url = "jdbc:mysql://localhost:3306/Acceso";
    private static String user = "root";
    private static String password = "romanick";

    private static DataSource ds = null;


    public static DataSource getDataSource() {
        if (ds == null) {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setURL("url");
            ds.setUser("username");
            ds.setPassword("password");
        }
        return ds;
    }
}
