package pe.edu.upc.trabajoparcial.serviceinterface;



import pe.edu.upc.trabajoparcial.entities.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> findAll();

    Optional<Pedido> findById(Integer id);

    Pedido save(Pedido pedido);

    void deleteById(Integer id);

    List<Pedido> findByCliente(Integer idCliente);

    List<Pedido> findByEstado(String estado);


}