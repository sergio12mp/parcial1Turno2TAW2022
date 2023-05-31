package es.taw.starwars.dao;

import es.taw.starwars.entity.FraseCelebre;
import es.taw.starwars.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero,Integer> {
}
