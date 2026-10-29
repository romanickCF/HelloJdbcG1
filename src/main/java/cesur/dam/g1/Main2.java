package cesur.dam.g1;

import cesur.dam.g1.models.Equipo;
import cesur.dam.g1.data.EquipoJdbcDAO;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Optional;

public class Main2 {

    private static String url = "jdbc:mysql://localhost:3306/Acceso";
    private static String user = "root";
    private static String password = "romanick";

     public static void main(String[] args) {



         MysqlDataSource ds = new MysqlDataSource();
         ds.setURL(url);
         ds.setUser(user);
         ds.setPassword(password);


         var dao = new EquipoJdbcDAO(ds);
         Optional<Equipo> e = dao.findById(1);

            e.ifPresent((Equipo equipo) -> {
                dao.deleteById(equipo.getId());


         });
     }
}
