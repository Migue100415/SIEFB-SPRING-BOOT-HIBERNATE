package service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ProfesionalDeportivo;
import repository.ProfesionalDeportivoRepository;
import service.ProfesionalDeportivoService;

@Service
public class ProfesionalDeportivoServiceImpl implements ProfesionalDeportivoService {

	 @Autowired
	    private ProfesionalDeportivoRepository profesionalRepository;

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
	        return profesionalRepository.save(profesional);
	    }

	    @Override
	    public ProfesionalDeportivo actualizar(Integer id, ProfesionalDeportivo profesional) {
	        return profesionalRepository.findById(id)
	            .map(p -> {
	                // Campos heredados de Persona
	                p.setDocumento(profesional.getDocumento());
	                p.setNombre(profesional.getNombre());
	                p.setDireccion(profesional.getDireccion());
	                p.setTelefono(profesional.getTelefono());
	                p.setActaMedica(profesional.getActaMedica());
	                p.setEps(profesional.getEps());
	                p.setFoto(profesional.getFoto());
	                p.setFechaNacimiento(profesional.getFechaNacimiento());

	                // Campos heredados de Trabajador
	                p.setArl(profesional.getArl());
	                p.setDiaIngreso(profesional.getDiaIngreso());

	                return profesionalRepository.save(p);
	            })
	            .orElseThrow(() -> new RuntimeException("Profesional Deportivo no encontrado con id: " + id));
	    }

	    @Override
	    public void eliminar(Integer id) {
	        profesionalRepository.deleteById(id);
	    }
}
