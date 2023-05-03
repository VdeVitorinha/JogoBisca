package br.game.testmodels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.game.models.Baralho;

public class BaralhoTest {
	
	//Teste que testa o tamanho do baralho
	@Test
	void tamanhoBaralho() {
		Baralho b =  new Baralho();
		assertEquals(52, b.tamanhoMonte());
}
