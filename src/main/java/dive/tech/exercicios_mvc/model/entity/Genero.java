package dive.tech.exercicios_mvc.model.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, message = "O nome precisa ter pelo menos 3 caracteres")
    @Size(max = 20, message = "O nome precisa ter no máximo 20 caracteres")
    private String nome;

    @NotNull
    private boolean ativo = true;

    public Genero() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
