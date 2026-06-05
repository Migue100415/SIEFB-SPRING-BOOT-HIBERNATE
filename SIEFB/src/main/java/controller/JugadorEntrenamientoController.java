package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.JugadorEntrenamiento;
import service.JugadorEntrenamientoService;

@RestController
@RequestMapping("/api/jugador-entrenamientos")
@CrossOrigin(origins = "*")
public class JugadorEntrenamientoController {

	 @Autowired
	    private JugadorEntrenamientoService service;

	    @GetMapping
	    public List<JugadorEntrenamiento> listar() {
	        return service.listar();
	    }

	    @GetMapping("/{id}")
	    public JugadorEntrenamiento obtener(@PathVariable Integer id) {
	        return service.obtenerPorId(id)
	                .orElseThrow(() -> new RuntimeException("No encontrado"));
	    }

	    @PostMapping
	    public JugadorEntrenamiento crear(@RequestBody JugadorEntrenamiento je) {
	        return service.guardar(je);
	    }

	    @PutMapping("/{id}")
	    public JugadorEntrenamiento actualizar(@PathVariable Integer id, @RequestBody JugadorEntrenamiento je) {
	        return service.actualizar(id, je);
	    }

	    @DeleteMapping("/{id}")
	    public void eliminar(@PathVariable Integer id) {
	        service.eliminar(id);
	    }
}
