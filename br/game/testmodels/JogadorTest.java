package br.game.testmodels;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.game.models.BaralhoCopia;
import br.game.models.JogadorCopia;

public class JogadorTest {
	//Teste para comprar a primeira carta do 
		//baralho de forma ordenada.
		
		@Test
		void comprarPrimeiraCartaSemEmbaralhar() throws Exception{
			Baralho b =  new Baralho();
			Jogador j = new Jogador();
		    j.comprarCarta(b);
			assertEquals(0, j.contarPontosTest());
		}
}