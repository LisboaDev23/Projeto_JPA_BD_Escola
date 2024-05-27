package domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;
import java.rmi.MarshalException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_matricula")
public class Matricula {

    @Id
    @NotBlank
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="matricula_seq")
    @SequenceGenerator(name="matricula_seq", sequenceName="sq_matricula", initialValue = 1, allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @NotNull
    @Valid
    private Cliente cliente;

    @Column(name = "codigo_matricula",nullable = false,unique = true)
    @NotBlank
    @Size(max = 20, min = 1)
    @EqualsAndHashCode.Include
    private String codigoMatricula;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @Valid
    @NotNull
    private Curso curso;

    public Matricula(String codigoMatricula){
        this.codigoMatricula = codigoMatricula;
    }

}
