package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.trabajoparcial.entities.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
    // Cambiar de findByNombre a findByUsername

    @Query("SELECT u FROM Users u JOIN FETCH u.roles WHERE u.username = :username")
    Optional<Users> findFirstByUsername(@Param("username") String username);


    @Query("select count(u.username) from Users u where u.username = :username")
    public int buscarUsername(@Param("username") String username);

   /* Optional<Users> findFirstByUsername(String username);*/

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :idUser)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("idUser") Long idUser);

    // Método básico que usas en el login o para buscar por username
    Users findByUsername(String username);

    // Opcional: con roles si necesitas obtenerlos en el login
    @Query("SELECT u FROM Users u LEFT JOIN FETCH u.roles WHERE u.username = :username")
    Users findByUsernameWithRoles(@Param("username") String username);


}