package br.com.maplink.calculadorvaloresrotas.model.endereco;

/**
 * 
 * @author luizleme
 *
 */
public class Enderecos {

	private IEndereco enderecoDeOrigem;
	private IEndereco enderecoDeDestino;
	
	public Enderecos(IEndereco enderecoDeOrigem, IEndereco enderecoDeDestino) {
		super();
		this.enderecoDeOrigem = enderecoDeOrigem;
		this.enderecoDeDestino = enderecoDeDestino;
	}

	public IEndereco getEnderecoDeOrigem() {
		return enderecoDeOrigem;
	}

	public IEndereco getEnderecoDeDestino() {
		return enderecoDeDestino;
	}
}
