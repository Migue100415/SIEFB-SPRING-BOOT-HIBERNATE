package SIEFB.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SIEFB.model.Administrador;
import SIEFB.repository.AdministradorRepository;
import SIEFB.repository.PersonaRepository;
import SIEFB.service.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
    private AdministradorRepository administradorRepository;
	
	@Autowired
	private PersonaRepository personaRepository;

    @Override
    public List<Administrador> listar() {
        return administradorRepository.findAll();
    }

    @Override
    public Optional<Administrador> obtenerPorId(Integer id) {
        return administradorRepository.findById(id);
    }

    @Override
    public Administrador guardar(Administrador administrador) {
    	if (personaRepository.existsByDocumento(administrador.getDocumento())) {
            throw new RuntimeException(
                "Ya existe una persona con el documento: " + administrador.getDocumento()
            );
        }

        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador actualizar(Integer id, Administrador administrador) {
    	return administradorRepository.findById(id)
    	        .map(a -> {

    	            if (!a.getDocumento().equals(administrador.getDocumento()) &&
    	                personaRepository.existsByDocumento(administrador.getDocumento())) {

    	                throw new RuntimeException(
    	                    "Ya existe una persona con el documento: " + administrador.getDocumento()
    	                );
    	            }

    	            // Persona
    	            a.setDocumento(administrador.getDocumento());
    	            a.setNombre(administrador.getNombre());
    	            a.setDireccion(administrador.getDireccion());
    	            a.setTelefono(administrador.getTelefono());
    	            a.setActaMedica(administrador.getActaMedica());
    	            a.setEps(administrador.getEps());
    	            a.setFoto(administrador.getFoto());
    	            a.setFechaNacimiento(administrador.getFechaNacimiento());

    	            // Trabajador
    	            a.setArl(administrador.getArl());
    	            a.setDiaIngreso(administrador.getDiaIngreso());

    	            return administradorRepository.save(a);
    	        })
    	        .orElseThrow(() ->
    	            new RuntimeException("Administrador no encontrado con id: " + id)
    	        );
    }

    @Override
    public void eliminar(Integer id) {
    	if (!administradorRepository.existsById(id)) {
            throw new RuntimeException("Administrador no encontrado con id: " + id);
        }
        administradorRepository.deleteById(id);
    }
}
