package SIEFB.model;

import java.time.LocalDate;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import SIEFB.model.enums.TipoMovimiento;

@Entity
@Table(name = "registro_contable")
@Getter
@Setter
public class RegistroContable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "La cantidad del pago es obligatoria")
    @Column(name = "cantidad_pago", nullable = false)
    private Integer cantidadPago;


    @NotBlank(message = "El comprobante es obligatorio")
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String comprobante;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrador_id", nullable = false)
    private Administrador administrador;
}