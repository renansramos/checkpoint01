package br.com.fiap.main;

import java.time.LocalDate;

import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.service.impl.LivroServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		LivroServiceImpl livroService = LivroServiceImpl.getInstance();
		
		Livro livro1 = new Livro("Livro 1", "Carlos ", 852504113 , 2, LocalDate.of(1980, 1, 1));
		Livro livro2 = new Livro("Livro 2", "Leal ", 234234113 , 4, LocalDate.of(1990, 2, 4));
		Livro livro3 = new Livro("Livro 3", "Douglas Adams ", 325546113 , 5, LocalDate.of(2021, 3, 5));
		
		livroService.inserir(livro1);
		livroService.inserir(livro2);
		livroService.inserir(livro3);
	
		livroService.remover(3L);
		
		livro2.setEdicao(3);
		livroService.atualizar(livro2);
		
		livroService.listar().forEach(System.out::println);
	}
	
	
	
}


