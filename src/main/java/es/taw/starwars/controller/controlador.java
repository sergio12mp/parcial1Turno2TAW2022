package es.taw.starwars.controller;


import es.taw.starwars.dao.*;
import es.taw.starwars.entity.FraseCelebre;
import es.taw.starwars.entity.Pelicula;
import es.taw.starwars.entity.Personaje;
import es.taw.starwars.ui.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class controlador {

    @Autowired
    FraseCelebreRepository fraseCelebreRepository;
    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    PeliculaRepository peliculaRepository;
    @Autowired
    PersonajeRepository personajeRepository;
    @Autowired
    PlanetaRepository planetaRepository;


    @GetMapping("/")
    public String doListar(Model model) {
        List<FraseCelebre> listaFrasesCelebres = this.fraseCelebreRepository.findAll();
        model.addAttribute("listaFrasesCelebres", listaFrasesCelebres);
        Filtro filtro = new Filtro();
        model.addAttribute("filtro", filtro);

        return "index";
    }

    @GetMapping("/editar")
    public String doEditar(Model model, @RequestParam("id") Integer peliculaId) {
        Pelicula pelicula = this.peliculaRepository.findById(peliculaId).orElse(null);
        model.addAttribute("pelicula", pelicula);

        List<Personaje> listaPersonajes = this.personajeRepository.findAll();
        model.addAttribute("listaPersonajes", listaPersonajes);


        return "editar";
    }


    @PostMapping("/guardar")
    public String doGuardar(Model model, @ModelAttribute("pelicula") Pelicula pelicula) {
        peliculaRepository.save(pelicula);

        return doListar(model);
    }

    @PostMapping("/filtrar")
    public String doFiltrar(Model model, @ModelAttribute("filtro") Filtro filtro) {
        List<FraseCelebre> lista;
        if (filtro.getPelicula() && filtro.getPersonaje()) {
            System.out.println(1);
            lista = this.fraseCelebreRepository.doble();
        } else if (filtro.getPersonaje()) {
            System.out.println(2);

            lista = this.fraseCelebreRepository.personaje();
        } else if (filtro.getPelicula()) {
            System.out.println(3);

            lista = this.fraseCelebreRepository.pelicula();
        } else {
            System.out.println(4);

            lista = this.fraseCelebreRepository.findAll();
        }
        model.addAttribute("listaFrasesCelebres", lista);

        return "index";
    }


}
