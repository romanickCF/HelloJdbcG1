package cesur.dam.g1;

import cesur.dam.g1.models.Equipo;
import cesur.dam.g1.models.EquipoJdbcDAO;

import java.util.Optional;

public class Main2 {
     public static void main(String[] args) {

         var dao = new EquipoJdbcDAO();
         Optional<Equipo> equipo = dao.findById(1);

         if (equipo.isPresent()) {
             System.out.println(equipo.get());
         } else {
             System.out.println("Equipo no encontrado");
         }
     }
}
