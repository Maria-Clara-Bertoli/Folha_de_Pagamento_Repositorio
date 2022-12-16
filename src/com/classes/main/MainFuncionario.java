package com.classes.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.classes.BO.FuncionarioBO;
import com.classes.DTO.Contrato;
import com.classes.DTO.Funcionario;

public class MainFuncionario {

	public static void main(String[] args) throws ParseException {
		
		Funcionario funcionario = new Funcionario();
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		
		Scanner valor = new Scanner(System.in);
		
		System.out.println("Informe uma op��o: ");
		System.out.println("op��o 1: inserir funcion�rio");
		System.out.println("Op��o 2: alterar nome");
		System.out.println("op��o 3: excluir funcion�rio");
		System.out.println("op��o 4: pesquisar por c�digo");
		System.out.println("op��o 5: pesquisar por nome");
		System.out.println("op��o 6: pesquisar contratos");
		System.out.println("op��o 7: pesquisar todos os registros");
		int x = valor.nextInt();
		
		switch(x) {
		case 1:
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String datanascimento = "17/04/2003";
			Date dataconvertida = sdf.parse(datanascimento);
			funcionario = new Funcionario("M�nica", "389.086.257-87", dataconvertida);
			if(funcionarioBO.inserir(funcionario)) {
				System.out.println("Iserido com sucesso");
			}
			else {
				System.out.println("Erro ao inserir");
			}
			break;
		case 2:
			funcionario = new Funcionario();
			funcionario.setId(2);
			funcionario.setNome("J�ssica");
			funcionarioBO.alterarNome(funcionario);
			funcionario = funcionarioBO.procurarPorCodigo(funcionario);
			System.out.println(funcionario.toString());
			break;
		case 3: 
			funcionario = new Funcionario();
			funcionario.setId(4);
			if (funcionarioBO.excluir(funcionario))
				System.out.println("Excluido com sucesso.");
			else
				System.out.println("Erro ao excluir.");
			break;
		case 4:
			funcionario = new Funcionario();
			funcionario.setId(2);
			funcionario = funcionarioBO.procurarPorCodigo(funcionario);
			System.out.println(funcionario.toString());
			break;
		case 5: 
			funcionario = new Funcionario();
			funcionario.setNome("M�nica");
			funcionario = funcionarioBO.procurarPorNome(funcionario);
			System.out.println(funcionario.toString());
			break;
		case 6:
			List <Contrato> listacontratos = new ArrayList <Contrato>();
			funcionario = new Funcionario();
			funcionario.setId(2);
			listacontratos = funcionarioBO.procurarContratos(funcionario);
			for(Contrato elemento : listacontratos) {
				System.out.println(elemento.toString());
			}
			break;
		case 7: 
			List <Funcionario> listafuncionarios = new ArrayList <Funcionario>();
			listafuncionarios = funcionarioBO.pesquisarTodos();
			for(Funcionario elemento : listafuncionarios) {
				System.out.println(elemento.toString());
			}
			break;
		default:
			System.out.println("Op��o inv�lida. Tente novamente!");
		}
		
		valor.close();
	}
}
