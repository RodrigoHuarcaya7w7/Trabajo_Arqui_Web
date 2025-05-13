package pe.edu.upc.trabajoparcial.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajoparcial.entities.Role;
import pe.edu.upc.trabajoparcial.repositories.RolRepository;
import pe.edu.upc.trabajoparcial.serviceinterface.RolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Role> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return rolRepository.findById(id);
    }

    @Override
    public Role save(Role rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void deleteById(Integer id) {
        rolRepository.deleteById(id);
    }
}