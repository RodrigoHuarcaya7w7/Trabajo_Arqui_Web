package pe.edu.upc.trabajoparcial.DTOs;


public class RolDTO {

    private Integer idRol;
    private String rol;


    // Constructor, getters y setters si es necesario

    public RolDTO(){

    }

    public RolDTO(Integer idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}