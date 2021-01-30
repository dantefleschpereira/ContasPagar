package com.fleschworks.contapagar.model;

import com.fleschworks.contapagar.enums.SituacaoConta;
import com.fleschworks.contapagar.exception.OperacaoContaException;

public abstract class Conta {

	// Long id;
	private String descricao;
	private Double valor;
	private String dataVencimento;
	private Cliente cliente;
	protected SituacaoConta situacaoConta;

	public Conta() {
		this.situacaoConta = situacaoConta.PENDENTE;
	}

//	public Long getId() {
//		return id;
//	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public SituacaoConta getSituacaoConta() {
		return situacaoConta;
	}

	public void setSituacaoConta(SituacaoConta situacaoConta) {
		this.situacaoConta = situacaoConta;
	}

	public void cancelar() throws OperacaoContaException {
		if (situacaoConta != situacaoConta.PENDENTE) {
			throw new OperacaoContaException ("Não é possível cancelar. A conta está: " + this.situacaoConta);
				} else {
			situacaoConta = situacaoConta.CANCELADA;
		}
	}

	public abstract void exibirDetalhes();
}
