package br.game.models;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
	
	//Atributos da classe jogo
	//Lista de cartas na mesa
	public static List<Carta> cartasMesa = new ArrayList<>();
	//Cria uma lista de jogadores da partida
	public static List<Jogador> jogadores = new ArrayList<>();
	
	public static void main(String[] args) {
		
		//Criação do baralho e dos jogadores e do trunfo 
        //Criando o baralho do jogo
		Baralho b = new Baralho();
		b.embaralhar();//Embaralhando 
				
		//Definindo o trunfo da partida
		Carta trunfo = b.comprarCarta();
		System.out.println("TRUNFO: "+trunfo);
		
		//Criando os 4 jogadores
		Jogador j1 = new Jogador("Romario");
		j1.comprarCartas(b);
		JogadorCopia j2 = new Jogador("Ronaldo");
		j2.comprarCartas(b);
		Jogador j3 = new Jogador("Ney");
		j3.comprarCartas(b);
		Jogador j4 = new Jogador("Pele");
		j4.comprarCartas(b);
		//JogadorCopia j5 = new JogadorCopia();
		
		//mostra cartas dos jogadores
		System.out.println(j1);
		System.out.println(j2);
		System.out.println(j3);
		System.out.println(j4);
		
		System.out.println();
		System.out.println();
	}
}
