package SIEFB.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import SIEFB.model.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer>   {

}
