package uem.tfg.tfg_tpv_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uem.tfg.tfg_tpv_backend.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Aquí se pueden incluir consultas específicas basadas en los campos de Empleado
}
