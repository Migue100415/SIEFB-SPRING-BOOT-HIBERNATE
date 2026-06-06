package SIEFB.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SIEFB.model.ProfesionalDeportivo;
import SIEFB.repository.PersonaRepository;
import SIEFB.repository.ProfesionalDeportivoRepository;
import SIEFB.service.ProfesionalDeportivoService;

@Service
public class ProfesionalDeportivoServiceImpl implements ProfesionalDeportivoService {

	 @Autowired
	    private ProfesionalDeportivoRepository profesionalRepository;
	 
	 @Autowired
	 private PersonaRepository personaRepository;

	    @Override
	    public List<ProfesionalDeportivo> listar() {
	        return profesionalRepository.findAll();
	    }

	    @Override
	    public Optional<ProfesionalDeportivo> obtenerPorId(Integer id) {
	        return profesionalRepository.findById(id);
	    }

	    @Override
	    public ProfesionalDeportivo guardar(ProfesionalDeportivo profesional) {
	    	if (personaRepository.existsByDocumento(profesional.getDocumento())) {
	            throw new RuntimeException(
	                "Ya existe una persona con el documento: " + profesional.getDocumento()
	            );
	        }

	        return profesionalRepository.save(profesional);
	    }

	    @Override
	    public ProfesionalDeportivo actualizar(Integer id, ProfesionalDeportivo profesional) {
	    	return profesionalRepository.findById(id)
	    	        .map(p -> {

	    	            if (!p.getDocumento().equals(profesional.getDocumento()) &&
	    	                personaRepository.existsByDocumento(profesional.getDocumento())) {

	    	                throw new RuntimeException(
	    	                    "Ya existe una persona con el documento: " + profesional.getDocumento()
	    	                );
	    	            }

	    	            // Persona
	    	            p.setDocumento(profesional.getDocumento());
	    	            p.setNombre(profesional.getNombre());
	    	            p.setDireccion(profesional.getDireccion());
	    	            p.setTelefono(profesional.getTelefono());
	    	            p.setActaMedica(profesional.getActaMedica());
	    	            p.setEps(profesional.getEps());
	    	            p.setFoto(profesional.getFoto());
	    	            p.setFechaNacimiento(profesional.getFechaNacimiento());

	    	            // Trabajador
	    	            p.setArl(profesional.getArl());
	    	            p.setDiaIngreso(profesional.getDiaIngreso());

	    	            return profesionalRepository.save(p);
	    	        })
	    	        .orElseThrow(() ->
	    	            new RuntimeException("Profesional Deportivo no encontrado con id: " + id)
	    	        );
	    }

	    @Override
	    public void eliminar(Integer id) {
	    	if (!profesionalRepository.existsById(id)) {
	            throw new RuntimeException("Profesional Deportivo no encontrado con id: " + id);
	        }
	        profesionalRepository.deleteById(id);
	    }
}
