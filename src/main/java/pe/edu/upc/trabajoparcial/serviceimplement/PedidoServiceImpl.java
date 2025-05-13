package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.Pedido;
import pe.edu.upc.trabajoparcial.repositories.PedidoRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.PedidoService;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findById(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void deleteById(Integer id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<Pedido> findByCliente(Integer idCliente) {
        return pedidoRepository.findByClienteIdCliente(idCliente);
    }


    @Override
    public List<Pedido> findByEstado(String estado) {
        return pedidoRepository.findByEstado(estado);  // Llamada al repositorio para obtener pedidos por estado
    }
}