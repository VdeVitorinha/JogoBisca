package br.game.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baralho {
	Random random = new Random();
	
	private List<Carta> monte;
	
	public Baralho() {
		String[] nipe = {"Copas", "Espadas", "Ouros", "Paus"};
		String[] faces = {"2","3","4","5","6","8","9","10","Q","J","K","As","7"};
		
		this.monte = new ArrayList<>();
		
		for(int i = 0; i < nipe.length; i++) {
			for(int j = 0; j < faces.length; j++) {
				this.monte.add(new Carta (nipe[i], faces[j]));
			}
		}		
	}
	
	
	
	public int tamanhoBaralho() {
		return monte.size();
	}
	
	public Carta cedeCarta() {
		int posicao = random.nextInt(tamanhoBaralho());
		Carta carta = monte.get(posicao);
		monte.remove(posicao);
		
		return carta;
	}
}
