package pe.edu.upc.trabajoparcial.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos")
    private int id_pedidos;
    
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    
    @Column(name = "monto", nullable = false)
    private float monto;
    
    @Column(name = "fecha_pago")
    private LocalDateTime fecha_pago;
    
    @Column(name = "id_cliente", nullable = false)
    private int id_cliente;
    
    @Column(name = "id_cliente_Pago", nullable = false)
    private int id_cliente_Pago;
}
