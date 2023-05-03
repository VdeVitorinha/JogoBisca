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
<<<<<<< HEAD
=======
	
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
>>>>>>> 9a47b974ff606d72186020dadc70a38c3da61a51
}
