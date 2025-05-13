package pe.edu.upc.trabajoparcial.serviceinterface;


import pe.edu.upc.trabajoparcial.entities.Users;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Users> findAll();

    Users findById(Long id);

    public Users addUser(Users user);
/**/
 public Users findByUsername(String username);
    /**/
    void deleteById(Integer id);

    //////////////////////////////////
    public void insert (Users usuario); //crear nuevos usuarios

    public List<Users> list();

    public void delete (int id);

    public Users listid(int id);
}