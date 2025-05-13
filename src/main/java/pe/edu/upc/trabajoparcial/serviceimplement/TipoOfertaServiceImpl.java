package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.TipoOferta;
import pe.edu.upc.trabajoparcial.repositories.TipoOfertaRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.TipoOfertaService;

import java.util.List;
import java.util.Optional;

@Service
public class TipoOfertaServiceImpl implements TipoOfertaService {

    @Autowired
    private TipoOfertaRepository tipoOfertaRepository;

    @Override
    public List<TipoOferta> findAll() {
        return tipoOfertaRepository.findAll();
    }

    @Override
    public Optional<TipoOferta> findById(Integer id) {
        return tipoOfertaRepository.findById(id);
    }

    @Override
    public TipoOferta save(TipoOferta tipoOferta) {
        return tipoOfertaRepository.save(tipoOferta);
    }

    @Override
    public void deleteById(Integer id) {
        tipoOfertaRepository.deleteById(id);
    }
}