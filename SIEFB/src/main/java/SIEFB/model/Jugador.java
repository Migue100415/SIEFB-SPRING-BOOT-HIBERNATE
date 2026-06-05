package SIEFB.model;

import java.time.LocalDate;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jugador")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter

public class Jugador extends Persona{

	@NotBlank(message = "El nombre del acudiente es obligatorio")
    @Size(max = 50)
    @Column(name = "nombre_acudiente", nullable = false, length = 50)
    private String nombreAcudiente;

	@NotNull(message = "La fecha de inscripción es obligatoria")
    @Column(name = "dia_inscripcion", nullable = false)
    private LocalDate diaInscripcion;
}
