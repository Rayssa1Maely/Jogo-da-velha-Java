package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaJogoDaVelha {

	private int jogadas = 0;
	private String [][]tabuleiro = new String[3][3];
	private String jogadorAtual = "X";
	
	private JFrame janela;
	private JButton[][] btn = new JButton[3][3];
	private JLabel mensagemStatus;
	
	public TelaJogoDaVelha() {
		//Configurando a janela (JFrame)
		janela = new JFrame("Jogo da velha");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setLayout(new BorderLayout());
		
		JPanel painelTabuleiro=new JPanel();
		painelTabuleiro.setLayout(new GridLayout(3,3));
		

		//Adicionando os botões ao painel
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				btn[i][j] = new JButton("");
				btn[i][j].setFont(new Font("Arial", Font.BOLD, 50));
				
				// Adicina o ouvinte da ação.
				btn[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btnClicado = (JButton) e.getSource();

						 if (btnClicado.getText().equals("")) {
	                            int linhaClicada = -1;
	                            int colunaClicada = -1;

	                            
	                            for (int i = 0; i < 3; i++) {
	                                for (int j = 0; j < 3; j++) {
	                                    if (btn[i][j] == btnClicado) {
	                                        linhaClicada = i;
	                                        colunaClicada = j;
	                                    }
	                                }
	                            }
						
	                        
							btnClicado.setText(jogadorAtual);
							jogada(linhaClicada, colunaClicada, btnClicado.getText());
							btnClicado.setEnabled(false);
							jogadas++;
						
							
							
							if(verificarVencedor()) {
								mensagemStatus.setText("O jogador " + jogadorAtual + " Venceu!!!");
								desabilitarBtn();
							}else if (verificarEmpate()){
								
							}else {
								trocarJogador();
							}
						 }
					}	
				});
				painelTabuleiro.add(btn[i][j]);
			}
		}
		
		//montando a janela
		mensagemStatus = new JLabel("É a vez do X.");
		mensagemStatus.setHorizontalAlignment(SwingConstants.CENTER); //Centraliza o texto 
		janela.add(mensagemStatus, BorderLayout.NORTH);
		janela.add(painelTabuleiro, BorderLayout.CENTER);
		//Tornando tudo visível 
		janela.setVisible(true);
		
	}
	
	private void trocarJogador() {
		if(jogadorAtual == "O") {
			jogadorAtual = "X";
		}else {
			jogadorAtual = "O";
		}
		mensagemStatus.setText("É a vez do " + jogadorAtual + ".");
	}
	
	public boolean verificarEmpate() {
		if(jogadas == 9) {
			mensagemStatus.setText("Empate!!!");
			return true;
		}
		return false;
	}
	
	public void jogada(int linha, int coluna, String jogador){
		
		if(tabuleiro[linha][coluna] == null) {
			tabuleiro[linha][coluna] = jogador;
		}
	}
	
   private void desabilitarBtn() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btn[i][j].setEnabled(false);
            }
        }
    }
	
	public boolean verificarVencedor() {
		
		 for (int i = 0; i < 3; i++) {
	        if (jogadorAtual.equals(tabuleiro[i][0]) && jogadorAtual.equals(tabuleiro[i][1]) && jogadorAtual.equals(tabuleiro[i][2])) {
	            return true;
	        }
		 }
		
		 for (int j = 0; j < 3; j++) {
            if (jogadorAtual.equals(tabuleiro[0][j]) && jogadorAtual.equals(tabuleiro[1][j]) && jogadorAtual.equals(tabuleiro[2][j])) {
                return true;
            }
	     }
		
		 if (jogadorAtual.equals(tabuleiro[0][0]) && jogadorAtual.equals(tabuleiro[1][1]) && jogadorAtual.equals(tabuleiro[2][2])) {
            return true;
	     }
		 
        if (jogadorAtual.equals(tabuleiro[0][2]) && jogadorAtual.equals(tabuleiro[1][1]) && jogadorAtual.equals(tabuleiro[2][0])) {
            return true;
        }
        
	    return false;
	}
	
	//Metodo para iniciar o jogo
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TelaJogoDaVelha();
			}
		});
	}
}
