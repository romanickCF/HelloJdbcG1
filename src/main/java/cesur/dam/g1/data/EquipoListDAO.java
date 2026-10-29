package cesur.dam.g1.data;

import cesur.dam.g1.models.Equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipoListDAO implements DAO<Equipo> {

    private List<Equipo> equipoList = new ArrayList<>(List.of(
            crearEquipo(0L, "Proyector Epson", "Audiovisual", true),
            crearEquipo(1L, "Monitor LG 27\"", "Informática", false),
            crearEquipo(2L, "Impresora HP", "Oficina", true),
            crearEquipo(3L, "Tablet Samsung", "Informática", false),
            crearEquipo(4L, "Portátil Lenovo ThinkPad", "Informática", true),
            crearEquipo(5L, "Altavoz Bose", "Audiovisual", true),
            crearEquipo(6L, "Cámara Canon EOS", "Audiovisual", false),
            crearEquipo(7L, "Escáner Epson", "Oficina", true),
            crearEquipo(8L, "Teclado Logitech", "Informática", true),
            crearEquipo(9L, "Ratón Razer", "Informática", true),
            crearEquipo(10L, "Pizarra Digital Smart", "Audiovisual", false),
            crearEquipo(11L, "Trituradora de papel", "Oficina", true),
            crearEquipo(12L, "Micrófono Shure", "Audiovisual", true),
            crearEquipo(13L, "Disco duro externo WD", "Informática", false),
            crearEquipo(14L, "Fotocopiadora Ricoh", "Oficina", true),
            crearEquipo(15L, "Webcam Logitech", "Informática", true),
            crearEquipo(16L, "Televisor Samsung 55\"", "Audiovisual", false),
            crearEquipo(17L, "Grapadora eléctrica", "Oficina", true),
            crearEquipo(18L, "Router TP-Link", "Informática", true),
            crearEquipo(19L, "Plastificadora", "Oficina", false)
    ));

    private static Equipo crearEquipo(long id, String nombre, String categoria, boolean disponible) {
        Equipo equipo = new Equipo();
        equipo.setId(id);
        equipo.setNombre(nombre);
        equipo.setCategoria(categoria);
        equipo.setDisponible(disponible);
        return equipo;
    }


    @Override
    public Optional<Equipo> findById(Long id) {
        return equipoList.stream().filter(equipo -> equipo.getId()
                .equals(id))
                .findFirst();
    }

    @Override
    public List<Equipo> findAll() {
        return equipoList;
    }

    @Override
    public Equipo save(Equipo entity) {
        if (entity.getId() == null) {
            long nextId = equipoList.stream()
                    .mapToLong(Equipo::getId)
                    .max()
                    .orElse(0L) + 1L;

            entity.setId(nextId);
        }
        return entity;
    }

    @Override
    public Equipo update(Equipo entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Equipo> findByName(String nombre) {

        return Optional.of((Equipo) equipoList.stream()
                .filter(e-> e.getNombre().equals(nombre))
                .toList());
    }

    @Override
    public List<Equipo> findByCategory(String categoria) {
        List<Equipo> equipos = new ArrayList<>();
        for (Equipo equipo : equipoList) {
            if (equipo.getCategoria().equals(categoria)) {
                equipos.add(equipo);
            }
        }
        return equipos;
    }

    static void main(){
     var equipoListDAO = new EquipoListDAO();

     List<Equipo> a = equipoListDAO.findByCategory("Informática");
     List<Equipo> b = equipoListDAO.findByCategory("Proyector Epson");
        System.out.println(a);
    }
}



    /*

    Añadir metodos adicionales
    - List<Equipo> finByName()
    - List<Equipo> finByCategory

    */


