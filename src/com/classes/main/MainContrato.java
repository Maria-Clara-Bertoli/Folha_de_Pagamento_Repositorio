package com.classes.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.classes.BO.ContratoBO;
import com.classes.DTO.Calculo;
import com.classes.DTO.Contrato;
import com.classes.DTO.Funcionario;

public class MainContrato {

	public static void main(String[] args) throws ParseException {
		
		Contrato contrato = new Contrato();
		Funcionario funcionario = new Funcionario();
		ContratoBO contratoBO = new ContratoBO();
		Calculo calculo = new Calculo();
		
		Scanner valor = new Scanner(System.in);
		
		System.out.println("Informe uma op��o: ");
		System.out.println("op��o 1: inserir contrato");
		System.out.println("op��o 2: alterar local de trabalho");
		System.out.println("op��o 3: alterar cargo");
		System.out.println("op��o 4: excluir contrato");
		System.out.println("op��o 5: pesquisar por c�digo");
		System.out.println("op��o 6: pesquisar por local de trabalho");
		System.out.println("op��o 7: pesquisar por cargo");
		System.out.println("op��o 8: pesquisar calculo");
		System.out.println("op��o 9: pesquisar todos os registros");
		System.out.println("op��o 10: calcular sal�rio base");
		System.out.println("op��o 11: calcular tempo de servi�o");
		int x = valor.nextInt();
		
		switch (x) {
		case 1:
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String datainicio = "05/08/2021";
			String datafinal = "23/04/2025";
			Date datainicioconvertida = sdf.parse(datainicio);
			Date datafinalconvertida = sdf.parse(datafinal);
			funcionario = new Funcionario();
			funcionario.setId(4);
			
			contrato = new Contrato (datainicioconvertida, datafinalconvertida, "Analista de Testes", "IBM", 59.00, 200, funcionario);
			if (contratoBO.inserir(contrato))
				System.out.println("Inserido com Sucesso");
			else
				System.out.println("Erro ao Inserir");
			break;
		case 2:
			contrato = new Contrato();
			contrato.setId(3);
			contrato.setLocal_trabalho("GG Net");
			contratoBO.alterarLocalTrabalho(contrato);
			contrato = contratoBO.procurarPorCodigo(contrato);
			System.out.println(contrato.toString());
			break;
		case 3:
			contrato = new Contrato();
			contrato.setId(3);
			contrato.setCargo("Desenvolvedor");
			contratoBO.alterarCargo(contrato);
			contrato = contratoBO.procurarPorCodigo(contrato);
			System.out.println(contrato.toString());
			break;
		case 4: 
			contrato = new Contrato();
			contrato.setId(3);
			if (contratoBO.excluir(contrato))
				System.out.println("Excluido com Sucesso.");
			else
				System.out.println("Erro ao Excluir.");
			break;
		case 5: 
			contrato = new Contrato();
			contrato.setId(4);
			contrato = contratoBO.procurarPorCodigo(contrato);
			System.out.println(contrato);
			break;
		case 6: 
			contrato = new Contrato();
			contrato.setLocal_trabalho("IBM");
			contrato = contratoBO.procurarPorLocalTrabalho(contrato);
			System.out.println(contrato);
			break;
		case 7: 
			contrato = new Contrato();
			contrato.setCargo("Desenvolvedor");
			contrato = contratoBO.procurarPorCargo(contrato);
			System.out.println(contrato);
			break;
		case 8:
			contrato = new Contrato();
			contrato.setId(3);
			calculo = new Calculo();
			calculo = contratoBO.procurarCalculo(contrato);
			System.out.println(calculo);
			break;
		case 9:
			List<Contrato> lista = new ArrayList<Contrato>();
			lista = contratoBO.pesquisarTodos();	
			for (Contrato elemento : lista) {
				System.out.println(elemento);
			}
			break;
		case 10: 
			System.out.println(contrato.calculaSalarioBase(3));
			break;
		case 11:
			System.out.println(contrato.calculaTempoServico(4));
			break;
		default:
			System.out.println("Op��o inv�lida. Tente novamente!");
		}
		
		valor.close();
	}
}
