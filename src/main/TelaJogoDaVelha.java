package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogoDaVelha {

	private char [][]tabuleiro = new char[3][3];
	private char jogadorAtual = 'X';
	
	private JFrame janela;
	private JButton[][] btn = new JButton[3][3];
	private JLabel mensagemStatus;
	
	public TelaJogoDaVelha() {
		//Configurando a janela (JFrame)
		janela = new JFrame("Jogo da velha");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setLayout(new BorderLayout());
		
		//Adicionando os botões ao painel
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; J++) {
				btn[i][j] = new Jbutton("");
				btn[i][j].setFont(new Font("Arial", Font.BOLD, 50));
			}
		}
	}
	
	
 			

}
