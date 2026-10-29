package cesur.dam.g1.models;

import lombok.Data;

@Data
public class Equipo {

    private Long id;
    private String nombre;
    private String categoria;
    private Boolean disponible;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public Boolean getDisponible() {
        return disponible;
    }
}
