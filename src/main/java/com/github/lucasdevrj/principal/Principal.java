package com.github.lucasdevrj.principal;

import java.util.Scanner;
import com.github.lucasdevrj.metodos.AtualizarDesenvolvedor;
import com.github.lucasdevrj.metodos.CadastroDesenvolvedor;
import com.github.lucasdevrj.metodos.ExclusaoDesenvolvedor;
import com.github.lucasdevrj.metodos.Listagem;

public class Principal {
	
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		exibirMenu();
	}

	public static void exibirMenu() {
		System.out.println("\n1 - Cadastrar Desenvolvedor");
		System.out.println("2 - Listar Desenvolvedores");
		System.out.println("3 - Excluir Desenvolvedor");
		System.out.println("4 - Atualizar Desenvolvedor");
		System.out.println("5 - Listar Tecnologias");
		System.out.println("6 - Listar Cargos");
		System.out.println("7 - Listar Graduações");
		System.out.println("8 - Listar Áreas");
		
		System.out.print("Digite sua opção: ");
		int opcao = entrada.nextInt();
		System.out.println();
		Listagem listagem = new Listagem();
		switch (opcao) {
			case 1:
				CadastroDesenvolvedor cadastroDesenvolvedor = new CadastroDesenvolvedor();
				cadastroDesenvolvedor.cadastrar();
			break;
			
			case 2:
				listagem.listarDesenvolvedores();
			break;
			
			case 3:
				ExclusaoDesenvolvedor excluirDesenvolvedor = new ExclusaoDesenvolvedor();
				excluirDesenvolvedor.excluir();
			break;
			
			case 4:
				AtualizarDesenvolvedor atualizarDesenvolvedor = new AtualizarDesenvolvedor();
				atualizarDesenvolvedor.atualizar();
			break;
			
			case 5:
				listagem.listarTecnologias();
			break;
			
			case 6:
				listagem.listarCargos();
			break;
			
			case 7:
				listagem.listarGraduacoes();
			break;
			
			case 8:
				listagem.listarAreas();
			break;
		}
	}
}
