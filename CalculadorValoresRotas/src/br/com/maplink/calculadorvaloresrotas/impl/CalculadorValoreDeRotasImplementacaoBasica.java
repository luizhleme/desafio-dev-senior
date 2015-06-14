package br.com.maplink.calculadorvaloresrotas.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.maplink.calculadorvaloresrotas.model.endereco.Enderecos;
import br.com.maplink.calculadorvaloresrotas.model.rota.IRota;
import br.com.maplink.calculadorvaloresrotas.model.rota.Rota;
import br.com.maplink.calculadorvaloresrotas.model.rota.IRota.TipoDeRota;
import br.com.maplink.calculadorvaloresrotas.model.totais.IValoresTotaisRota;
import br.com.maplink.calculadorvaloresrotas.model.totais.ValoresTotaisRota;
import br.com.maplink.calculadorvaloresrotas.model.veiculo.IVeiculo;
import br.com.maplink.calculadorvaloresrotas.model.veiculo.IVeiculo.NumeroEixosPorTipoVeiculo;
import br.com.maplink.calculadorvaloresrotas.model.veiculo.Veiculo;
import br.com.maplink.calculadorvaloresrotas.roteirizacao.MapLinkRota;
import br.com.maplink.calculadorvaloresrotas.roteirizacao.Roteirizacao;
import br.com.maplink2.webservices.RouteTotals;

/**
 * 
 * @author luizleme
 *
 */
class CalculadorValoreDeRotasImplementacaoBasica implements
		ICalculadorValoreDeRotas {

	private RouteTotals totaisDaRota;
	private Enderecos enderecos;
	private TipoDeRota tipoDeRota;

	public CalculadorValoreDeRotasImplementacaoBasica(Enderecos enderecos,
			TipoDeRota tipoDeRota) {
		this.enderecos = enderecos;
		this.tipoDeRota = tipoDeRota;
	}

	@Override
	public IValoresTotaisRota calcular() throws RemoteException,
			ServiceException {
		IValoresTotaisRota valoresTotais = null;
		IRota rota = null;
		try {
			IVeiculo veiculo = Veiculo.valueOf(20, 9, 2.50, 60,
					NumeroEixosPorTipoVeiculo.AUTOMOVEL_CAMINHONETA_FURGAO);

			rota = Rota.valueOf(enderecos.getEnderecoDeOrigem(),
					enderecos.getEnderecoDeDestino(), veiculo, tipoDeRota);
			Roteirizacao roteirizacao = new MapLinkRota(rota);
			totaisDaRota = roteirizacao.calcularValoresTotaisDaRota();
			
		} catch (RemoteException e) {
			throw new RemoteException(e.getLocalizedMessage(), e.getCause());
		} catch (ServiceException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		valoresTotais = ValoresTotaisRota.valueOf(totaisDaRota);
		return valoresTotais;
	}
}
