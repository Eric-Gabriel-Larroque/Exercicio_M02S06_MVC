package dive.tech.exercicios_mvc.model.service;

import dive.tech.exercicios_mvc.model.dao.JogoDao;
import dive.tech.exercicios_mvc.model.entity.Jogo;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class JogoService {

    JogoDao jogoDao = new JogoDao();

    public List<Jogo> getJogos() {
        return jogoDao.getJogos();
    }

    public Jogo createJogo(Jogo jogo) {
        return jogoDao.createJogo(jogo);
    }

    public Jogo updateJogo(String nome, Long id) {
        return jogoDao.updateJogo(nome,id);
    }

    public Jogo deleteJogo(Long id) {
        return jogoDao.deleteJogo(id);
    }
}
