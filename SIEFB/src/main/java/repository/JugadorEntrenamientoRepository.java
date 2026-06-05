package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.JugadorEntrenamiento;

@Repository
public interface JugadorEntrenamientoRepository extends JpaRepository<JugadorEntrenamiento, Integer> {

}
