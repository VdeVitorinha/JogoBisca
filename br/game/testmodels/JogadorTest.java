package br.game.testmodels;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.game.models.Baralho;
import br.game.models.Baralho;
import br.game.models.Baralho;
import br.game.models.Baralho;
import br.game.models.Baralho;
import br.game.models.Jogador;
import br.game.models.Jogador;
import br.game.models.Jogador;
import br.game.models.Jogador;
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
	
	//Teste para verifica a soma da pontuação dos jogador
	@Test
	void somaPontosJogador() throws Exception{
		Baralho b = new Baralho();
		Jogador j = new Jogador();
		j.comprarCarta(b);
		j.comprarCarta(b);
		assertEquals(0, j.contarPontos());
	}
	
	//Teste da soma das cartas de um nipe 
		@Test
		void somaPontosJogadorDois()throws Exception {
			Baralho b = new Baralho();
			Jogador j = new Jogador();
			j.comprarCartasTest(b);
			assertEquals(30, j.contarPontosTest());
		}
		
		//Teste de compra cartas e soma 
		@Test 
		void somaPontosDoBaralhoInteiro() throws Exception{
			Baralho b = new Baralho();
			Jogador j = new Jogador();
			j.comprarCartasAteFinalBaralho(b);
			assertEquals(120, j.contarPontosTest());
		}
		
		//Teste de compra cartas e soma de forma embaralhada
		void somaPontosDoBaralhoInteiroEmbaralhado() throws Exception{
			Baralho b = new Baralho();
			Jogador j = new Jogador();
			b.embaralhar();
			j.comprarCartasAteFinalBaralho(b);
			assertEquals(120, j.contarPontosTest());
		}
	}