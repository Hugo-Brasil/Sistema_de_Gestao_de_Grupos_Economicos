
import org.junit.jupiter.api.Test;

import com.gerenciamento.Entidade;
import com.gerenciamento.GrupoEconomico;

import static org.junit.jupiter.api.Assertions.*;



public class GrupoEconomicoTeste {

        

    @Test

    public void cadastroEntidadeCodigoTeste(){

        GrupoEconomico g = new GrupoEconomico("teste");
        Entidade e = new Entidade("testador", "testlândia");
        g.adicionarEntidadeCodigo(e);


        assertEquals(1, g.getEntidades().size());







        

        

    }

}
