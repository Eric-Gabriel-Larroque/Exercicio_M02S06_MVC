package dive.tech.exercicios_mvc.model.dao;

import dive.tech.exercicios_mvc.model.entity.Empresa;
import dive.tech.exercicios_mvc.model.entity.Jogo;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dive.tech.exercicios_mvc.util.Validation.validaListaVazia;

@ApplicationScoped
public class EmpresaDao {

    public static List<Empresa> empresas = new ArrayList<>();

    public Empresa createEmpresa(Empresa empresa) {

        long listSize =  empresas.size()==0?0L:empresas.size();

        empresa.setNome(empresa.getNome());
        empresa.setId((listSize+1));
        empresas.add(empresa);
        return empresa;
    }

    public List<Empresa> getEmpresas() {
        List<Empresa> listaEmpresas = empresas;
        validaListaVazia(Collections.singletonList(listaEmpresas));
        for(Empresa empresa: listaEmpresas) {
            if(!empresa.isAtivo()) {
                listaEmpresas.remove(empresa);
            }
        }
        return listaEmpresas;
    }
}
