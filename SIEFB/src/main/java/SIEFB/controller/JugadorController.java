package SIEFB.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import SIEFB.model.Jugador;
import SIEFB.service.JugadorService;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "*")
@Validated
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<Jugador>> listar() {
        return ResponseEntity.ok(jugadorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtener(@PathVariable Integer id) {
        return jugadorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Jugador> crear(@Valid @RequestBody Jugador jugador) {
        Jugador nuevo = jugadorService.guardar(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable Integer id,
                                              @Valid @RequestBody Jugador jugador) {
        Jugador actualizado = jugadorService.actualizar(id, jugador);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        jugadorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}