package br.game.models;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	
	private String nome;
	private List<Carta> cartasMao;
	private List<Carta> acumuladas;
	private int tamanhoMao;
	private int pontos;
	
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
	
	//Metodo de descarte de cartas
	public Carta descarte(List<Carta> cartasMao, List<Carta> cartasMesa) {
		int index = cartaAleatoria();
	    Carta c = cartasMao.get(index);
	    cartasMao.remove(index);
	    cartasMesa.add(c);
		tamanhoMao--;
		return c;
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
	
	//Metodo que escolhe aleatoriamente a carta da mao do jogador
		private int cartaAleatoria() {
			return (int) Math.floor(Math.random() * 2);
	}
		
	public void comprarCartasTest(Baralho b) throws Exception {
		int i = 0;
			do {
					i++;
					comprarCarta(b);
					tamanhoMao++;
			}while(i < 15);
		}
	//Metodo que para vereficar a comprar de cartas ate o final do baralho sem dispara a exeção
		public void comprarCartaMao(Baralho b) {
			Carta c = b.comprarCartaTest();
			cartasMao.add(c);
			tamanhoMao++;
		}


	//Getters e Setters
	
		public int getPontos() {
			return this.pontos;
		}
		
		public void setPontos(int pontos ) {
		    this.pontos = pontos;
		}
		
		public void setNomeJogador(String nomeJogador) {
			this.nome = nomeJogador;
		}
		public String getNomeJogador() {
			return nome;
		}
		
		public List<Carta> getCartasMao() {
			return cartasMao;
		}
}
