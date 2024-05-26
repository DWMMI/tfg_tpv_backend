package uem.tfg.tfg_tpv_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uem.tfg.tfg_tpv_backend.model.Producto;
import uem.tfg.tfg_tpv_backend.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findByCodigoBarra(String codigoBarra) {
        return productoRepository.findById(codigoBarra).orElse(null);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteByCodigoBarra(String codigoBarra) {
        productoRepository.deleteById(codigoBarra);
    }
}
