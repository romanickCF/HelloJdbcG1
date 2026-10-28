package cesur.dam.g1.models;

import cesur.dam.g1.data.DAO;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class EquipoJdbcDAO implements DAO<Equipo> {

    private String url = "jdbc:mysql://localhost:3306/Acceso";
    private String user = "root";
    private String password = "romanick";

    @Override
    public Optional<Equipo> findById(int id) {
        String sqlFind = "select * from Equipo where id=?";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sqlFind) )
        {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Equipo e = new Equipo();
                e.setId(rs.getLong("id"));
                e.setNombre(rs.getString("nombre"));
                e.setCategoria(rs.getString("categoria"));
                e.setDisponible(rs.getBoolean("disponible"));
                return Optional.of(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Equipo> findAll() {
        return List.of();
    }

    @Override
    public Equipo save(Equipo entity) {
        return null;
    }

    @Override
    public void update(Equipo entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
