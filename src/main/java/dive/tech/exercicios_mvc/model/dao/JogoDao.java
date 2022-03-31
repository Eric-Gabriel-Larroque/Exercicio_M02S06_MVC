package dive.tech.exercicios_mvc.model.dao;

import dive.tech.exercicios_mvc.model.entity.Genero;
import dive.tech.exercicios_mvc.model.entity.Jogo;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dive.tech.exercicios_mvc.util.Validation.validaListaVazia;

@ApplicationScoped
public class JogoDao {

        private static List<Jogo> jogos = new ArrayList<>();

        private  GeneroDao generoDao = new GeneroDao();

        private EmpresaDao empresaDao = new EmpresaDao();

        public List<Jogo> getJogos() {
                List<Jogo> listaJogos = jogos;
                validaListaVazia(Collections.singletonList(listaJogos));
                for(Jogo jogo: listaJogos) {
                        if(!jogo.isAtivo()) {
                                listaJogos.remove(jogo);
                        }
                }
                return listaJogos;
        }

        public Jogo createJogo(Jogo jogo) {

                long listSize =  jogos.size()==0?0L:jogos.size();


                for(Genero genero: jogo.getGeneros()) {
                        if(!generoDao.generos.contains(genero)) {
                                generoDao.createGenero(genero);
                        }
                }

                if(empresaDao.empresas.contains(jogo.getEmpresa())) {
                        empresaDao.createEmpresa(jogo.getEmpresa());
                }

                jogo.setNome(jogo.getNome());
                jogo.setId((listSize+1));
                jogo.setGeneros(jogo.getGeneros());
                jogo.setEmpresa(jogo.getEmpresa());
                jogos.add(jogo);
                return jogo;
        }

        public Jogo updateJogo(String nome, Long id) {

                Jogo jogoAtualizado = null;
                for(Jogo jogo: jogos) {
                        if(jogo.getId().equals(id)) {
                                jogoAtualizado = jogo;
                                jogoAtualizado.setNome(nome);
                        }
                }
                return jogoAtualizado;
        }

        public Jogo deleteJogo(Long id){
                Jogo jogoDeletado = null;
                for(Jogo jogo: jogos) {
                        if(jogo.getId().equals(id)) {
                                jogo.setAtivo(false);
                                jogoDeletado = jogo;
                        }
                }
                return jogoDeletado;
        }
}
