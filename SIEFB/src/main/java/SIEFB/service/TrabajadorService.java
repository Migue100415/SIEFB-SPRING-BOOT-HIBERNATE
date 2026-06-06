package SIEFB.service;

import java.util.List;


import java.util.Optional;
import SIEFB.model.Trabajador;

public interface TrabajadorService {

	List<Trabajador> listar();

    Optional<Trabajador> obtenerPorId(Integer id);

    Trabajador guardar(Trabajador trabajador);

    Trabajador actualizar(Integer id, Trabajador trabajador);

    void eliminar(Integer id);
}
