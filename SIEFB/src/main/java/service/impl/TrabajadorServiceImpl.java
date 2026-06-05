package service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Trabajador;
import repository.TrabajadorRepository;
import service.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	 @Autowired
	    private TrabajadorRepository trabajadorRepository;

	    @Override
	    public List<Trabajador> listar() {
	        return trabajadorRepository.findAll();
	    }

	    @Override
	    public Optional<Trabajador> obtenerPorId(Integer id) {
	        return trabajadorRepository.findById(id);
	    }

	    @Override
	    public Trabajador guardar(Trabajador trabajador) {
	        return trabajadorRepository.save(trabajador);
	    }

	    @Override
	    public Trabajador actualizar(Integer id, Trabajador trabajador) {
	        return trabajadorRepository.findById(id)
	            .map(t -> {
	                // Campos heredados de Persona
	                t.setDocumento(trabajador.getDocumento());
	                t.setNombre(trabajador.getNombre());
	                t.setDireccion(trabajador.getDireccion());
	                t.setTelefono(trabajador.getTelefono());
	                t.setActaMedica(trabajador.getActaMedica());
	                t.setEps(trabajador.getEps());
	                t.setFoto(trabajador.getFoto());
	                t.setFechaNacimiento(trabajador.getFechaNacimiento());

	                // Campos propios
	                t.setArl(trabajador.getArl());
	                t.setDiaIngreso(trabajador.getDiaIngreso());

	                return trabajadorRepository.save(t);
	            })
	            .orElseThrow(() -> new RuntimeException("Trabajador no encontrado con id: " + id));
	    }

	    @Override
	    public void eliminar(Integer id) {
	        trabajadorRepository.deleteById(id);
	    }
}
