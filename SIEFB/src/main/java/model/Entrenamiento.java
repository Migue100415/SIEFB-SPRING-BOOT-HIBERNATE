package model;

import java.time.LocalDate;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "entrenamiento")
@Getter
@Setter

public class Entrenamiento {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @NotNull(message = "La fecha es obligatoria")
	    @Column(nullable = false)
	    private LocalDate fecha;

	    @Column(columnDefinition = "TEXT")
	    private String observaciones;
}
