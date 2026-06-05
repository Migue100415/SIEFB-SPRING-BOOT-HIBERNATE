package SIEFB.service;

import java.util.List;


import java.util.Optional;
import SIEFB.model.Administrador;

public interface AdministradorService {

	List<Administrador> listar();

    Optional<Administrador> obtenerPorId(Integer id);

    Administrador guardar(Administrador administrador);

    Administrador actualizar(Integer id, Administrador administrador);

    void eliminar(Integer id);
}
