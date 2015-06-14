package br.com.maplink.calculadorvaloresrotas.impl;

import br.com.maplink.calculadorvaloresrotas.model.endereco.Enderecos;
import br.com.maplink.calculadorvaloresrotas.model.rota.IRota.TipoDeRota;

/**
 * 
 * @author luizleme
 *
 */
public final class CalculadorValoreDeRotas {
	
	private CalculadorValoreDeRotas() {
	}
	
	
	public static ICalculadorValoreDeRotas valueOf(Enderecos enderecos, TipoDeRota tipoDeRota) {
		return new CalculadorValoreDeRotasImplementacaoBasica(enderecos, tipoDeRota);
	}

}
