package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.JugadorPartido;

@Repository
public interface JugadorPartidoRepository extends JpaRepository<JugadorPartido, Integer> {

}
