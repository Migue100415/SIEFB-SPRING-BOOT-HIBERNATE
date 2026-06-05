package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.Partido;
import service.PartidoService;

@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(origins = "*")
public class PartidoController {

	@Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> listar() {
        return partidoService.listar();
    }

    @GetMapping("/{id}")
    public Partido obtener(@PathVariable Integer id) {
        return partidoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Partido no encontrado"));
    }

    @PostMapping
    public Partido crear(@RequestBody Partido partido) {
        return partidoService.guardar(partido);
    }

    @PutMapping("/{id}")
    public Partido actualizar(@PathVariable Integer id, @RequestBody Partido partido) {
        return partidoService.actualizar(id, partido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        partidoService.eliminar(id);
    }
}
