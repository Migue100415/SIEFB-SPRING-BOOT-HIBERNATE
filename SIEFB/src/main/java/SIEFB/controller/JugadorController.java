package SIEFB.controller;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SIEFB.model.Jugador;
import SIEFB.service.JugadorService;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "*")
public class JugadorController {

	@Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> listar() {
        return jugadorService.listar();
    }

    @GetMapping("/{id}")
    public Jugador obtener(@PathVariable Integer id) {
        return jugadorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugadorService.guardar(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable Integer id, @RequestBody Jugador jugador) {
        return jugadorService.actualizar(id, jugador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        jugadorService.eliminar(id);
    }
}
