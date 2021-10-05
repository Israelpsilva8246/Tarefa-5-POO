package avaliacao1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SteamPOOHashTest {

	@Test
	void testCadastraJogo() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		jogo.adicionaCategoria(CategoriaDeJogo.ARCADE);
		try {
			sistema.cadastraJogo(jogo);
			int contArcade = sistema.contaJogosDaCategoria(CategoriaDeJogo.ARCADE);
			assertTrue(contArcade == 1);
			double jogoPreco = sistema.pesquisaPrecoDoJogo("Zelda");
			sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.ARCADE);
			assertTrue(jogoPreco == 0);
		} catch (JogoJaExisteException e) {
			fail("N�o deveria ter lan�ado exce��o");
		} catch (JogoInexistenteException e) {
			fail("N�o deveria ter lan�ado exce��o");
		}
		assertTrue(sistema.existeJogoComNome("Zelda"));
	}

	@Test
	void testAdicionaCategoriaEmJogo() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		try {
			sistema.cadastraJogo(jogo);
			sistema.adicionaCategoriaEmJogo("Zelda", CategoriaDeJogo.AVENTURA);
			int contArcade = sistema.contaJogosDaCategoria(CategoriaDeJogo.ARCADE);
			assertTrue(contArcade == 0);
		} catch (JogoInexistenteException e) {
			fail("Deveria lan�ar exce��o");
		} catch (JogoJaExisteException e) {
			fail("N�o deveria ter lan�ado exce��o");
		}
	}

	@Test
	void testPesquisaJogosDaCategoria() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		jogo.adicionaCategoria(CategoriaDeJogo.ARCADE);
		try {
			sistema.cadastraJogo(jogo);
			List<Jogo> jogoArcade = sistema.pesquisaJogosDaCategoria(CategoriaDeJogo.ARCADE);
			assertTrue(jogoArcade.size()==1);
			assertTrue(jogoArcade.get(0).getNome().equals("Zelda"));
		} catch (JogoJaExisteException e) {
			fail("N�o deveria ter lan�ado excer��o");
		}
	}

	@Test
	void testPesquisaPrecoDoJogo() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		try {
			sistema.cadastraJogo(jogo);
			double jogoPreco = sistema.pesquisaPrecoDoJogo("Zelda");
			assertTrue(jogoPreco==0.0);
		} catch (JogoJaExisteException e) {
			fail("Deveria lan�ar exce��o");
		} catch (JogoInexistenteException e) {
			fail("Deveria lan�ar exce��o");
		}
	}

	@Test
	void testExisteJogoComNome() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		try {
			sistema.cadastraJogo(jogo);
			assertTrue(sistema.existeJogoComNome("Zelda"));
		} catch (JogoJaExisteException e) {
			fail("N�o deveria lan�ar excer��o");
		}
	}

	@Test
	void testContaJogosDaCategoria() {
		SteamPOOHash sistema = new SteamPOOHash();
		Jogo jogo = new Jogo("Zelda");
		jogo.adicionaCategoria(CategoriaDeJogo.ARCADE);
		try {
			sistema.cadastraJogo(jogo);
			int contArcade = sistema.contaJogosDaCategoria(CategoriaDeJogo.ARCADE);
			assertTrue(contArcade==1);
		} catch (JogoJaExisteException e) {
			fail("N�o deveria lan�ar excer��o");
		} 
	}
}
