package SIEFB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import SIEFB.model.RegistroContable;

@Repository
public interface RegistroContableRepository extends JpaRepository<RegistroContable, Integer> {

}
