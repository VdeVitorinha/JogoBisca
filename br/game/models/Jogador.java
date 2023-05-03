package br.game.models;

import java.util.List;

public class Jogador {
	
	private String nome;
	private List<Carta> cartasMao;
	private List<Carta> acumuladas;
	
	//metodo para comprar cartas do do baralho
	public void comprarCarta(Baralho baralho) {
		if (cartasMao.size() < 3) {
			cartasMao.add(baralho.cederCarta());
		}
	}
	
	//metodo para jogar cartas do baralho na mesa
	public void jogarCarta() {
		
	}
	
	

}
