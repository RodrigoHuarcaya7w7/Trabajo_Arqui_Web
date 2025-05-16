package pe.edu.upc.trabajoparcial.entities;
import jakarta.persistence.*;


@Entity


@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;  // Este debe ser el identificador primario

    private String nombre;
    private String descripcion;

    public Categoria() {
    }
    public Categoria(Integer idCategoria, String descripcion, String nombre) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}