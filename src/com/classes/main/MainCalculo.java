package com.classes.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.classes.BO.CalculoBO;
import com.classes.DTO.Calculo;
import com.classes.DTO.Contrato;

public class MainCalculo {

	public static void main(String[] args) {
		
		Calculo calculo = new Calculo();
		CalculoBO calculoBO = new CalculoBO();
		Contrato contrato = new Contrato();
		
		Scanner valor = new Scanner (System.in);
		
		System.out.println("Informe uma op��o: ");
		System.out.println("op��o 1: inserir par�metros do c�lculo");
		System.out.println("op��o 2: alterar vale transporte");
		System.out.println("op��o 3: alterar vale alimenta��o");
		System.out.println("op��o 4: excluir c�lculo");
		System.out.println("op��o 5: pesquisar por c�digo");
		System.out.println("op��o 6: pesquisar todos os registros");
		System.out.println("op��o 7: emitir folha mensal");
		System.out.println("op��o 8: emitir folha de f�rias");
		System.out.println("op��o 9: emitir folha de d�cimo terceiro");
		System.out.println("op��o 10: emitir folha de rescis�o");
		
		int x = valor.nextInt();
		
		switch (x) {
		case 1:
			contrato = new Contrato();
			contrato.setId(1);
			calculo = new Calculo(400.0, 500.0, contrato);
			if (calculoBO.inserir(calculo)) {
				System.out.println("Inserido com sucesso.");
			}
			else {
				System.out.println("Erro ao inserir.");
			}
			break;
		case 2:
			calculo = new Calculo();
			calculo.setId(1);
			calculo.setVale_transporte(300);
			calculoBO.alterarValeTransporte(calculo);
			calculo = calculoBO.procurarPorCodigo(calculo);
			System.out.println(calculo.toString());
			break;
		case 3:
			calculo = new Calculo();
			calculo.setId(1);
			calculo.setVale_alimentacao(680);
			calculoBO.alterarValeAlimentacao(calculo);
			calculo = calculoBO.procurarPorCodigo(calculo);
			System.out.println(calculo.toString());
			break;
		case 4:
			calculo = new Calculo();
			calculo.setId(2);
			if (calculoBO.excluir(calculo))
				System.out.println("Excluido com sucesso.");
			else
				System.out.println("Erro ao excluir.");
			break;
		case 5:
			calculo = new Calculo();
			calculo.setId(3);
			calculo = calculoBO.procurarPorCodigo(calculo);
			System.out.println(calculo.toString());
			break;
		case 6:
			List<Calculo> listatodos = new ArrayList<Calculo>();
			listatodos = calculoBO.pesquisarTodos();	
			for (Calculo elemento : listatodos) {
				System.out.println(elemento.toString());
			}
			break;
		case 7:
			calculo = new Calculo();
			System.out.println(calculo.imprimeMensal(1)); 
			break;
		case 8:
			calculo = new Calculo();
			System.out.println(calculo.imprimeFerias(1)); 
			break;
		case 9:
			calculo = new Calculo();
			System.out.println(calculo.imprimeDecimo(3, 1)); 
			break;
		case 10:
			calculo = new Calculo();
			System.out.println(calculo.imprimeRescisao(25, 8, 1)); 
			break;
		}
		
		valor.close();
	}
}
