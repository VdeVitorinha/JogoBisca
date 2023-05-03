package br.game.testmodels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.game.models.Baralho;
import br.game.models.Baralho;
import br.game.models.Carta;

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
		//Teste de compra de carta pelo metodo cartaNaPosicao
		@Test
		void pegarCartaNoBaralhoOrdenado() {
			Baralho b = new Baralho();
			Carta c = b.cartaNaPosicao(0);
			assertEquals("Copas", c.getNipe());
			assertEquals("2", c.getFaces());
			assertEquals(0, c.getValor());
		}
		//Teste de compra de carta pelo metodo cartaNaPosicao por parametros diferentes
		@Test
		void pegarCartaNoBaralhoOrdenado2() {
			Baralho b = new Baralho();
			Carta c = b.cartaNaPosicao(12);
			assertEquals("Copas", c.getNipe());
			assertEquals("7", c.getFaces());
			assertEquals(10, c.getValor());
		
		}
		//Verificando se o baralho não esta gerando cartas iguais
				@Test
				void comparaCartaSemEmbaralhar() throws Exception{
					Baralho b = new Baralho();
					Carta c = b.comprarCarta();
					
					assertEquals("Copas", c.getNipe());
					assertEquals("2", c.getFaces());
					assertEquals(0, c.getValor());
					
					c = b.comprarCarta();
					
					assertEquals("Copas", c.getNipe());
					assertEquals("3", c.getFaces());
					assertEquals(0, c.getValor());
					
		}	//Faz a compra das cartas do baralho embaralhado e verifica a diferença entre elas
				@Test
				void comparaCartaEmbaralhar() throws Exception{
					Baralho b = new Baralho();
					b.embaralhar();
					Carta c ; 
				    c = b.comprarCarta();		
					assertNotEquals("Copas", c.getNipe());
					assertNotEquals("2", c.getFaces());
					c = b.comprarCarta();
					assertNotEquals("Copas", c.getNipe());
					assertNotEquals("3", c.getFaces());
				
				}
				//Teste que verifica se o baralho foi embaralhado
				@Test
				void comprarPrimeiraCartaEmbaralhado() throws Exception{
					Baralho b = new Baralho();
					b.embaralhar();
					Carta c = b.comprarCarta();
					assertNotEquals("Copas", c.getNipe());
					assertNotEquals("2", c.getFaces());
					}
				
				//Teste que comparar duas cartas de um baralho embaralhado
				@Test
				void compararCartaEmbaralhado() throws Exception{
					Baralho b =  new Baralho();
					b.embaralhar();
					Carta c1 = b.comprarCarta();
					Carta c2 = b.comprarCarta();
					
					assertNotEquals(c1, c2);
				}
					
	

