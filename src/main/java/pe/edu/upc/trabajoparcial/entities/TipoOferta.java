package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoOferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoOferta;
    private String nombre;
    private String descripcion;
    private Float importe;
}