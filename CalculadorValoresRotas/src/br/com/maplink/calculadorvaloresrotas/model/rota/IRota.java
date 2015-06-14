package br.com.maplink.calculadorvaloresrotas.model.rota;

import br.com.maplink2.webservices.RouteDetails;
import br.com.maplink2.webservices.RouteStop;
import br.com.maplink2.webservices.Vehicle;

/**
 * 
 * @author luizleme
 *
 */
public interface IRota {
	
	public enum TipoDeRota {

		ROTA_PADRAO_MAIS_RAPIDA(0),
		ROTA_PADRAO_MAIS_CURTA(1),
		ROTA_EVITANDO_TRANSITO(23);
		
		private  final int valor;
		
		TipoDeRota(int valorOpcao) {
			valor = valorOpcao;
		}
		
		public int getValor() {
			return valor;
		}
	}
	
	RouteStop pontoDeOrigemDaRota();
	
	RouteStop pontoDeDestinoDaRota();
	
	RouteDetails detalhesDaRota();
	
	TipoDeRota tipoDeRota();
	
	Vehicle vehicle();

}
