package SIEFB.service.impl;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import SIEFB.model.Jugador;
import SIEFB.repository.JugadorRepository;
import SIEFB.repository.PersonaRepository;
import SIEFB.service.JugadorService;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
    private JugadorRepository jugadorRepository;
	
	@Autowired
	private PersonaRepository personaRepository;

    @Override
    public List<Jugador> listar() {
        return jugadorRepository.findAll();
    }

    @Override
    public Optional<Jugador> obtenerPorId(Integer id) {
        return jugadorRepository.findById(id);
    }

    @Override
    public Jugador guardar(Jugador jugador) {
    	if (personaRepository.existsByDocumento(jugador.getDocumento())) {
            throw new RuntimeException(
                "Ya existe una persona con el documento: " + jugador.getDocumento()
            );
        }

        return jugadorRepository.save(jugador);
    }

    @Override
    public Jugador actualizar(Integer id, Jugador jugador) {
    	return jugadorRepository.findById(id)
    	        .map(j -> {

    	            if (!j.getDocumento().equals(jugador.getDocumento()) &&
    	                personaRepository.existsByDocumento(jugador.getDocumento())) {

    	                throw new RuntimeException(
    	                    "Ya existe una persona con el documento: " + jugador.getDocumento()
    	                );
    	            }

    	            // heredados
    	            j.setDocumento(jugador.getDocumento());
    	            j.setNombre(jugador.getNombre());
    	            j.setDireccion(jugador.getDireccion());
    	            j.setTelefono(jugador.getTelefono());
    	            j.setActaMedica(jugador.getActaMedica());
    	            j.setEps(jugador.getEps());
    	            j.setFoto(jugador.getFoto());
    	            j.setFechaNacimiento(jugador.getFechaNacimiento());

    	            // propios
    	            j.setNombreAcudiente(jugador.getNombreAcudiente());
    	            j.setDiaInscripcion(jugador.getDiaInscripcion());

    	            return jugadorRepository.save(j);
    	        })
    	        .orElseThrow(() ->
    	            new RuntimeException("Jugador no encontrado con id: " + id)
    	        );
    }

    @Override
    public void eliminar(Integer id) {
        if (!jugadorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Jugador no encontrado con id: " + id);
        }
        jugadorRepository.deleteById(id);
    }
}
