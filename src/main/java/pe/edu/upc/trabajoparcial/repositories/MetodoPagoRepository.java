package pe.edu.upc.trabajoparcial.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.ImagenProducto;
import pe.edu.upc.trabajoparcial.entities.MetodoPago;

import java.util.List;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

    // Buscar métodos de pago por tipo
    List<MetodoPago> findByTipoPagoNombrePago(String nombrePago);
}