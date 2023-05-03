package br.game.models;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	
	private String nome;
	private List<Carta> cartasMao;
	private List<Carta> acumuladas;
	

	public Jogador(String nome) {
		cartasMao = new ArrayList<>();
		acumuladas = new ArrayList<>();
		
	}
	
	//metodo para comprar cartas do do baralho
	public void comprarCarta(Baralho baralho) {
		if (cartasMao.size() < 3) {
			cartasMao.add(baralho.cederCarta());
		}
	}
	
	//metodo para jogar cartas do baralho na mesa
	public Carta jogarCarta(int posicao) {
		Carta carta = cartasMao.get(posicao);
		cartasMao.remove(posicao);
		
		return carta;
	}
	
	public void recebeAcumuladas(List<Carta> cartasMesa) {
		for(Carta carta : cartasMesa) {
			this.acumuladas.add(carta);
		}
		
	}
	@Override
	public String toString() {
		return "("+nome+")"+cartasMao;
	}
	
	//Getters e Setters
	
		public int getPontos() {
			return this.pontos;
		}
		
		public void setPontos(int pontos ) {
		    this.pontos = pontos;
		}
		
		public void setNomeJogador(String nomeJogador) {
			this.nomeJogador = nomeJogador;
		}
		public String getNomeJogador() {
			return nomeJogador;
		}
}
