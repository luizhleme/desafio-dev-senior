package br.com.maplink.calculadorvaloresrotas.model.rota;

import br.com.maplink.calculadorvaloresrotas.model.endereco.IEndereco;
import br.com.maplink.calculadorvaloresrotas.model.rota.IRota.TipoDeRota;
import br.com.maplink.calculadorvaloresrotas.model.veiculo.IVeiculo;

/**
 * 
 * @author luizleme
 *
 */
public final class Rota {

	private Rota() {
	}
	
	public static IRota valueOf(IEndereco enderecoOrigem, IEndereco enderecoDestino, IVeiculo veiculo, TipoDeRota tipoDeRota) {
		return new RotaImplementacaoBasica(enderecoOrigem, enderecoDestino, veiculo, tipoDeRota);
	}
}
