package es.taw.starwars.dao;

import es.taw.starwars.entity.FraseCelebre;
import es.taw.starwars.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje,Integer> {
}
