package br.com.maplink.calculadorvaloresrotas.builder;

import br.com.maplink2.webservices.City;

/**
 * 
 * @author luizleme
 *
 */
public class CityBuilder {
	
	private String nome;
	 
	private String uf;
	
	
	public CityBuilder() {
		
	}
	
	public CityBuilder paraCidadeDe(String nome) {
		this.nome = nome;
		return this;
	}
	
	public CityBuilder doEstado(String uf) {
		this.uf = uf.toUpperCase();
		return this;
	}
	
	public City criarCity() {
		return new City(this.nome, this.uf);
	}

}
