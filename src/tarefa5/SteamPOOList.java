package avaliacao1;

import java.util.LinkedList;
import java.util.List;

public class SteamPOOList implements SteamPOO {
	
	private List<Jogo> jogos;
	
	public SteamPOOList() {
		this.jogos = new LinkedList<>();
	}

	@Override
	public void adicionaCategoriaEmJogo(String nomeJogo, CategoriaDeJogo categoria) throws JogoInexistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeJogoComNome(String nomeJogo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int contaJogosDaCategoria(CategoriaDeJogo categoria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cadastraJogo(Jogo jogo) throws JogoJaExisteException {
		if(this.jogos.contains(jogo)) {
			throw new JogoJaExisteException("Já existe o jogo " + jogo.getNome());
		}else {
			this.jogos.add(jogo);
		}
	}

	@Override
	public List<Jogo> pesquisaJogosDaCategoria(CategoriaDeJogo categoria) {
		List<Jogo> jogosDaCategoria = new LinkedList<>();
		for(Jogo j : this.jogos){
			if(j.ehDaCategoria(categoria)) {
				jogosDaCategoria.add(j);
			}
		}
		return jogosDaCategoria;
	}

	@Override
	public double pesquisaPrecoDoJogo(String nome) throws JogoInexistenteException {
		for(Jogo j : this.jogos) {
			if(j.getNome().equals(nome)) {
				return j.getPreco();
			}
		}
		throw new JogoInexistenteException("Não existe jogo com o nome " + nome);
	}
}
