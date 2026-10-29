package cesur.dam.g1.data;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {

    private static String url = "jdbc:mysql://localhost:3306/Acceso";
    private static final String username = System.getenv("USER");
    private static final String password = System.getenv("PASSWORD");

    private static DataSource ds = null;


    public static DataSource getDataSource() {
        if (ds == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            ds = dataSource;
        }
        return ds;
    }
}
