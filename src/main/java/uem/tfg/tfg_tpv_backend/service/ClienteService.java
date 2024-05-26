package uem.tfg.tfg_tpv_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uem.tfg.tfg_tpv_backend.model.Cliente;
import uem.tfg.tfg_tpv_backend.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
