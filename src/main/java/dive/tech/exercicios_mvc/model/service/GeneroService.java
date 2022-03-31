package dive.tech.exercicios_mvc.model.service;

import dive.tech.exercicios_mvc.model.dao.GeneroDao;
import dive.tech.exercicios_mvc.model.entity.Genero;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class GeneroService {

    private GeneroDao generoDao = new GeneroDao();

    public Genero createGenero(Genero genero) {
        return generoDao.createGenero(genero);
    }

    public List<Genero> getGeneros() {
        return generoDao.getGeneros();
    }
}
