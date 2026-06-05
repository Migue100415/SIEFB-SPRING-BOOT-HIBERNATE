package SIEFB.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SIEFB.model.Trabajador;
import SIEFB.service.TrabajadorService;

@RestController
@RequestMapping("/api/trabajadores")
@CrossOrigin(origins = "*")
public class TrabajadorController {

	@Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> listar() {
        return trabajadorService.listar();
    }

    @GetMapping("/{id}")
    public Trabajador obtener(@PathVariable Integer id) {
        return trabajadorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Trabajador no encontrado"));
    }

    @PostMapping
    public Trabajador crear(@RequestBody Trabajador trabajador) {
        return trabajadorService.guardar(trabajador);
    }

    @PutMapping("/{id}")
    public Trabajador actualizar(@PathVariable Integer id, @RequestBody Trabajador trabajador) {
        return trabajadorService.actualizar(id, trabajador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        trabajadorService.eliminar(id);
    }
}
