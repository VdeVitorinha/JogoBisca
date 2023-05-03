package br.game.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {
	
	//Atributos da classe jogo
	//Lista de cartas na mesa
	public static List<Carta> cartasMesa = new ArrayList<>();
	//Cria uma lista de jogadores da partida
	public static List<Jogador> jogadores = new ArrayList<>();
	
	public static boolean temTrunfo = false;
	
	public static void main(String[] args) {
		
		//Criação do baralho e dos jogadores e do trunfo 
        //Criando o baralho do jogo
		Baralho b = new Baralho();
		b.embaralhar();//Embaralhando 
				
		//Definindo o trunfo da partida
		Carta trunfo = b.comprarCarta();
		System.out.println("TRUNFO: "+trunfo);
		
		//Criando os 4 jogadores
		Jogador j1 = new Jogador("J1");
		j1.comprarCartas(b);
		Jogador j2 = new Jogador("J2");
		j2.comprarCartas(b);
		Jogador j3 = new Jogador("J3");
		j3.comprarCartas(b);
		Jogador j4 = new Jogador("J4");
		j4.comprarCartas(b);
		//JogadorCopia j5 = new JogadorCopia();
		
		//mostra cartas dos jogadores
		System.out.println(j1);
		System.out.println(j2);
		System.out.println(j3);
		System.out.println(j4);
		
		System.out.println();
		System.out.println();
		
		 jogadores.add(j1);
	     jogadores.add(j2);
	     jogadores.add(j3);
	     jogadores.add(j4);
		    
		
		int rodada = 0;
		//For loop que vai acontecer as rodadas
		for(int i = 0; i < 1; i++) {
			rodada += 1;
			
			System.out.println();
		    
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
				mostraJogada();
			}
			
			
			Carta maiorCarta = cartasMesa.get(0);
			String primeiroNipe = cartasMesa.get(0).getNipe();
			int valorPrimeiraCarta = maiorCarta.getValor();
			Jogador jogadorMaiorFace = null;
			//Cartas com os nipes iguais 
			for(int z =0; z < 1; z++) {
				for(int x = z + 1 ; x < cartasMesa.size(); x++) {
					Carta cartaJogada = cartasMesa.get(x);
					String nipeVez = cartasMesa.get(x).getNipe();
					int valorRodada = cartasMesa.get(x).getValor();					
					if(primeiroNipe == nipeVez && primeiroNipe.equals(nipeVez)) {
							if((cartaJogada.getValor() == 0) && (maiorCarta.getValor() == 0)) {
								if(faceToInt(cartaJogada.getFaces()) >= faceToInt(maiorCarta.getFaces())) {
									System.out.println(maiorCarta = cartaJogada);
									System.out.println(jogadorMaiorFace = jogadores.get(x));
									Collections.swap(jogadores, x, 0);
									System.out.println("banana");
								}
							}else if((cartaJogada.getValor() > 1 && cartaJogada.getValor() < 12) || 
									(maiorCarta.getValor() > 1  && maiorCarta.getValor() < 12)) {
								    if(valorRodada > valorPrimeiraCarta) {
								    	System.out.println(maiorCarta = cartaJogada);
								    	valorPrimeiraCarta = valorRodada;
								    	System.out.println(jogadorMaiorFace = jogadores.get(x));
								    	Collections.swap(jogadores, x, 0);
								    }else {		
								        System.out.println("poda");
								    }
								   }
			      }
		       }  
			}
			
			String nipeTrunfo = trunfo.getNipe();
			Jogador jogadorTrunfo = null ;
			int pos = 0;
			//Cartas com nipes diferentes e sem trunfo
			for(int w = 0; w < 1 ;w++) {
				for(int x = w ; x < cartasMesa.size() + 1; x++) {
					Carta cartaJogada = cartasMesa.get(x);
					//JogadorCopia jogadorRodada = jogadores.get(x);
					String nipeVez = cartasMesa.get(x).getNipe();
					if(! (primeiroNipe == nipeVez && primeiroNipe.equals(nipeVez))) {
						if((primeiroNipe == nipeTrunfo && primeiroNipe.equals(nipeTrunfo)) || 
						  (nipeVez == nipeTrunfo && nipeVez.equals(nipeTrunfo))) {
							jogadorTrunfo = jogadores.get(x);
							pos = x;
							temTrunfo = true;
					    }
				    }
				    
				}
				
			}
			if(temTrunfo == true) {
				Collections.swap(jogadores, pos, 0);
				jogadorTrunfo.recebeAcumuladas(cartasMesa);
			}else {
	            String jNome = jogadores.get(0).getNomeJogador();
				//jogadores.get(0).pegarCartas(cartasMesa); 
				System.out.println("Jogador da rodada "+jNome);

			}	
		    
			//No final de cada rodada cada jogador vai ter duas cartas, logo é necessario eles comprarem uma carta a cada final de rodada
			j1.comprarCarta(b);
			j2.comprarCarta(b);
			j3.comprarCarta(b);
			j4.comprarCarta(b);
			
			System.out.println();
			System.out.println();
			
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
	
	public static String mostraJogada() {
		
		System.out.println("Jogadores {"+jogadores.get(0).getNomeJogador()+" Jogada {"+cartasMesa.get(0)+"} "
				+jogadores.get(1).getNomeJogador()+" Jogada {"+cartasMesa.get(1)+"} "+jogadores.get(2).getNomeJogador()+" Jogada {"+cartasMesa.get(2)+"} "
				+ ""+jogadores.get(3).getNomeJogador()+" Jogada {"+cartasMesa.get(3)+"}}");
	
	return null;
}
}
