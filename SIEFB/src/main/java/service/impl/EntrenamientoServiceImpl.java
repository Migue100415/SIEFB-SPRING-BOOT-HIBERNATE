package service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Entrenamiento;
import repository.EntrenamientoRepository;
import service.EntrenamientoService;

@Service
public class EntrenamientoServiceImpl implements EntrenamientoService {

	@Autowired
    private EntrenamientoRepository entrenamientoRepository;

    @Override
    public List<Entrenamiento> listar() {
        return entrenamientoRepository.findAll();
    }

    @Override
    public Optional<Entrenamiento> obtenerPorId(Integer id) {
        return entrenamientoRepository.findById(id);
    }

    @Override
    public Entrenamiento guardar(Entrenamiento entrenamiento) {
        return entrenamientoRepository.save(entrenamiento);
    }

    @Override
    public Entrenamiento actualizar(Integer id, Entrenamiento entrenamiento) {
        return entrenamientoRepository.findById(id)
            .map(e -> {
                e.setFecha(entrenamiento.getFecha());
                e.setObservaciones(entrenamiento.getObservaciones());
                return entrenamientoRepository.save(e);
            })
            .orElseThrow(() -> new RuntimeException("Entrenamiento no encontrado con id: " + id));
    }

    @Override
    public void eliminar(Integer id) {
        entrenamientoRepository.deleteById(id);
    }
}
