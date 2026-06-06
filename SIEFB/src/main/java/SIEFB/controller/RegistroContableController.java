package SIEFB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import SIEFB.model.RegistroContable;
import SIEFB.service.RegistroContableService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/registros-contables")
@CrossOrigin(origins = "*")
public class RegistroContableController {

    @Autowired
    private RegistroContableService service;

    @GetMapping
    public ResponseEntity<List<RegistroContable>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroContable> obtener(@PathVariable Integer id) {

        RegistroContable registro = service.obtenerPorId(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Registro contable no encontrado con id: " + id
                ));

        return ResponseEntity.ok(registro);
    }

    @PostMapping
    public ResponseEntity<RegistroContable> crear(
            @Valid @RequestBody RegistroContable registro) {

        RegistroContable nuevo = service.guardar(registro);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroContable> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody RegistroContable registro) {

        RegistroContable actualizado = service.actualizar(id, registro);

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
