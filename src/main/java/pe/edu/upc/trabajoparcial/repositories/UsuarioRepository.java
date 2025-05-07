package pe.edu.upc.trabajoparcial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import pe.edu.upc.trabajoparcial.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {}
=======
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.trabajoparcial.entities.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Cambiado a findByNombre
    public Usuario findByNombre(String nombre);

    @Query("select count(u.nombre) from Usuario u where u.nombre =:nombre")
    public int buscarUsername(@Param("nombre") String nombre);

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, idUser) VALUES (:rol, :idUser)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("idUser") Long idUser);

    @Query(value = "select u.id, u.nombre, u.apellidos, u.correo, u.telefono, c.detalle_contrato, c.estadocontrato " +
            "from usuario u " +
            "inner join contrato c ON u.id = c.id " +
            "where c.estadocontrato = 'Activo';", nativeQuery = true)
    public List<String[]> usuariocontraroactivo();

    @Query(value = "select u.nombre as Nombre_Usuario, s.categoria_servic as Categoria_Servicio from usuario u " +
            "inner join contrato_usuario cu on cu.id_user = u.id " +
            "inner join contrato c on c.id= cu.id_contrato " +
            "inner join servicio s on s.id_contrato=c.id " +
            "where s.categoria_servic = :categoria", nativeQuery = true)
    public List<String[]> listarUsuariosPorCategoria(@Param("categoria") String categoria);

}
>>>>>>> 71a9f39d081c8bd8f80e51f5bc95c093f0eaff2f
