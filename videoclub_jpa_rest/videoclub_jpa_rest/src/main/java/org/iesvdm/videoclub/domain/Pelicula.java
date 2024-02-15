package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pelicula")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long idPelicula;

    private String Titulo;

    @ManyToMany
    Set<Categoria> categorias = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    private Idioma idioma;

    @ManyToMany
    private Set<Actor> actores = new HashSet<>();
}
