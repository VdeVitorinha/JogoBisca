package br.game.testmodels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.game.models.Baralho;
import br.game.models.Baralho;
import br.game.models.Carta;
import br.game.models.Carta;

public class CartaTeste {
	//Teste que verifica se a classe carta está funcionando e a classe baralho
	@Test 
	void pegarCartaCorreta() {
		Baralho b = new Baralho();
		Carta c = b.obterCartaUm("Copas", "2", 0);
		assertEquals(c.getNipe(), "Copas");
		assertEquals(c.getFaces(), "2");
		assertEquals(c.getValor(), 0);
	}
	//Teste da classe carta com outros parâmetros
	@Test
	void pegarCartaCorretaDois() {
		Baralho b = new Baralho();
		Carta c = b.obterCartaDois("Copas", "As", 11);
		assertEquals(c.getNipe(), "Copas");
		assertEquals(c.getFaces(), "As");
		assertEquals(c.getValor(), 11);
	}
}
