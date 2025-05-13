package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajoparcial.entities.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}