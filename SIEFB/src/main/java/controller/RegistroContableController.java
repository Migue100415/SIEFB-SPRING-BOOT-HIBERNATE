package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.RegistroContable;
import service.RegistroContableService;

@RestController
@RequestMapping("/api/registros-contables")
@CrossOrigin(origins = "*")
public class RegistroContableController {

	@Autowired
    private RegistroContableService service;

    @GetMapping
    public List<RegistroContable> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public RegistroContable obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    @PostMapping
    public RegistroContable crear(@RequestBody RegistroContable registro) {
        return service.guardar(registro);
    }

    @PutMapping("/{id}")
    public RegistroContable actualizar(@PathVariable Integer id, @RequestBody RegistroContable registro) {
        return service.actualizar(id, registro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
