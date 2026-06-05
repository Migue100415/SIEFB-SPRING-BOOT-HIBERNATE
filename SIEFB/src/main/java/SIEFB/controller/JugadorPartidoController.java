package SIEFB.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SIEFB.model.JugadorPartido;
import SIEFB.service.JugadorPartidoService;

@RestController
@RequestMapping("/api/jugador-partidos")
@CrossOrigin(origins = "*")

public class JugadorPartidoController {

	@Autowired
    private JugadorPartidoService service;

    @GetMapping
    public List<JugadorPartido> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public JugadorPartido obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    @PostMapping
    public JugadorPartido crear(@RequestBody JugadorPartido jp) {
        return service.guardar(jp);
    }

    @PutMapping("/{id}")
    public JugadorPartido actualizar(@PathVariable Integer id, @RequestBody JugadorPartido jp) {
        return service.actualizar(id, jp);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
