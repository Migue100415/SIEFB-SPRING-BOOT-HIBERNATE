package SIEFB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import SIEFB.model.*;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer>  {

}
