package uem.tfg.tfg_tpv_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TfgTpvBackendApplication {

    public static void main(String[] args) {
        System.out.println("Servicio Rest -> Cargando el contexto de Spring...");
        SpringApplication.run(TfgTpvBackendApplication.class, args);
        System.out.println("Servicio Rest -> Contexto de Spring cargado!");
    }

}
