
package com.fleschworks.contapagar.model;

import com.fleschworks.contapagar.exception.OperacaoContaException;

public class ContaPagar extends Conta {

	Fornecedor fornecedor;

	public ContaPagar() {
		super();
	}

	public ContaPagar(Fornecedor fornecedor, String descricao, Double valor, String dataVencimento) {
		this.fornecedor = fornecedor;
		this.setDataVencimento(dataVencimento);
		this.setValor(valor);
		this.setDescricao(descricao);
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void pagar() throws OperacaoContaException {
		if (situacaoConta != situacaoConta.PENDENTE) {
			throw new OperacaoContaException ("Não é possível efetuar pagamento. A conta está: " + this.getSituacaoConta());
		} else {
			situacaoConta = situacaoConta.PAGA;
			System.out.print("\nConta: " + getDescricao() + "\nFornecedor: " + getFornecedor().getNome() + "\nValor: "
					+ getValor() + "\nData de Vencimento: " + getDataVencimento() + "\nSituação: " + getSituacaoConta()
					+ "\n");
		}

	}

	@Override
	public void exibirDetalhes() {
		System.out.print(
				"\nConta: " + getDescricao() + "\nFornecedor: " + getFornecedor().getNome() + "\nValor: " + getValor()
						+ "\nData de Vencimento: " + getDataVencimento() + "\nSituação: " + getSituacaoConta() + "\n");

	}

}
