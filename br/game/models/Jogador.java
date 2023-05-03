package br.game.models;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	
	private String nome;
	private List<Carta> cartasMao;
	private List<Carta> acumuladas;
	private int tamanhoMao = 0;
	

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
	
	//Metodo de descarte das cartas 
	public Carta descarte(List<Carta> cartasMao, List<Carta> cartasMesa) {
		int index = cartaAleatoria();
	    Carta c = cartasMao.get(index);
	    cartasMao.remove(index);
	    cartasMesa.add(c);
		tamanhoMao--;
		return c;
	}
	
	//Metodo que escolhe aleatoriamente a carta da mao do jogador
		private int cartaAleatoria() {
			return (int) Math.floor(Math.random() * 2);
	}
	public void comprarCartasTest(BaralhoCopia b) throws Exception {
		int i = 0;
		do {
				i++;
				comprarCarta(b);
				tamanhoMao++;
		}while(i < 15);
		}
}
