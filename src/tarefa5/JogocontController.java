package avaliacao1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JogocontController implements ActionListener {

	private SteamPOOHash steam;
	private JFrame janelaPrincipal;
	
	public JogocontController(SteamPOOHash steam, JFrame janela) {
		this.steam = steam;
		this.janelaPrincipal = janela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String catJogo = JOptionPane.showInputDialog(janelaPrincipal, "Qual a categoria do jogo?");
		JOptionPane.showMessageDialog(janelaPrincipal,"Foram encontrados: " + steam.contaJogosDaCategoria(CategoriaDeJogo.GUERRA) + " jogos com a categoria " + catJogo);
	}

}
