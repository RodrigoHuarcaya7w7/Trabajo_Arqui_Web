package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.ImagenProducto;
import pe.edu.upc.trabajoparcial.repositories.ImagenProductoRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.ImagenProductoService;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenProductoServiceImpl implements ImagenProductoService {

    @Autowired
    private ImagenProductoRepository imagenProductoRepository;

    @Override
    public List<ImagenProducto> findAll() {
        return imagenProductoRepository.findAll();
    }

    @Override
    public Optional<ImagenProducto> findById(Integer id) {
        return imagenProductoRepository.findById(id);
    }

    @Override
    public ImagenProducto save(ImagenProducto imagenProducto) {
        return imagenProductoRepository.save(imagenProducto);
    }

    @Override
    public void deleteById(Integer id) {
        imagenProductoRepository.deleteById(id);
    }
}