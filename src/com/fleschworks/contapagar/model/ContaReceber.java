package com.fleschworks.contapagar.model;

import com.fleschworks.contapagar.exception.OperacaoContaException;

public class ContaReceber extends Conta {

	Cliente cliente;

	public ContaReceber() {
		super();
	}

	public ContaReceber(Cliente cliente, String descricao, Double valor, String dataVencimento) {

		this.cliente = cliente;
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setDataVencimento(dataVencimento);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void receber() {
		System.out.print("\nConta: " + getDescricao() + "\nFornecedor: " + getCliente().getNome() + "\nValor: "
				+ getValor() + "\nData de Vencimento: " + getDataVencimento() + "\nSituação: Conta RECEBIDA" + "\n");
	}

	public void cancelar() throws OperacaoContaException  {
		if (getValor() > 50000) {
			throw new OperacaoContaException("Essa conta não pode ser cancelada");
		} else {
			super.cancelar();
		}
	}

	@Override
	public void exibirDetalhes() {
		System.out.print("\nConta: " + getDescricao() + "\nFornecedor: " + getCliente().getNome() + "\nValor: "
				+ getValor() + "\nData de Vencimento: " + getDataVencimento() + "\nSituação: Conta RECEBIDA" + "\n");

	}
}
