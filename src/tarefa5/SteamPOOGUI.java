package avaliacao1;

import javax.swing.*;
import java.awt.*;

public class SteamPOOGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JLabel linha1, linha2;
    ImageIcon steam = new ImageIcon("img/steam2.png");
    ImageIcon addJogo = new ImageIcon("img/add2.png");
    ImageIcon contJogos = new ImageIcon("img/quantidade.png");
    ImageIcon pesqJogo = new ImageIcon("img/pesq2.png");
    JButton botaoAdicionar, botaoContar, botaoPesquisar;
    
    SteamPOOHash sistema = new SteamPOOHash();

    public SteamPOOGUI(){
        setTitle("Steam: Loja");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(true);
        getContentPane().setBackground(Color.WHITE);
        linha1 = new JLabel("Minha loja de jogos", JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(steam, JLabel.CENTER);
        botaoAdicionar = new JButton("Adicionar", addJogo);
        botaoAdicionar.addActionListener(new JogoAddController(sistema, this));
        botaoContar = new JButton("Contar", contJogos);
        botaoContar.addActionListener(new JogocontController(sistema, this));
        botaoPesquisar = new JButton("Pesquisar", pesqJogo);
        botaoPesquisar.addActionListener(new JogoPesqController(sistema, this));
        getContentPane().setLayout(new GridLayout(3,2));
        getContentPane().add(linha1);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(linha2);
        getContentPane().add(botaoContar);
        getContentPane().add(new JLabel());
        getContentPane().add(botaoPesquisar);
    }

    public static void main(String[] args) {
        JFrame janela = new SteamPOOGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
