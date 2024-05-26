package uem.tfg.tfg_tpv_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uem.tfg.tfg_tpv_backend.model.Empleado;
import uem.tfg.tfg_tpv_backend.repository.EmpleadoRepository;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Empleado findById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }
}
