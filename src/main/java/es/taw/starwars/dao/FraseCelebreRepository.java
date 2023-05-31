package es.taw.starwars.dao;

import es.taw.starwars.entity.FraseCelebre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FraseCelebreRepository extends JpaRepository<FraseCelebre,Integer> {

    @Query("select frase from FraseCelebre frase order by frase.pelicula.titulo,  frase.personaje.nombre ASC")
    List<FraseCelebre> doble();
    @Query("select frase from FraseCelebre frase order by frase.personaje.nombre ASC")
    List<FraseCelebre> personaje();
    @Query("select frase from FraseCelebre frase order by frase.pelicula.titulo ASC")
    List<FraseCelebre> pelicula();


}
