package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.entities.Productos;
import pe.edu.upc.trabajoparcial.entities.Roles;

public interface ProductosResitory extends JpaRepository<Productos, Long> {
//verificar//
  //QUERY JPQL: buscar producto por rango de precios
  @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :min AND :max")
    List<Productos> buscarPorRangoDePrecio(double min, double max)
}
