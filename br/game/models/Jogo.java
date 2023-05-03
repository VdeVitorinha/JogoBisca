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
	}
}
