package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class main {
    private JFrame frame;

    public static void main(String[] args) {
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main window = new main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
	public main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 702, 452);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnAgenda = new JButton("Agenda");
        btnAgenda.setBounds(87, 308, 190, 53);
        frame.getContentPane().add(btnAgenda);

        JButton btnCadastrar = new JButton("Gerenciar Usuarios");
        btnCadastrar.setBounds(384, 308, 190, 53);
        frame.getContentPane().add(btnCadastrar);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\andre\\eclipse-workspace\\consultorioPOO\\fullsize_2018_12_03_21_Logo-250040_6769_214650225_188682033.jpg"));
        lblNewLabel.setBounds(87, 11, 487, 230);
        frame.getContentPane().add(lblNewLabel);
        btnAgenda.addActionListener(e -> {
            // Cria e exibe a janela da classe cadastroPaciente
        	Agenda janelaAgenda = new Agenda();
        	janelaAgenda.setVisible(true);
        });
        // Adiciona um ActionListener ao botão "Cadastrar Usuario"
        btnCadastrar.addActionListener(e -> {
            // Cria e exibe a janela da classe cadastroPaciente
        	gerenciarUsuarios janelaGerenciar = new gerenciarUsuarios();
        	janelaGerenciar.setVisible(true);
        });
    }
}
