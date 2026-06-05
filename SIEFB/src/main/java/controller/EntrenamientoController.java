package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.Entrenamiento;
import service.EntrenamientoService;

@RestController
@RequestMapping("/api/entrenamientos")
@CrossOrigin(origins = "*")
public class EntrenamientoController {

	@Autowired
    private EntrenamientoService entrenamientoService;

    @GetMapping
    public List<Entrenamiento> listar() {
        return entrenamientoService.listar();
    }

    @GetMapping("/{id}")
    public Entrenamiento obtener(@PathVariable Integer id) {
        return entrenamientoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Entrenamiento no encontrado"));
    }

    @PostMapping
    public Entrenamiento crear(@RequestBody Entrenamiento entrenamiento) {
        return entrenamientoService.guardar(entrenamiento);
    }

    @PutMapping("/{id}")
    public Entrenamiento actualizar(@PathVariable Integer id, @RequestBody Entrenamiento entrenamiento) {
        return entrenamientoService.actualizar(id, entrenamiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        entrenamientoService.eliminar(id);
    }
}
