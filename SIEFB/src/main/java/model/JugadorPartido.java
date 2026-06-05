package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jugador_partido", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"jugador_id", "partido_id"})
    })
@Getter
@Setter

public class JugadorPartido {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

    private Integer goles;

    private Integer asistencias;

    private Integer amarillas;

    private Integer rojas;

    @NotNull(message = "Debes confirmar la asistencia")
    @Column(nullable = false)
    private Boolean asistencia;
}
