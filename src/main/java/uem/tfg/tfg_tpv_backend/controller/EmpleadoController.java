package uem.tfg.tfg_tpv_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uem.tfg.tfg_tpv_backend.model.Empleado;
import uem.tfg.tfg_tpv_backend.service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        Empleado empleado = empleadoService.findById(id);
        return empleado != null ? ResponseEntity.ok(empleado) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Empleado createEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.save(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        empleado.setIdEmpleado(id);
        return ResponseEntity.ok(empleadoService.save(empleado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
