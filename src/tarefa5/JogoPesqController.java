package avaliacao1;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JogoPesqController implements ActionListener {

	private SteamPOOHash steam;
	private JFrame janelaPrincipal;
	
	public JogoPesqController(SteamPOOHash steam, JFrame janela) {
		this.steam = steam;
		this.janelaPrincipal = janela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nomePesq = JOptionPane.showInputDialog("Informe o nome do jogo que você deseja pesquisar o preço?");
		try {
			JOptionPane.showMessageDialog(janelaPrincipal,"Preço: " + steam.pesquisaPrecoDoJogo(nomePesq));
		} catch (HeadlessException e1) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Error ao pesquisar preço");
		} catch (JogoInexistenteException e1) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Jogo não encontrado");
		}

	}

}
