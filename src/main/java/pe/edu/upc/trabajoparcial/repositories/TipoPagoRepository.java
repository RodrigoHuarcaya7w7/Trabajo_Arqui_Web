package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.TipoPago;
import pe.edu.upc.trabajoparcial.entities.Users;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer> {

}