package br.game.testmodels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.game.models.Baralho;
import br.game.models.BaralhoCopia;
import br.game.models.CartaCopia;

public class BaralhoTest {
	
	//Teste que testa o tamanho do baralho
	@Test
	void tamanhoBaralho() {
		Baralho b =  new Baralho();
		assertEquals(52, b.tamanhoMonte());
}
	//Teste que verifica o tamaho do monte depois de todos os jogadores terem comprados
		@Test
		void tamanhoMonteDepoisDeComprar()throws Exception {
			Baralho b = new Baralho();
			b.comprarCarta();
			assertEquals(51, b.tamanhoMonte());
		}
		//Teste de verificação de igualdade da classe Carta
		@Test
		void pegarCartaMonte() throws Exception{
			Baralho b = new Baralho();
			Carta c = b.comprarCarta();
			assertEquals("class br.game.models.Carta", c.getClass().toString());
		}
}
