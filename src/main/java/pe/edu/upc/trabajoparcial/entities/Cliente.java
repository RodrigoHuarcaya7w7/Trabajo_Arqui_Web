package pe.edu.upc.trabajoparcial.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity


public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Users users;

    // Relación 1:N con Pedido (un cliente puede tener varios pedidos)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    // Relación 1:N con DireccionEntrega (un cliente puede tener varias direcciones)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DireccionEntrega> direcciones;

    public Cliente(){

    }

    public Cliente(Integer idCliente, Users users) {
        this.idCliente = idCliente;
        this.users = users;
    }




    public Users getUsuario() {
        return users;
    }

    public void setUsuario(Users usuario) {
        this.users = usuario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
// holasdfoaskfoaskfoaskofkasofkaskfokasofkasokfoaskfokasofk