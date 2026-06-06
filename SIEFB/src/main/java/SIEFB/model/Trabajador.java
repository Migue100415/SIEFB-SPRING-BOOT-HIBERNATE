package SIEFB.model;

import java.time.LocalDate;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trabajador")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter

public class Trabajador extends Persona{

	@NotBlank(message = "El ARL es obligatoria")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
	private String arl;

	@NotNull(message = "La fecha de ingreso es obligatoria")
    @Column(name = "dia_ingreso", nullable = false)
    private LocalDate diaIngreso;
}
