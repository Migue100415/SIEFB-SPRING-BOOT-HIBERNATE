package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Entrenamiento;

@Repository
public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Integer> {

}
