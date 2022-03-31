package dive.tech.exercicios_mvc.model.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class Jogo implements Serializable {

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

    @NotNull
    private List<Genero> generos;

    @NotNull
    private Empresa empresa;

    public Jogo(){}

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

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ativo=" + ativo +
                ", generos=" + generos +
                ", empresa=" + empresa +
                '}';
    }
}
