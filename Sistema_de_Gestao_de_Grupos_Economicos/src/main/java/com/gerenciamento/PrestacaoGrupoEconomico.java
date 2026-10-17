package com.gerenciamento;

import java.util.ArrayList;

public class PrestacaoGrupoEconomico {

    ArrayList<GrupoEconomico> prestacoesDoGrupoEconomico = new ArrayList<>();

    public void listarPrestacoesDoGrupoEconomico(){
        for (int index = 0; index < prestacoesDoGrupoEconomico.size(); index++) {
            prestacoesDoGrupoEconomico.get(index).listarPrestacoesDaEntidade();
        }

    }

}
