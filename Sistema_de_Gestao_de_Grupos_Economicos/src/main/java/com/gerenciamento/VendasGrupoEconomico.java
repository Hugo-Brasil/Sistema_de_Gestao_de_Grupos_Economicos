package com.gerenciamento;

import java.util.ArrayList;

public class VendasGrupoEconomico {
    
    ArrayList<GrupoEconomico> vendasDoGrupoEconomicos = new ArrayList<>();

    public void listarVendasDoGrupoEconomico(){
        for (int index = 0; index < vendasDoGrupoEconomicos.size(); index++) {
            vendasDoGrupoEconomicos.get(index).listarVendasDaEntidade();
        }

    }

}
