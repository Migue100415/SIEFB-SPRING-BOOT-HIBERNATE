package SIEFB.model;

import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profesional_deportivo")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter

public class ProfesionalDeportivo extends Trabajador{

}
