package dive.tech.exercicios_mvc.model.service;

import dive.tech.exercicios_mvc.model.dao.EmpresaDao;
import dive.tech.exercicios_mvc.model.entity.Empresa;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class EmpresaService {

    private EmpresaDao empresaDao = new EmpresaDao();

    public Empresa createEmpresa(Empresa empresa) {
        return empresaDao.createEmpresa(empresa);
    }

    public List<Empresa> getEmpresas() {
        return empresaDao.getEmpresas();
    }
}
