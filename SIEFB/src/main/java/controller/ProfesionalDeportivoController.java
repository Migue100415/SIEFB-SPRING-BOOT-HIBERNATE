package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.ProfesionalDeportivo;
import service.ProfesionalDeportivoService;

@RestController
@RequestMapping("/api/profesionales")
@CrossOrigin(origins = "*")
public class ProfesionalDeportivoController {

	@Autowired
    private ProfesionalDeportivoService profesionalService;

    @GetMapping
    public List<ProfesionalDeportivo> listar() {
        return profesionalService.listar();
    }

    @GetMapping("/{id}")
    public ProfesionalDeportivo obtener(@PathVariable Integer id) {
        return profesionalService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Profesional Deportivo no encontrado"));
    }

    @PostMapping
    public ProfesionalDeportivo crear(@RequestBody ProfesionalDeportivo profesional) {
        return profesionalService.guardar(profesional);
    }

    @PutMapping("/{id}")
    public ProfesionalDeportivo actualizar(@PathVariable Integer id, @RequestBody ProfesionalDeportivo profesional) {
        return profesionalService.actualizar(id, profesional);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        profesionalService.eliminar(id);
    }
}
