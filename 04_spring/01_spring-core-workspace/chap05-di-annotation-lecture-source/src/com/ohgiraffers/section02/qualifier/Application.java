package com.ohgiraffers.section02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
	
		ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02.qualifier");
		
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		
		pokemonService.pokemonAttack();
		
	
	}
	
}
