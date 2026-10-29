package cesur.dam.g1;

import cesur.dam.g1.data.DataSourceFactory;
import cesur.dam.g1.models.Equipo;
import cesur.dam.g1.data.EquipoJdbcDAO;
import java.util.Optional;

public class Main2 {
     static void main(String[] args) {

         var dao = new EquipoJdbcDAO(DataSourceFactory.getDataSource());
         Optional<Equipo> e = dao.findById(2L);

            e.ifPresent((Equipo equipo) -> {
                System.out.println("Equipo: " + equipo);

         });
     }
}
