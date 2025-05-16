package pe.edu.upc.trabajoparcial.DTOs;




public class UsuarioDTO {

    private Integer idUsuario;
    private String nombre;
    private String password;
    private String correo;
    private boolean  enabled;

    // Constructor, getters y setters si es necesario


    public UsuarioDTO(Integer idUsuario, boolean enabled, String correo, String password, String nombre) {
        this.idUsuario = idUsuario;
        this.enabled = enabled;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}