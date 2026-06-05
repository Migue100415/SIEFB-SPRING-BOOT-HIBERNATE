package service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.JugadorPartido;
import repository.JugadorPartidoRepository;
import service.JugadorPartidoService;

@Service
public class JugadorPartidoServiceImpl implements JugadorPartidoService {

	 @Autowired
	    private JugadorPartidoRepository repository;

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
	        return repository.save(jp);
	    }

	    @Override
	    public JugadorPartido actualizar(Integer id, JugadorPartido jp) {
	        return repository.findById(id)
	            .map(e -> {
	                e.setJugador(jp.getJugador());
	                e.setPartido(jp.getPartido());
	                e.setGoles(jp.getGoles());
	                e.setAsistencias(jp.getAsistencias());
	                e.setAmarillas(jp.getAmarillas());
	                e.setRojas(jp.getRojas());
	                e.setAsistencia(jp.getAsistencia());
	                return repository.save(e);
	            })
	            .orElseThrow(() -> new RuntimeException("Registro no encontrado con id: " + id));
	    }

	    @Override
	    public void eliminar(Integer id) {
	        repository.deleteById(id);
	    }
}
