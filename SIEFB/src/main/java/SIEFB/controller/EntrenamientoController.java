package SIEFB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import SIEFB.model.Entrenamiento;
import SIEFB.service.EntrenamientoService;

@RestController
@RequestMapping("/api/entrenamientos")
@CrossOrigin(origins = "*")
public class EntrenamientoController {

    @Autowired
    private EntrenamientoService entrenamientoService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Entrenamiento>> listar() {
        return ResponseEntity.ok(entrenamientoService.listar());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Entrenamiento> obtener(@PathVariable Integer id) {

        Entrenamiento entrenamiento = entrenamientoService.obtenerPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Entrenamiento no encontrado con id: " + id
                ));

        return ResponseEntity.ok(entrenamiento);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Entrenamiento> crear(
            @Valid @RequestBody Entrenamiento entrenamiento) {

        Entrenamiento nuevo = entrenamientoService.guardar(entrenamiento);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Entrenamiento> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Entrenamiento entrenamiento) {

        Entrenamiento actualizado = entrenamientoService.actualizar(id, entrenamiento);

        return ResponseEntity.ok(actualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        entrenamientoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}