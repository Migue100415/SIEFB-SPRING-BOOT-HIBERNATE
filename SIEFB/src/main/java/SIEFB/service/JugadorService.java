package SIEFB.service;

import java.util.List;

import java.util.Optional;
import SIEFB.model.Jugador;

public interface JugadorService {

	List<Jugador> listar();

    Optional<Jugador> obtenerPorId(Integer id);

    Jugador guardar(Jugador jugador);

    Jugador actualizar(Integer id, Jugador jugador);

    void eliminar(Integer id);
}
