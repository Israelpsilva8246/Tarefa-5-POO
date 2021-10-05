package avaliacao1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JogoAddController implements ActionListener {

	private SteamPOOHash steam;
	private JFrame janelaPrincipal;
	
	public JogoAddController(SteamPOOHash steam, JFrame janela) {
		this.steam = steam;
		this.janelaPrincipal = janela;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual nome do jogo?");
		double preco = Double.parseDouble(JOptionPane.showInputDialog("Qual o ppreço do jogo?"));
		Jogo jogo = new Jogo(nome, preco, new LinkedList<CategoriaDeJogo>());
		configurarCategorias(jogo);
		
		try {
			steam.cadastraJogo(jogo);
			JOptionPane.showMessageDialog(janelaPrincipal, "Jogo cadastrado com sucesso");
		} catch (JogoJaExisteException e1) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Jogo não foi cadastrado");
		}

	}
	
	private static void configurarCategorias(Jogo jogo) {
		List<CategoriaDeJogo> categorias = new LinkedList<>();
		boolean continuar = true;
		while (continuar) {
			String opcao = JOptionPane.showInputDialog("Qual categoria você deseja adicionar?\n1."
					+ CategoriaDeJogo.ARCADE + "\n2." + CategoriaDeJogo.AVENTURA + "\n3." + CategoriaDeJogo.GUERRA
					+ "\n4." + CategoriaDeJogo.TERROR + "\n5.Não adicionar mais categorias");
			switch (opcao) {
			case "1": // assumindo que usuário não erra
				categorias.add(CategoriaDeJogo.ARCADE);
				break;
			case "2":
				categorias.add(CategoriaDeJogo.AVENTURA);
				break;
			case "3":
				categorias.add(CategoriaDeJogo.GUERRA);
				break;
			case "4":
				categorias.add(CategoriaDeJogo.TERROR);
				break;
			case "5":
				continuar = false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}

		}
		jogo.setCategorias(categorias);
	}

}
