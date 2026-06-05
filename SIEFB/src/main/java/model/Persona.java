package model;

import java.time.LocalDate;




import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter

public class Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El documento es obligatorio")
    @Size(max = 20)
    @Column(unique = true, nullable = false, length = 20 )
    private String documento;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String nombre;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 60)
    @Column(nullable = false, length = 60)
    private String direccion;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String telefono;

    @NotBlank(message = "El acta médica es obligatoria")
    @Size(max = 255)
    @Column(name = "acta_medica", nullable = false, length = 255)
    private String actaMedica;

    @NotBlank(message = "La EPS es obligatoria")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String eps;

    @NotBlank(message = "La foto es obligatoria")
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String foto;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
}
