package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.Cliente;
import pe.edu.upc.trabajoparcial.entities.DetallePedido;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

    @Query(value = "SELECT dp.* FROM detalle_pedido dp " +
            "INNER JOIN pedido p ON dp.id_pedido = p.id_pedido " +
            "INNER JOIN cliente c ON p.id_cliente = c.id_cliente " +
            "INNER JOIN users u ON c.id_usuario = u.id " +
            "WHERE u.id = :userId", nativeQuery = true)
    List<DetallePedido> findAllByUserId(@Param("userId") Long userId);

}