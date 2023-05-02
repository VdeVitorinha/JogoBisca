package br.game.models;

import java.util.Objects;

public class Carta {
	
	//Atributos
	private String nipe;
	private String face;
	private int valor;
	
	//ADD Contrutor
	public Carta(String nipe, String face, int valor) {
		this.nipe = nipe;
		this.face = face;
		this.valor = valor;
	}
	
	//Setters
	public void setFace(String face) {
		this.face = face;
	}
	
	
	public void setNipe(String nipe) {
		this.nipe = nipe;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	//Getters:
	
		public String getNipe() {
			return this.nipe;
		}
		
		public String getFaces() {
			return this.face;
		}
		
		public int getValor() {
			return this.valor;
		}
		//Metodo toString 
		@Override
		public String toString() {
			return ""+this.face+" "+this.nipe+"";
		}
		//HashCode e equals - 6
		@Override
		public int hashCode() {
			return Objects.hash(face, nipe, valor);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CartaCopia other = (CartaCopia) obj;
			return Objects.equals(face, other.face)
					&& Objects.equals(nipe, other.nipe) && valor == other.valor;
		}

	}