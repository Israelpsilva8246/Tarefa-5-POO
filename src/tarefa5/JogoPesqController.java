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
		String nomePesq = JOptionPane.showInputDialog("Informe o nome do jogo que voc� deseja pesquisar o pre�o?");
		try {
			JOptionPane.showMessageDialog(janelaPrincipal,"Pre�o: " + steam.pesquisaPrecoDoJogo(nomePesq));
		} catch (HeadlessException e1) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Error ao pesquisar pre�o");
		} catch (JogoInexistenteException e1) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Jogo n�o encontrado");
		}

	}

}
