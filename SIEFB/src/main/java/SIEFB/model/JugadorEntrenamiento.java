package SIEFB.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

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
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenamiento_id", nullable = false)
    private Entrenamiento entrenamiento;

    @NotNull(message = "Debes confirmar la asistencia")
    @Column(nullable = false)
    private Boolean asistencia;
}
