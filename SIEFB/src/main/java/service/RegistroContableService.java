package service;

import java.util.List;
import java.util.Optional;
import model.RegistroContable;

public interface RegistroContableService {

	List<RegistroContable> listar();

    Optional<RegistroContable> obtenerPorId(Integer id);

    RegistroContable guardar(RegistroContable registro);

    RegistroContable actualizar(Integer id, RegistroContable registro);

    void eliminar(Integer id);
}
