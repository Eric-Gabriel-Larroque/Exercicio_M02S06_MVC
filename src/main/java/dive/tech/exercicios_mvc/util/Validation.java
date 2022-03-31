package dive.tech.exercicios_mvc.util;

import javax.ws.rs.core.Response;
import java.util.List;

public class Validation {

    public static Response validaListaVazia(List<Object> lista) {
        Response response = null;
        if (lista.isEmpty()) {
            response = Response
                    .noContent()
                    .build();
        }
        return response;
    }
}
