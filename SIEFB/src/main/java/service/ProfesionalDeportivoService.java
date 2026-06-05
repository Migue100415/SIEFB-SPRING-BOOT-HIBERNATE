package service;

import java.util.List;
import java.util.Optional;
import model.ProfesionalDeportivo;
public interface ProfesionalDeportivoService {

	List<ProfesionalDeportivo> listar();

    Optional<ProfesionalDeportivo> obtenerPorId(Integer id);

    ProfesionalDeportivo guardar(ProfesionalDeportivo profesional);

    ProfesionalDeportivo actualizar(Integer id, ProfesionalDeportivo profesional);

    void eliminar(Integer id);
}
