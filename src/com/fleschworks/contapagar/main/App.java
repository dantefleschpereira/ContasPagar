package com.fleschworks.contapagar.main;

import com.fleschworks.contapagar.exception.OperacaoContaException;
import com.fleschworks.contapagar.model.Cliente;
import com.fleschworks.contapagar.model.Conta;
import com.fleschworks.contapagar.model.ContaPagar;
import com.fleschworks.contapagar.model.ContaReceber;
import com.fleschworks.contapagar.model.Fornecedor;
import com.fleschworks.contapagar.model.RelatorioContas;

public class App {

	public static void main(String[] args) {
		// instanciando fornecedores
				Fornecedor imobiliaria = new Fornecedor();
				imobiliaria.setNome("Casa & Cia Negócios Imobiliários");
				Fornecedor mercado = new Fornecedor();
				mercado.setNome("Mercado do João");
				
				// instanciando clientes
				Cliente atacadista = new Cliente();
				atacadista.setNome("Triângulo Quadrado Atacadista");
				Cliente telecom = new Cliente();
				telecom.setNome("FoneNet Telecomunicações");
				
				// instanciando contas a pagar
				ContaPagar contaPagar1 = new ContaPagar();
				contaPagar1.setDescricao("Aluguel da matriz");
				contaPagar1.setValor(1230d);
				contaPagar1.setDataVencimento("10/05/2012");
				contaPagar1.setFornecedor(imobiliaria);
				try {
					contaPagar1.pagar();
				} catch (OperacaoContaException e1) {
					System.err.println(e1.getMessage());
				}
				
				try {
					contaPagar1.pagar();
				} catch (OperacaoContaException e1) {
					System.err.println(e1.getMessage());
				}
				
				
				ContaPagar contaPagar2 = new ContaPagar(mercado, "Compras do mês", 390d, "19/05/2012");
				
				// instanciando contas a receber
				ContaReceber contaReceber1 = new ContaReceber();
				contaReceber1.setDescricao("Desenvolvimento de projeto de logística em Java");
				contaReceber1.setValor(89500d);
				contaReceber1.setDataVencimento("23/05/2012");
				contaReceber1.setCliente(atacadista);
				try {
					contaReceber1.cancelar();
				} catch (OperacaoContaException e) {
					System.err.println(e.getMessage());
				}
				
				ContaReceber contaReceber2 = new ContaReceber(telecom, "Manutenção em sistema de conta online", 
					53200d, "13/05/2012");
				
				// exibe listagem de todas as contas com detalhamento
				RelatorioContas relatorio = new RelatorioContas();
				Conta[] contas = new Conta[]{contaPagar1, contaPagar2, contaReceber1, contaReceber2};
				
				relatorio.exibirListagem(contas);
			}

}
