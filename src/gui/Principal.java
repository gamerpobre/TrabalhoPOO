package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.setBounds(44, 252, 168, 66);
		contentPane.add(btnAgenda);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(367, 252, 168, 66);
		contentPane.add(btnUsuarios);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\andre\\eclipse-workspace\\consultorioPOO\\fullsize_2018_12_03_21_Logo-250040_6769_214650225_188682033.jpg"));
		lblNewLabel.setBounds(48, 11, 487, 230);
		contentPane.add(lblNewLabel);
		btnAgenda.addActionListener(e -> {
            // Cria e exibe a janela da classe cadastroPaciente
        	GerenciarAgendas janelaAgenda = new GerenciarAgendas();
        	janelaAgenda.setVisible(true);
        });
        // Adiciona um ActionListener ao botão "Cadastrar Usuario"
        btnUsuarios.addActionListener(e -> {
            // Cria e exibe a janela da classe cadastroPaciente
        	gerenciarUsuarios janelaGerenciar = new gerenciarUsuarios();
        	janelaGerenciar.setVisible(true);
        });
	}
}
