package org.iesvdm.videoclub;

import org.iesvdm.videoclub.domain.Actor;
import org.iesvdm.videoclub.domain.Categoria;
import org.iesvdm.videoclub.domain.Idioma;
import org.iesvdm.videoclub.domain.Pelicula;
import org.iesvdm.videoclub.repository.ActorRepository;
import org.iesvdm.videoclub.repository.CategoriaRepository;
import org.iesvdm.videoclub.repository.IdiomaRepository;
import org.iesvdm.videoclub.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
class VideoclubApplicationTests {

    @Autowired
    PeliculaRepository peliculaRepository;
    @Autowired
    IdiomaRepository idiomaRepository;
    @Autowired
    ActorRepository actorRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void guardarActorPelicula() {
        Pelicula pelicula1 = new Pelicula(1, "peli1", new HashSet<>(), null, new HashSet<>());
        peliculaRepository.save(pelicula1);

        Pelicula pelicula2 = new Pelicula(2, "peli2", new HashSet<>(), null, new HashSet<>());
        peliculaRepository.save(pelicula2);

        Actor actor1 = new Actor(1, "actor1", "apelli1", new Timestamp(System.currentTimeMillis()), new HashSet<>());
        actorRepository.save(actor1);

        Actor actor2 = new Actor(2, "actor2", "apelli2", new Timestamp(System.currentTimeMillis()), new HashSet<>());
        actorRepository.save(actor2);

        pelicula1.getActores().add(actor1);
        actor1.getPeliculas().add(pelicula1);
        pelicula1.getActores().add(actor2);
        actor2.getPeliculas().add(pelicula1);
    }

    @Test
    void guardarIdiomaPelicula() {
        Idioma idioma1 = new Idioma(1L, "español", new Date(2020, 2,2), new HashSet<>());
        idiomaRepository.save(idioma1);

        Idioma idioma2 = new Idioma(2L, "ingles", new Date(2020, 2,2), new HashSet<>());
        idiomaRepository.save(idioma2);

        Pelicula pelicula1 = new Pelicula(1, "peli1", new HashSet<>(), null, new HashSet<>());
        peliculaRepository.save(pelicula1);

        Pelicula pelicula2 = new Pelicula(2, "peli2", new HashSet<>(), null, new HashSet<>());
        peliculaRepository.save(pelicula2);

        idioma1.getPeliculasIdioma().add(pelicula1);
        idioma1.getPeliculasIdioma().add(pelicula2);
    }
}
