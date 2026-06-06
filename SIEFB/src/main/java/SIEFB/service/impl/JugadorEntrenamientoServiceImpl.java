package SIEFB.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import SIEFB.model.JugadorEntrenamiento;
import SIEFB.repository.EntrenamientoRepository;
import SIEFB.repository.JugadorEntrenamientoRepository;
import SIEFB.repository.JugadorRepository;
import SIEFB.service.JugadorEntrenamientoService;

@Service
public class JugadorEntrenamientoServiceImpl implements JugadorEntrenamientoService {

	@Autowired
    private JugadorEntrenamientoRepository repository;
	
	@Autowired
	private JugadorRepository jugadorRepository;

	@Autowired
	private EntrenamientoRepository entrenamientoRepository;

    @Override
    public List<JugadorEntrenamiento> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<JugadorEntrenamiento> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public JugadorEntrenamiento guardar(JugadorEntrenamiento je) {
    	Integer jugadorId = je.getJugador().getId();
        Integer entrenamientoId = je.getEntrenamiento().getId();

        if (jugadorId == null || !jugadorRepository.existsById(jugadorId)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El jugador no existe con id: " + jugadorId
            );
        }

        if (entrenamientoId == null || !entrenamientoRepository.existsById(entrenamientoId)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El entrenamiento no existe con id: " + entrenamientoId
            );
        }

        return repository.save(je);
    }

    @Override
    public JugadorEntrenamiento actualizar(Integer id, JugadorEntrenamiento je) {
    	return repository.findById(id)
    	        .map(e -> {

    	            Integer jugadorId = je.getJugador().getId();
    	            Integer entrenamientoId = je.getEntrenamiento().getId();

    	            if (jugadorId == null || !jugadorRepository.existsById(jugadorId)) {
    	                throw new ResponseStatusException(
    	                        HttpStatus.BAD_REQUEST,
    	                        "El jugador no existe con id: " + jugadorId
    	                );
    	            }

    	            if (entrenamientoId == null || !entrenamientoRepository.existsById(entrenamientoId)) {
    	                throw new ResponseStatusException(
    	                        HttpStatus.BAD_REQUEST,
    	                        "El entrenamiento no existe con id: " + entrenamientoId
    	                );
    	            }

    	            e.setJugador(je.getJugador());
    	            e.setEntrenamiento(je.getEntrenamiento());
    	            e.setAsistencia(je.getAsistencia());

    	            return repository.save(e);
    	        })
    	        .orElseThrow(() -> new ResponseStatusException(
    	                HttpStatus.NOT_FOUND,
    	                "Registro no encontrado con id: " + id
    	        ));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
