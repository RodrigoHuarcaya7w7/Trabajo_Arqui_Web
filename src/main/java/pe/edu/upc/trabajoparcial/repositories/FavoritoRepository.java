package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {}