package SIEFB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import SIEFB.model.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

}
