package SIEFB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import SIEFB.model.JugadorPartido;
import SIEFB.service.JugadorPartidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jugador-partidos")
@CrossOrigin(origins = "*")
public class JugadorPartidoController {

    @Autowired
    private JugadorPartidoService service;

    @GetMapping
    public ResponseEntity<List<JugadorPartido>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorPartido> obtener(@PathVariable Integer id) {

        JugadorPartido jp = service.obtenerPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro no encontrado con id: " + id
                ));

        return ResponseEntity.ok(jp);
    }

    @PostMapping
    public ResponseEntity<JugadorPartido> crear(
            @Valid @RequestBody JugadorPartido jp) {

        JugadorPartido nuevo = service.guardar(jp);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorPartido> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody JugadorPartido jp) {

        JugadorPartido actualizado = service.actualizar(id, jp);

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
