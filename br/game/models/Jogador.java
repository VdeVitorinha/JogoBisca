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
		this.nome = nome;
		
	}
	
	public Jogador() {
		cartasMao = new ArrayList<>();
		acumuladas = new ArrayList<>();
		
	}
	
	public int tamanhoMao() {
		return this.cartasMao.size();
	}
	
	
	
	//metodo para comprar cartas do do baralho
	public void comprarCarta(Baralho baralho) {
		if (cartasMao.size() < 3) {
			cartasMao.add(baralho.cederCarta());
		}
	}
	

	//metodo para comprar cartas do do baralho
	public void comprarCartas(Baralho baralho) {
		while (this.cartasMao.size() < 3){
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
	
	
	//Metodo de calculo do valor das cartas
		public int contarPontos() {
			int aux = 0;
			for(Carta carta : acumuladas) {
				//aux += carta.getValor();
				aux += carta.getValor();
				pontos += aux;
			}
			return aux;
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
		
		
		//Metodo semelhante ao anterior porem ele compra cartas ate o fina do baralho
				public void comprarCartasAteFinalBaralho(Baralho b) throws Exception {
					int i = 0;
					do {
							i++;
							comprarCartaMao(b);
							tamanhoMao++;
					}while(i < 52);
				}
		
		
		//Metodo usados para teste:
		
		public int contarPontosTest() {
			int aux = 0;
			for(Carta carta : cartasMao) {
				aux += carta.getValor();
			}
			return aux;
		}
		
		//Metodo para testar a lista cartasAcumuladas
		public void comprarCartaAcumuladas(Baralho b) throws Exception{
			Carta c = b.comprarCarta();
			acumuladas.add(c);
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
