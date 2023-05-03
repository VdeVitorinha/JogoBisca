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
		Jogador j2 = new Jogador("Ronaldo");
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
		int rodada = 0;
		//For loop que vai acontecer as rodadas
		for(int i = 0; i < 1; i++) {
			rodada += 1;
			System.out.println("Rodada "+1);
			
			if(rodada == 1) {
				//Cada jogador joga uma carta da mao para mesa
				Carta c1 = j1.descarte(j1.getCartasMao(), cartasMesa);
				Carta c2 = j2.descarte(j2.getCartasMao(), cartasMesa);
				Carta c3 = j3.descarte(j3.getCartasMao(), cartasMesa); 
				Carta c4 = j4.descarte(j4.getCartasMao(), cartasMesa);
				 System.out.println("Jogada = {J1: "+c1+", J2: "+c2+" , J3: "+c3+" , J4: "+c4+" }" );
			}else {
				for(int k = 0; k < jogadores.size();k++) {
					jogadores.get(k).descarte(jogadores.get(k).getCartasMao(), cartasMesa);
				}
			}		 
		}
	}
	
	//Clase que converte String em inteiro 
	public static int faceToInt(String face) {
	    switch (face) {
	        case "As":
	            return 14;
	        case "2":
	            return 2;
	        case "3":
	            return 3;
	        case "4":
	            return 4; 
	        case "5":
	            return 5;
	        case "6":
	            return 6;
	        case "7":
	            return 7;
	        case "8":
	            return 8;
	        case "9":
	            return 9;
	        case "10":
	            return 10;
	        case "Q":
	            return 11;
	        case "J":
	            return 12;
	        case "K":
	            return 13;
	        default:
	            throw new IllegalArgumentException("Face de carta inválida: " + face);
	    }
}
