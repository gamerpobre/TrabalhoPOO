package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.Label;

public class AgendarConsulta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgendarConsulta dialog = new AgendarConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgendarConsulta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			Choice choice = new Choice();
			choice.setBounds(144, 57, 132, 20);
			contentPanel.add(choice);
		}
		
		Choice choice = new Choice();
		choice.setBounds(144, 123, 132, 20);
		contentPanel.add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(144, 182, 132, 20);
		contentPanel.add(choice_1);
		
		Label label = new Label("Horario");
		label.setBounds(191, 154, 62, 22);
		contentPanel.add(label);
		
		Label label_1 = new Label("Paciente");
		label_1.setBounds(191, 95, 62, 22);
		contentPanel.add(label_1);
		
		Label label_2 = new Label("Medico");
		label_2.setBounds(191, 29, 62, 22);
		contentPanel.add(label_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agendar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Voltar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
