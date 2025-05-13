package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.OfertaTipoProducto;
import pe.edu.upc.trabajoparcial.repositories.OfertaTipoProductoRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.OfertaTipoProductoService;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaTipoProductoServiceImpl implements OfertaTipoProductoService {

    @Autowired
    private OfertaTipoProductoRepository ofertaTipoProductoRepository;

    @Override
    public List<OfertaTipoProducto> findAll() {
        return ofertaTipoProductoRepository.findAll();
    }

    @Override
    public Optional<OfertaTipoProducto> findById(Integer id) {
        return ofertaTipoProductoRepository.findById(id);
    }

    @Override
    public OfertaTipoProducto save(OfertaTipoProducto ofertaTipoProducto) {
        return ofertaTipoProductoRepository.save(ofertaTipoProducto);
    }

    @Override
    public void deleteById(Integer id) {
        ofertaTipoProductoRepository.deleteById(id);
    }
}