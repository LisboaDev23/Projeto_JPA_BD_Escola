package domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_curso")
public class Curso {

    @Id
    @NotBlank
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="curso_seq")
    @SequenceGenerator(name="curso_seq", sequenceName="sq_curso", initialValue = 1, allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome_curso",nullable = false, unique = true)
    @NotBlank
    private String nomeCurso;

    @Column(name = "codigo_curso",unique = true,nullable = false)
    @NotBlank
    @Size(max = 20, min = 1)
    @EqualsAndHashCode.Include
    private String codigoCurso;

    @Column(name = "descricao", nullable = false)
    @Size(max = 250)
    @NotBlank
    private String descricao;

    @Column(name = "preco", nullable = false)
    @NotNull
    @Positive
    private BigDecimal preco;

    @OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas;
}
