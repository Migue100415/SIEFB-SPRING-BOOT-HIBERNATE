package SIEFB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import SIEFB.model.ProfesionalDeportivo;

@Repository
public interface ProfesionalDeportivoRepository extends JpaRepository<ProfesionalDeportivo, Integer> {

}
