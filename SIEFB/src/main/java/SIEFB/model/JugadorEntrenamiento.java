package SIEFB.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "jugador_entrenamiento", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"jugador_id", "entrenamiento_id"})
    })
@Getter
@Setter

public class JugadorEntrenamiento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenamiento_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Entrenamiento entrenamiento;

    @NotNull(message = "Debes confirmar la asistencia")
    @Column(nullable = false)
    private Boolean asistencia;
}
