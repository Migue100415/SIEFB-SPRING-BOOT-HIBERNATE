package service;

import java.util.List;
import java.util.Optional;
import model.JugadorPartido;

public interface JugadorPartidoService {

	List<JugadorPartido> listar();

    Optional<JugadorPartido> obtenerPorId(Integer id);

    JugadorPartido guardar(JugadorPartido jp);

    JugadorPartido actualizar(Integer id, JugadorPartido jp);

    void eliminar(Integer id);
}
