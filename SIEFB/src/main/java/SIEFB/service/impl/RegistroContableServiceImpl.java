package SIEFB.service.impl;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SIEFB.model.RegistroContable;
import SIEFB.repository.RegistroContableRepository;
import SIEFB.service.RegistroContableService;

@Service
public class RegistroContableServiceImpl implements RegistroContableService {

	@Autowired
    private RegistroContableRepository repository;

    @Override
    public List<RegistroContable> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<RegistroContable> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public RegistroContable guardar(RegistroContable registro) {
        return repository.save(registro);
    }

    @Override
    public RegistroContable actualizar(Integer id, RegistroContable registro) {
        return repository.findById(id)
            .map(r -> {
                r.setFecha(registro.getFecha());
                r.setCantidadPago(registro.getCantidadPago());
                r.setComprobante(registro.getComprobante());
                r.setTipo(registro.getTipo());
                r.setAdministrador(registro.getAdministrador());
                return repository.save(r);
            })
            .orElseThrow(() -> new RuntimeException("Registro contable no encontrado con id: " + id));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
