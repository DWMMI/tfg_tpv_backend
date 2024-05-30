package uem.tfg.tfg_tpv_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uem.tfg.tfg_tpv_backend.model.Empleado;
import uem.tfg.tfg_tpv_backend.service.EmpleadoService;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        String idEmpleado = loginRequest.get("idEmpleado");
        String contrasena = loginRequest.get("contrasena");

        Empleado empleado = empleadoService.findById(Long.parseLong(idEmpleado));

        if (empleado != null && empleado.getContrasena().equals(contrasena)) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(401).body("failure");
        }
    }
}

