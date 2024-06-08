package uem.tfg.tfg_tpv_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uem.tfg.tfg_tpv_backend.model.Localizacion;

public interface LocalizacionRepository extends JpaRepository<Localizacion, Long> {
}