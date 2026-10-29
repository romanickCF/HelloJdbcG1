package cesur.dam.g1.data;

import cesur.dam.g1.models.Equipo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EquipoJdbcDAO implements DAO<Equipo> {


    private static final String SQL_FIND_BY_ID = "SELECT * FROM Equipo WHERE id = ?";
    private static final String SQL_FIND_ALL = "SELECT * FROM Equipo";
    private static final String SQL_INSERT = "INSERT INTO Equipo (nombre, categoria, disponible) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Equipo SET nombre = ?, categoria = ?, disponible = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM Equipo WHERE id = ?";
    private final DataSource ds;

    public EquipoJdbcDAO( DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Equipo> findById(int id) {

        try(Connection conn = ds.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL_FIND_BY_ID) )
        {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Equipo e = new Equipo();
                return Optional.of(mapper(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Equipo> findAll() {
        List<Equipo> listaEquipos = new ArrayList<>();
        try(Connection conn = ds.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL_FIND_ALL) )
        {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                listaEquipos.add(mapper(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaEquipos;
    }

    //Metodo auxiliar
    private static Equipo mapper( ResultSet rs) throws SQLException {
        Equipo e = new Equipo();
        e.setId(rs.getLong("id"));
        e.setNombre(rs.getString("nombre"));
        e.setCategoria(rs.getString("categoria"));
        e.setDisponible(rs.getBoolean("disponible"));
        return e;
    }

    @Override
    public Equipo save(Equipo entity) {
        try(Connection conn =ds.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL_INSERT) )
        {
            pst.setString(1, entity.getNombre());
            pst.setString(2, entity.getCategoria());
            pst.setBoolean(3, entity.getDisponible());
            int result = pst.executeUpdate();
            System.out.println("Filas afectadas : "+result);
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Equipo update(Equipo entity) {
        try(Connection conn = ds.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL_UPDATE) )
        {
            pst.setString(1, entity.getNombre());
            pst.setString(2, entity.getCategoria());
            pst.setBoolean(3, entity.getDisponible());
            pst.setLong(4, entity.getId());
            int result = pst.executeUpdate();
            System.out.println("Filas afectadas : "+result);

            if (result > 0) {
                Equipo e = new Equipo();
                e.setId(entity.getId());
                e.setNombre(entity.getNombre());
                e.setCategoria(entity.getCategoria());
                e.setDisponible(entity.getDisponible());
                return e;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try(Connection conn =ds.getConnection();
            PreparedStatement pst = conn.prepareStatement(SQL_DELETE) )
        {
            pst.setLong(1, id);
            int result = pst.executeUpdate();
            System.out.println("Filas afectadas : "+result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
