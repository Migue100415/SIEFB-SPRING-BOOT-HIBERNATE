package SIEFB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import SIEFB.model.Partido;
import SIEFB.service.PartidoService;

@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(origins = "*")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Partido>> listar() {
        return ResponseEntity.ok(partidoService.listar());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Partido> obtener(@PathVariable Integer id) {

        Partido partido = partidoService.obtenerPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Partido no encontrado con id: " + id
                ));

        return ResponseEntity.ok(partido);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Partido> crear(@Valid @RequestBody Partido partido) {

        Partido nuevo = partidoService.guardar(partido);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Partido partido) {

        Partido actualizado = partidoService.actualizar(id, partido);

        return ResponseEntity.ok(actualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        partidoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}