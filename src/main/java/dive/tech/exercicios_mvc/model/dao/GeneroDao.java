package dive.tech.exercicios_mvc.model.dao;

import dive.tech.exercicios_mvc.model.entity.Genero;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

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
}
