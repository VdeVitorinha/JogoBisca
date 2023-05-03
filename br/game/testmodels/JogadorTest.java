package br.game.testmodels;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.game.models.BaralhoCopia;
import br.game.models.JogadorCopia;

public class JogadorTest {
	//Teste realizar a primeira compra no baralho de forma ordenada.
		@Test
		void comprarPrimeiraCartaSemEmbaralhar() throws Exception{
			Baralho b =  new Baralho();
			Jogador j = new Jogador();
		    j.comprarCarta(b);
			assertEquals(0, j.contarPontosTest());
		}
}

	//Teste refeito.
		@Test
		void comprarPrimeiraCartaSemEmbaralharDois() throws Exception{
			BaralhoCopia b =  new BaralhoCopia();
			JogadorCopia j = new JogadorCopia();
			j.comprarCartaAcumuladas(b);
			assertEquals(0, j.contarPontos());
		}