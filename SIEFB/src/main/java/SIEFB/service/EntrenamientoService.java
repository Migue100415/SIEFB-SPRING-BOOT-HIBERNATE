package SIEFB.service;

import java.util.List;

import java.util.Optional;
import SIEFB.model.Entrenamiento;

public interface EntrenamientoService {

	List<Entrenamiento> listar();

    Optional<Entrenamiento> obtenerPorId(Integer id);

    Entrenamiento guardar(Entrenamiento entrenamiento);

    Entrenamiento actualizar(Integer id, Entrenamiento entrenamiento);

    void eliminar(Integer id);
}
