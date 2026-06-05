package SIEFB.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SIEFB.model.Persona;
import SIEFB.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = "*")
public class PersonaController {

	@Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> listar() {
        return personaService.listar();
    }

    @GetMapping("/{id}")
    public Persona obtener(@PathVariable Integer id) {
        return personaService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @PostMapping
    public Persona crear(@RequestBody Persona persona) {
        return personaService.guardar(persona);
    }

    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Integer id, @RequestBody Persona persona) {
        return personaService.actualizar(id, persona);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        personaService.eliminar(id);
    }
}
