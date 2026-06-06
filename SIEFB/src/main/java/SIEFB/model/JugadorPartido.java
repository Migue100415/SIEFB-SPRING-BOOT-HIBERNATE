package SIEFB.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partido_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Partido partido;

    private Integer goles;

    private Integer asistencias;

    private Integer amarillas;

    private Integer rojas;

    @NotNull(message = "Debes confirmar la asistencia")
    @Column(nullable = false)
    private Boolean asistencia;
}
