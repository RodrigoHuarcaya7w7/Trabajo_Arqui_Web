package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.TipoOferta;

public interface TipoOfertaRepository extends JpaRepository<TipoOferta, Integer> {}