package pe.edu.upc.trabajoparcial.serviceimplement;



import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.trabajoparcial.entities.Producto;
import pe.edu.upc.trabajoparcial.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.serviceinterface.ProductoService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class ProductoServiceImpl implements ProductoService {



    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }


    @Override
    public List<Producto> findByNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Producto> findByCategoria(String categoria) {
        return productoRepository.findByCategoriaNombreContainingIgnoreCase(categoria);
    }

    @Override
    public List<Producto> findByPrecioBetween(BigDecimal minPrecio, BigDecimal maxPrecio) {
        return productoRepository.findByPrecioBetween(minPrecio, maxPrecio);
    }

    @Override
    public List<Producto> findByVendedor(Integer idCliente) {
        return productoRepository.findByClienteIdCliente(idCliente);
    }
    @Override
    public List<Producto> topNProductosMasCaros(int topN) {
        Pageable page = PageRequest.of(0, topN);
        return productoRepository.findAllByOrderByPrecioDesc(page);
    }
}