package cesur.dam.g1;

import cesur.dam.g1.data.DataSourceFactory;
import cesur.dam.g1.models.Equipo;
import cesur.dam.g1.data.EquipoJdbcDAO;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.util.Optional;

public class Main2 {
     public static void main(String[] args) {

         var dao = new EquipoJdbcDAO(DataSourceFactory.getDataSource());
         Optional<Equipo> e = dao.findById(2L);

            e.ifPresent((Equipo equipo) -> {
                System.out.println("Equipo: " + equipo);

         });
     }
}
