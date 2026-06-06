package SIEFB.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import SIEFB.model.Trabajador;
import SIEFB.service.TrabajadorService;

@RestController
@RequestMapping("/api/trabajadores")
@CrossOrigin(origins = "*")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Trabajador>> listar() {
        return ResponseEntity.ok(trabajadorService.listar());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> obtener(@PathVariable Integer id) {
        Trabajador trabajador = trabajadorService.obtenerPorId(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Trabajador no encontrado con id: " + id));

        return ResponseEntity.ok(trabajador);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Trabajador> crear(@Valid @RequestBody Trabajador trabajador) {
        Trabajador creado = trabajadorService.guardar(trabajador);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Trabajador trabajador) {

        Trabajador actualizado = trabajadorService.actualizar(id, trabajador);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        trabajadorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}