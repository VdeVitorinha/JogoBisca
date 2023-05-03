package br.game.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
	Random random = new Random();
	
	private List<Carta> monte;
	
	//Construtor do baralho, são usadas strings com as combinações para criar
	// por meio de laços de repetição, a lista que conterá os objetos Carta
	public Baralho() {
		String[] nipe = {"Copas", "Espadas", "Ouros", "Paus"};
		String[] faces = {"2","3","4","5","6","8","9","10","Q","J","K","As","7"};
		int[] vetValor = { 0,  0,  0,  0,  0,  0,  0,  0,  2,  3,  4,  11,  10};
		
		this.monte = new ArrayList<>();
		
		for(int i = 0; i < nipe.length; i++) {
			for(int j = 0; j < faces.length; j++) {
				this.monte.add(new Carta(nipe[i], faces[j], vetValor[j]));
			}
		}
		tamanhoBaralho();
	}
	//Metodo que o baralho cede cartas 
	public Carta cederCarta() {
		int posicao = random.nextInt(tamanhoBaralho());
		Carta carta = monte.get(posicao);
		monte.remove(posicao);
		
		return carta;
	}
	
	//método que retornará o tamanho do monte de cartas
	public int tamanhoBaralho() {
		return monte.size();
	}
	
	//Metodo de teste que compra cartas da classe baralho
		 public Carta comprarCarta() throws Exception{
			 try {
				 this.tamanhoMonte--;
				 if(this.tamanhoMonte == 0) {
					 throw new Exception("Fim do baralho");
				 }
				 return cartaNaPosicao(0);
			 }catch(Exception e ) {
				 e.printStackTrace();
				/* 
				 * Este metodo retorna a pilha de chamadas completa quando 
				 * uma exceção é lançada e quais metodos e linhas de codigos
				 * levaram ates esse ponto
				 * 
				 * */
			 }
			 return null;
		 }
		 
		 //Metodo de teste alterado para não dispara a exceção - pedro
		 public Carta comprarCartaTest() {
			 try {
				 this.tamanhoMonte--;
				 if(this.tamanhoMonte == 0) {
					 System.out.println("Fim do Baralho");
				 }
				 return cartaNaPosicao(0);
			 }catch(Exception e ) {
				 e.printStackTrace();
				/* 
				 * Este metodo retorna a pilha de chamadas completa quando 
				 * uma exceção é lançada e quais metodos e linhas de codigos
				 * levaram ates esse ponto
				 * 
				 * */
			 }
			 return null;
		 }
		 /*
		  * Metodo usado para retorna a carta na posicao escolhida
		  * Ele tem um if-else, onde é usado como codicional o atributo embaralhar
		  * se ele for true ele pega uma carta no baralho de forma aleatoria
		  * caso não ele retorna o baralho na posicao indicada que é sempre 0 ou seja 
		  * a primeira posicao.
		  *
		  **/
		 public Carta cartaNaPosicao(int pos) {
			 if(this.embaralhar) {
				 if(this.tamanhoMonte == 1) {
					 Carta c = this.monte.get(0);
					 this.monte.remove(0);
					 return c;
				 }
				 
				 int index = posCarta();
				 Carta c = this.monte.get(index);
				 this.monte.remove(index);
				 return c;
			 }else {
				 Carta c = this.monte.get(pos);
				 this.monte.remove(pos);
				 return c;
			 }
			//Metodo que gera a proxima carta de forma aleatoria
			 private int posCarta() {
				 return (int) Math.floor(Math.random() * this.tamanhoMonte);	
			 }
			//Metodo usado para ativar o embaralhamento
			 public void embaralhar() {
				 this.embaralhar = true;
			 }
		 }

}