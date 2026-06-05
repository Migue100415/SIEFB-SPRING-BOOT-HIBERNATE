package service;

import java.util.List;
import java.util.Optional;
import model.JugadorEntrenamiento;

public interface JugadorEntrenamientoService {

	 List<JugadorEntrenamiento> listar();

	    Optional<JugadorEntrenamiento> obtenerPorId(Integer id);

	    JugadorEntrenamiento guardar(JugadorEntrenamiento je);

	    JugadorEntrenamiento actualizar(Integer id, JugadorEntrenamiento je);

	    void eliminar(Integer id);
}
