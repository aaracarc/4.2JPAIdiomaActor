package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id_actor;
    private String nombre;
    private String apellidos;
    private Timestamp ultima_actualizacion;

    @ManyToMany(mappedBy = "actores")
    private Set<Pelicula> peliculas = new HashSet<>();

}
