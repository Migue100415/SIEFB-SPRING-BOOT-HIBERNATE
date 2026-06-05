package model;

import java.time.LocalDate;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "partido")
@Getter
@Setter

public class Partido {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "La fecha del partido es obligatoria")
    @Column(nullable = false)
    private LocalDate fecha;

    @NotBlank(message = "El nombre del arbitro es obligatorio")
    @Size(max = 50)
    @Column(name = "nombre_arbitro", nullable = false, length = 50)
    private String nombreArbitro;

    @NotBlank(message = "El nombre de la cancha es obligatorio")
    @Size(max = 50)
    @Column(name = "nombre_cancha", nullable = false, length = 50)
    private String nombreCancha;

    
    @NotBlank(message = "El nombre del equipo rival es obligatorio")
    @Size(max = 50)
    @Column(name = "nombre_rival", nullable = false, length = 50)
    private String equipoRival;
}
