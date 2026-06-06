package SIEFB.service.impl;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SIEFB.model.Persona;
import SIEFB.repository.PersonaRepository;
import SIEFB.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	 @Autowired
	    private PersonaRepository personaRepository;

	    @Override
	    public List<Persona> listar() {
	        return personaRepository.findAll();
	    }

	    @Override
	    public Optional<Persona> obtenerPorId(Integer id) {
	        return personaRepository.findById(id);
	    }

	    @Override
	    public Persona guardar(Persona persona) {
	    	// Validar si ya existe el documento
	        if (personaRepository.existsByDocumento(persona.getDocumento())) {
	            throw new RuntimeException("Ya existe una persona con el documento: " 
	                                       + persona.getDocumento());
	        }

	        return personaRepository.save(persona);
	    }

	    @Override
	    public Persona actualizar(Integer id, Persona persona) {
	    	return personaRepository.findById(id)
	    	        .map(p -> {

	    	            // Validar documento si fue cambiado
	    	            if (!p.getDocumento().equals(persona.getDocumento()) &&
	    	                personaRepository.existsByDocumento(persona.getDocumento())) {

	    	                throw new RuntimeException("Ya existe una persona con el documento: "
	    	                                            + persona.getDocumento());
	    	            }

	    	            p.setDocumento(persona.getDocumento());
	    	            p.setNombre(persona.getNombre());
	    	            p.setDireccion(persona.getDireccion());
	    	            p.setTelefono(persona.getTelefono());
	    	            p.setActaMedica(persona.getActaMedica());
	    	            p.setEps(persona.getEps());
	    	            p.setFoto(persona.getFoto());
	    	            p.setFechaNacimiento(persona.getFechaNacimiento());

	    	            return personaRepository.save(p);
	    	        })
	    	        .orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));
	    }

	    @Override
	    public void eliminar(Integer id) {
	    	if (!personaRepository.existsById(id)) {
	    	    throw new RuntimeException("Persona no encontrada con id: " + id);
	    	}
	    	personaRepository.deleteById(id);
	    }
}
