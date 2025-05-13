package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.MetodoPago;
import pe.edu.upc.trabajoparcial.repositories.MetodoPagoRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.MetodoPagoService;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public Optional<MetodoPago> findById(Integer id) {
        return metodoPagoRepository.findById(id);
    }

    @Override
    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    public void deleteById(Integer id) {
        metodoPagoRepository.deleteById(id);
    }
}