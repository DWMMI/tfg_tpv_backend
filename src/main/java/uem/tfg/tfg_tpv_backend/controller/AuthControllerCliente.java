package uem.tfg.tfg_tpv_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uem.tfg.tfg_tpv_backend.model.Cliente;
import uem.tfg.tfg_tpv_backend.service.ClienteService;

import java.util.Map;

@RestController
@RequestMapping("/auth/cliente")
public class AuthControllerCliente {

    @Autowired
    private ClienteService clienteService;
    @PostMapping
    public ResponseEntity<String> loginCliente(@RequestBody Map<String, String> loginRequest) {
        String idCliente = loginRequest.get("idCliente");
        String contrasena = loginRequest.get("contrasena");

        Cliente cliente = clienteService.findById(Long.parseLong(idCliente));

        if (cliente != null && cliente.getContrasena().equals(contrasena)) {
            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(401).body("failure");
        }
    }

}