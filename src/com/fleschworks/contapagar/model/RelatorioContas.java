package com.fleschworks.contapagar.model;

public class RelatorioContas {

	public void exibirListagem(Conta[] contas) {
		System.out.println("\n###RELAT�RIO###");
		for (Conta conta : contas) {
			conta.exibirDetalhes();
		}
	}
}
