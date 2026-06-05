package service;

import java.util.List;

import java.util.Optional;
import model.Partido;

public interface PartidoService {

	List<Partido> listar();

    Optional<Partido> obtenerPorId(Integer id);

    Partido guardar(Partido partido);

    Partido actualizar(Integer id, Partido partido);

    void eliminar(Integer id);
}
