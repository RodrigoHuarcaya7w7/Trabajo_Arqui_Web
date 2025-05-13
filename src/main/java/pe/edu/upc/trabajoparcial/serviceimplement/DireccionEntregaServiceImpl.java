package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.DireccionEntrega;
import pe.edu.upc.trabajoparcial.repositories.DireccionEntregaRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.DireccionEntregaService;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionEntregaServiceImpl implements DireccionEntregaService {

    @Autowired
    private DireccionEntregaRepository direccionEntregaRepository;

    @Override
    public List<DireccionEntrega> findAll() {
        return direccionEntregaRepository.findAll();
    }

    @Override
    public Optional<DireccionEntrega> findById(Integer id) {
        return direccionEntregaRepository.findById(id);
    }

    @Override
    public DireccionEntrega save(DireccionEntrega direccionEntrega) {
        return direccionEntregaRepository.save(direccionEntrega);
    }

    @Override
    public void deleteById(Integer id) {
        direccionEntregaRepository.deleteById(id);
    }
}