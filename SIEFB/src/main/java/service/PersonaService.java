package service;

import java.util.List;
import java.util.Optional;
import model.Persona;

public interface PersonaService {

	List<Persona> listar();

    Optional<Persona> obtenerPorId(Integer id);

    Persona guardar(Persona persona);

    Persona actualizar(Integer id, Persona persona);

    void eliminar(Integer id);
}
