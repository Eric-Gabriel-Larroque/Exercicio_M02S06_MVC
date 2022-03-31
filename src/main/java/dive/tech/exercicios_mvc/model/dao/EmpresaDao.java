package dive.tech.exercicios_mvc.model.dao;

import dive.tech.exercicios_mvc.model.entity.Empresa;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

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
}
