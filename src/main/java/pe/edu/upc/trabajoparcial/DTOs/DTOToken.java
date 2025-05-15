package pe.edu.upc.trabajoparcial.DTOs;

public class DTOToken {
    private String jwt;
    private Long id;
    private String authorities;

    public DTOToken() {
    }

    // 🔹 Constructor solo con JWT (para AuthController)
    public DTOToken(String jwt) {
        this.jwt = jwt;
    }

    // 🔹 Constructor completo (para login con id y roles)
    public DTOToken(String jwt, Long id, String authorities) {
        this.jwt = jwt;
        this.id = id;
        this.authorities = authorities;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
