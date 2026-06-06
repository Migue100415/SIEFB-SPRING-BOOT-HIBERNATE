package SIEFB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import SIEFB.model.JugadorEntrenamiento;
import SIEFB.service.JugadorEntrenamientoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jugador-entrenamientos")
@CrossOrigin(origins = "*")
public class JugadorEntrenamientoController {

    @Autowired
    private JugadorEntrenamientoService service;

    @GetMapping
    public ResponseEntity<List<JugadorEntrenamiento>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorEntrenamiento> obtener(@PathVariable Integer id) {

        JugadorEntrenamiento je = service.obtenerPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro no encontrado con id: " + id
                ));

        return ResponseEntity.ok(je);
    }

    @PostMapping
    public ResponseEntity<JugadorEntrenamiento> crear(
            @Valid @RequestBody JugadorEntrenamiento je) {

        JugadorEntrenamiento nuevo = service.guardar(je);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorEntrenamiento> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody JugadorEntrenamiento je) {

        JugadorEntrenamiento actualizado = service.actualizar(id, je);

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
