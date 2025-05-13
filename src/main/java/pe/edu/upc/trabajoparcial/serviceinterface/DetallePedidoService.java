package pe.edu.upc.trabajoparcial.serviceinterface;



import pe.edu.upc.trabajoparcial.entities.DetallePedido;

import java.util.List;
import java.util.Optional;

public interface DetallePedidoService {

    List<DetallePedido> findAll();

    Optional<DetallePedido> findById(Integer id);

    DetallePedido save(DetallePedido detallePedido);

    void deleteById(Integer id);
}