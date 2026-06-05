package SIEFB.service.impl;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SIEFB.model.Partido;
import SIEFB.repository.PartidoRepository;
import SIEFB.service.PartidoService;

@Service
public class PartidoServiceImpl implements PartidoService {

	 @Autowired
	    private PartidoRepository partidoRepository;

	    @Override
	    public List<Partido> listar() {
	        return partidoRepository.findAll();
	    }

	    @Override
	    public Optional<Partido> obtenerPorId(Integer id) {
	        return partidoRepository.findById(id);
	    }

	    @Override
	    public Partido guardar(Partido partido) {
	        return partidoRepository.save(partido);
	    }

	    @Override
	    public Partido actualizar(Integer id, Partido partido) {
	        return partidoRepository.findById(id)
	            .map(p -> {
	                p.setFecha(partido.getFecha());
	                p.setNombreArbitro(partido.getNombreArbitro());
	                p.setNombreCancha(partido.getNombreCancha());
	                p.setEquipoRival(partido.getEquipoRival());
	                return partidoRepository.save(p);
	            })
	            .orElseThrow(() -> new RuntimeException("Partido no encontrado con id: " + id));
	    }

	    @Override
	    public void eliminar(Integer id) {
	        partidoRepository.deleteById(id);
	    }
}
