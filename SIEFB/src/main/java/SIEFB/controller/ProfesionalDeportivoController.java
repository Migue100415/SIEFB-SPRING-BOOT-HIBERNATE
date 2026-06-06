package SIEFB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import SIEFB.model.ProfesionalDeportivo;
import SIEFB.service.ProfesionalDeportivoService;

@RestController
@RequestMapping("/api/profesionales")
@CrossOrigin(origins = "*")
public class ProfesionalDeportivoController {

    @Autowired
    private ProfesionalDeportivoService profesionalService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<ProfesionalDeportivo>> listar() {
        return ResponseEntity.ok(profesionalService.listar());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProfesionalDeportivo> obtener(@PathVariable Integer id) {

        ProfesionalDeportivo profesional = profesionalService.obtenerPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Profesional Deportivo no encontrado con id: " + id
                ));

        return ResponseEntity.ok(profesional);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ProfesionalDeportivo> crear(
            @Valid @RequestBody ProfesionalDeportivo profesional) {

        ProfesionalDeportivo nuevo = profesionalService.guardar(profesional);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProfesionalDeportivo> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody ProfesionalDeportivo profesional) {

        ProfesionalDeportivo actualizado =
                profesionalService.actualizar(id, profesional);

        return ResponseEntity.ok(actualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        profesionalService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}