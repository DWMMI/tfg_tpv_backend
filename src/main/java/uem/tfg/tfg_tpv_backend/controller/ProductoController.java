package uem.tfg.tfg_tpv_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uem.tfg.tfg_tpv_backend.model.Producto;
import uem.tfg.tfg_tpv_backend.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.findAll();
    }

    @GetMapping("/{codigoBarra}")
    public ResponseEntity<Producto> getProductoByCodigoBarra(@PathVariable String codigoBarra) {
        Producto producto = productoService.findByCodigoBarra(codigoBarra);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{CodigoBarra}")
    public Producto updateProducto(@PathVariable String codigoBarra, @RequestBody Producto producto) {
        producto.setCodigoBarra(codigoBarra);
        return productoService.save(producto);
    }

    @DeleteMapping("/{codigoBarra}")
    public ResponseEntity<Void> deleteProducto(@PathVariable String codigoBarra) {
        productoService.deleteByCodigoBarra(codigoBarra);
        return ResponseEntity.ok().build();
    }
}
