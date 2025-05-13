package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.TipoPago;
import pe.edu.upc.trabajoparcial.repositories.TipoPagoRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.TipoPagoService;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPagoServiceImpl implements TipoPagoService {

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    @Override
    public List<TipoPago> findAll() {
        return tipoPagoRepository.findAll();
    }

    @Override
    public Optional<TipoPago> findById(Integer id) {
        return tipoPagoRepository.findById(id);
    }

    @Override
    public TipoPago save(TipoPago tipoPago) {
        return tipoPagoRepository.save(tipoPago);
    }

    @Override
    public void deleteById(Integer id) {
        tipoPagoRepository.deleteById(id);
    }
}