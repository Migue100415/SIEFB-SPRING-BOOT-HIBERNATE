package SIEFB.service.impl;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SIEFB.model.JugadorEntrenamiento;
import SIEFB.repository.JugadorEntrenamientoRepository;
import SIEFB.service.JugadorEntrenamientoService;

@Service
public class JugadorEntrenamientoServiceImpl implements JugadorEntrenamientoService {

	@Autowired
    private JugadorEntrenamientoRepository repository;

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
        return repository.save(je);
    }

    @Override
    public JugadorEntrenamiento actualizar(Integer id, JugadorEntrenamiento je) {
        return repository.findById(id)
            .map(e -> {
                e.setJugador(je.getJugador());
                e.setEntrenamiento(je.getEntrenamiento());
                e.setAsistencia(je.getAsistencia());
                return repository.save(e);
            })
            .orElseThrow(() -> new RuntimeException("Registro no encontrado con id: " + id));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
