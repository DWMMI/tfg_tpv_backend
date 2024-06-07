package uem.tfg.tfg_tpv_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uem.tfg.tfg_tpv_backend.model.Venta;
import uem.tfg.tfg_tpv_backend.repository.VentaRepository;
import uem.tfg.tfg_tpv_backend.repository.EmpleadoRepository;
import uem.tfg.tfg_tpv_backend.repository.ClienteRepository;
import uem.tfg.tfg_tpv_backend.repository.ProductoRepository;
import uem.tfg.tfg_tpv_backend.model.Empleado;
import uem.tfg.tfg_tpv_backend.model.Cliente;
import uem.tfg.tfg_tpv_backend.model.Producto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    public Venta findById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Venta save(Venta venta) {
        // Verificar existencia de Empleado
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(venta.getEmpleado().getIdEmpleado());
        if (!empleadoOpt.isPresent()) {
            throw new RuntimeException("Empleado no encontrado");
        }

        // Asignar el empleado encontrado a la venta
        venta.setEmpleado(empleadoOpt.get());

        // Verificar existencia de Cliente si no es null
        if (venta.getCliente() != null) {
            Optional<Cliente> clienteOpt = clienteRepository.findById(venta.getCliente().getIdCliente());
            if (!clienteOpt.isPresent()) {
                throw new RuntimeException("Cliente no encontrado");
            }
            // Asignar el cliente encontrado a la venta
            venta.setCliente(clienteOpt.get());
        }

        // Verificar existencia de Productos
        List<Producto> productosVerificados = venta.getProductos().stream()
                .map(producto -> {
                    Optional<Producto> productoOpt = productoRepository.findById(producto.getCodigoBarra());
                    if (!productoOpt.isPresent()) {
                        throw new RuntimeException("Producto no encontrado: " + producto.getCodigoBarra());
                    }
                    return productoOpt.get();
                })
                .collect(Collectors.toList());

        // Asignar los productos verificados a la venta
        venta.setProductos(productosVerificados);

        // Guardar la venta en el repositorio
        return ventaRepository.save(venta);
    }

    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }
}
