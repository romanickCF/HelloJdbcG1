package cesur.dam.g1;

import cesur.dam.g1.models.Equipo;
import cesur.dam.g1.models.EquipoJdbcDAO;

import java.util.List;
import java.util.Optional;

public class Main2 {
     public static void main(String[] args) {

         var dao = new EquipoJdbcDAO();
         Optional<Equipo> e = dao.findById(1);

            e.ifPresent((Equipo equipo) -> {
                dao.deleteById(equipo.getId());


         });
     }
}
