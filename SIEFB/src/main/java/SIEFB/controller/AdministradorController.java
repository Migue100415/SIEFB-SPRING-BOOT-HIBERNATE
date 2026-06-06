package SIEFB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import SIEFB.model.Administrador;
import SIEFB.service.AdministradorService;

@RestController
@RequestMapping("/api/administradores")
@CrossOrigin(origins = "*")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Administrador>> listar() {
        return ResponseEntity.ok(administradorService.listar());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> obtener(@PathVariable Integer id) {

        Administrador administrador = administradorService.obtenerPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Administrador no encontrado con id: " + id
                ));

        return ResponseEntity.ok(administrador);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Administrador> crear(@Valid @RequestBody Administrador administrador) {

        Administrador nuevo = administradorService.guardar(administrador);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Administrador> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Administrador administrador) {

        Administrador actualizado = administradorService.actualizar(id, administrador);

        return ResponseEntity.ok(actualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        administradorService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}