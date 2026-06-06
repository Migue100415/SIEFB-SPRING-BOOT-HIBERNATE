package SIEFB.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import SIEFB.model.JugadorPartido;
import SIEFB.repository.JugadorPartidoRepository;
import SIEFB.repository.JugadorRepository;
import SIEFB.repository.PartidoRepository;
import SIEFB.service.JugadorPartidoService;

@Service
public class JugadorPartidoServiceImpl implements JugadorPartidoService {

	 @Autowired
	    private JugadorPartidoRepository repository;
	 
	 @Autowired
	 private JugadorRepository jugadorRepository;

	 @Autowired
	 private PartidoRepository partidoRepository;

	    @Override
	    public List<JugadorPartido> listar() {
	        return repository.findAll();
	    }

	    @Override
	    public Optional<JugadorPartido> obtenerPorId(Integer id) {
	        return repository.findById(id);
	    }

	    @Override
	    public JugadorPartido guardar(JugadorPartido jp) {
	    	Integer jugadorId = jp.getJugador().getId();
	        Integer partidoId = jp.getPartido().getId();

	        if (jugadorId == null || !jugadorRepository.existsById(jugadorId)) {
	            throw new ResponseStatusException(
	                    HttpStatus.BAD_REQUEST,
	                    "El jugador no existe con id: " + jugadorId
	            );
	        }

	        if (partidoId == null || !partidoRepository.existsById(partidoId)) {
	            throw new ResponseStatusException(
	                    HttpStatus.BAD_REQUEST,
	                    "El partido no existe con id: " + partidoId
	            );
	        }

	        return repository.save(jp);
	    }

	    @Override
	    public JugadorPartido actualizar(Integer id, JugadorPartido jp) {
	    	 return repository.findById(id)
	    		        .map(e -> {

	    		            Integer jugadorId = jp.getJugador().getId();
	    		            Integer partidoId = jp.getPartido().getId();

	    		            if (jugadorId == null || !jugadorRepository.existsById(jugadorId)) {
	    		                throw new ResponseStatusException(
	    		                        HttpStatus.BAD_REQUEST,
	    		                        "El jugador no existe con id: " + jugadorId
	    		                );
	    		            }

	    		            if (partidoId == null || !partidoRepository.existsById(partidoId)) {
	    		                throw new ResponseStatusException(
	    		                        HttpStatus.BAD_REQUEST,
	    		                        "El partido no existe con id: " + partidoId
	    		                );
	    		            }

	    		            e.setJugador(jp.getJugador());
	    		            e.setPartido(jp.getPartido());
	    		            e.setGoles(jp.getGoles());
	    		            e.setAsistencias(jp.getAsistencias());
	    		            e.setAmarillas(jp.getAmarillas());
	    		            e.setRojas(jp.getRojas());
	    		            e.setAsistencia(jp.getAsistencia());

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
