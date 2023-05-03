package br.game.testmodels;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.game.models.Baralho;
import br.game.models.Jogador;

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
			Baralho b =  new Baralho();
			Jogador j = new Jogador();
			j.comprarCartaAcumuladas(b);
			assertEquals(0, j.contarPontos());
		}
		
		//Testando o metodo comprarCartas() e o limite de compra de ate 3 cartas.
		@Test
		void limiteDecomprarCartas() throws Exception {
			Baralho b = new Baralho();
			Jogador j = new Jogador();
			j.comprarCartas(b);
		    assertEquals(3, j.tamanhoMao());
		}