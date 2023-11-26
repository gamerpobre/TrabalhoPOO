package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.List;
import java.awt.Choice;

public class Agenda extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Agenda dialog = new Agenda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Agenda() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Agenda");
			lblNewLabel.setBounds(10, 11, 156, 14);
			contentPanel.add(lblNewLabel);
		}
		
		List list = new List();
		list.setBounds(128, 103, 176, 115);
		contentPanel.add(list);
		
		Choice choice = new Choice();
		choice.setBounds(128, 59, 176, 20);
		contentPanel.add(choice);
		
		JButton btnNewButton = new JButton("Agendar");
		btnNewButton.setBounds(335, 194, 89, 23);
		contentPanel.add(btnNewButton);
		
		btnNewButton.addActionListener(e -> {
            // Cria e exibe a janela da classe cadastroPaciente
        	AgendarConsulta AgendarConsulta = new AgendarConsulta();
        	AgendarConsulta.setVisible(true);
        });
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.setActionCommand("OK");
			buttonPane.add(btnVoltar);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
