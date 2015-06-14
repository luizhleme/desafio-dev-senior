package br.com.maplink.calculadorvaloresrotas.model.veiculo;

import br.com.maplink.calculadorvaloresrotas.model.veiculo.IVeiculo.NumeroEixosPorTipoVeiculo;

/**
 * 
 * @author luizleme
 *
 */
public final class Veiculo {

	private Veiculo() {

	}

	public static IVeiculo valueOf(int volumeDoTanque, float mediaDeConsumo,
			double precoDoCombustivel, int velocidadeMedia,
			NumeroEixosPorTipoVeiculo eixos) {
		return new VeiculoImplementacaoBasica(volumeDoTanque, mediaDeConsumo,
				precoDoCombustivel, velocidadeMedia, eixos);
	}
}
