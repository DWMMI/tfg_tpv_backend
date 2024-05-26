package uem.tfg.tfg_tpv_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uem.tfg.tfg_tpv_backend.model.Producto;

@Repository

public interface ProductoRepository extends JpaRepository<Producto, String> {
    // Aquí puedes agregar métodos de consulta personalizados si es necesario
}
