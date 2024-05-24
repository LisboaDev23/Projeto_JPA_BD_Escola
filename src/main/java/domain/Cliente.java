package domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "sq_cliente", initialValue = 1, allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "cpf",nullable = false,unique = true)
    @NotBlank
    @Size(max = 11)
    private String cpf;

    @Column(name = "telefone",nullable = false)
    @Size(max = 12, min = 10)
    @NotBlank
    private String telefone;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "endereco", nullable = false)
    @NotBlank
    private String endereco;

    @OneToOne
    @JoinColumn(name = "matricula_id")
    @Valid
    private Matricula matricula;

}
