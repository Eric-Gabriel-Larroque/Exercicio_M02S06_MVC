package dive.tech.exercicios_mvc.model.dao;

import dive.tech.exercicios_mvc.model.entity.Empresa;
import dive.tech.exercicios_mvc.model.entity.Genero;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dive.tech.exercicios_mvc.util.Validation.validaListaVazia;

@ApplicationScoped
public class GeneroDao {

    public static List<Genero> generos = new ArrayList<>();

    public Genero createGenero(Genero genero) {
        long listSize =  generos.size()==0?0L:generos.size();

        genero.setNome(genero.getNome());
        genero.setId((listSize+1));
        generos.add(genero);
        return genero;
    }

    public List<Genero> getGeneros() {
        List<Genero> listaGeneros = generos;
        validaListaVazia(Collections.singletonList(listaGeneros));
        for(Genero genero: listaGeneros) {
            if(!genero.isAtivo()) {
                listaGeneros.remove(genero);
            }
        }
        return listaGeneros;
    }
}
