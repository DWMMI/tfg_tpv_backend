package uem.tfg.tfg_tpv_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uem.tfg.tfg_tpv_backend.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Puedes agregar consultas para buscar ventas por diferentes criterios
}
