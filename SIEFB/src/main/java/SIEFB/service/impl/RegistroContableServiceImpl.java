package SIEFB.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import SIEFB.model.RegistroContable;
import SIEFB.repository.AdministradorRepository;
import SIEFB.repository.RegistroContableRepository;
import SIEFB.service.RegistroContableService;

@Service
public class RegistroContableServiceImpl implements RegistroContableService {

	@Autowired
    private RegistroContableRepository repository;
	
	@Autowired
	private AdministradorRepository administradorRepository;

    @Override
    public List<RegistroContable> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<RegistroContable> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public RegistroContable guardar(RegistroContable registro) {
    	Integer adminId = registro.getAdministrador().getId();

        if (adminId == null || !administradorRepository.existsById(adminId)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El administrador no existe con id: " + adminId
            );
        }

        return repository.save(registro);
    }

    @Override
    public RegistroContable actualizar(Integer id, RegistroContable registro) {
    	return repository.findById(id)
    	        .map(r -> {

    	            Integer adminId = registro.getAdministrador().getId();

    	            if (adminId == null || !administradorRepository.existsById(adminId)) {
    	                throw new ResponseStatusException(
    	                        HttpStatus.BAD_REQUEST,
    	                        "El administrador no existe con id: " + adminId
    	                );
    	            }

    	            r.setFecha(registro.getFecha());
    	            r.setCantidadPago(registro.getCantidadPago());
    	            r.setComprobante(registro.getComprobante());
    	            r.setTipo(registro.getTipo());
    	            r.setAdministrador(registro.getAdministrador());

    	            return repository.save(r);
    	        })
    	        .orElseThrow(() -> new ResponseStatusException(
    	                HttpStatus.NOT_FOUND,
    	                "Registro contable no encontrado con id: " + id
    	        ));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
