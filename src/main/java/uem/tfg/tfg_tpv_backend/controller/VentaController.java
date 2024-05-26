package uem.tfg.tfg_tpv_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uem.tfg.tfg_tpv_backend.model.Venta;
import uem.tfg.tfg_tpv_backend.service.VentaService;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        try {
            Venta createdVenta = ventaService.save(venta);
            return ResponseEntity.ok(createdVenta);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta updatedVenta) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            updatedVenta.setIdVenta(id); // Ensure the updated venta has the correct ID
            return ResponseEntity.ok(ventaService.save(updatedVenta));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            ventaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
