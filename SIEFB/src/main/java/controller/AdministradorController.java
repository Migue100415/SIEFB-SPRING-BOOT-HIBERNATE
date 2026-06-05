package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.Administrador;
import service.AdministradorService;

@RestController
@RequestMapping("/api/administradores")
@CrossOrigin(origins = "*")
public class AdministradorController {

	@Autowired
    private AdministradorService administradorService;

    @GetMapping
    public List<Administrador> listar() {
        return administradorService.listar();
    }

    @GetMapping("/{id}")
    public Administrador obtener(@PathVariable Integer id) {
        return administradorService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
    }

    @PostMapping
    public Administrador crear(@RequestBody Administrador administrador) {
        return administradorService.guardar(administrador);
    }

    @PutMapping("/{id}")
    public Administrador actualizar(@PathVariable Integer id, @RequestBody Administrador administrador) {
        return administradorService.actualizar(id, administrador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        administradorService.eliminar(id);
    }
}
