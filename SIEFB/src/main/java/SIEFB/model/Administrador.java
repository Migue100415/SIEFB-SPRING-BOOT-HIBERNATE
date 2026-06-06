package SIEFB.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter

public class Administrador extends Trabajador{

}
