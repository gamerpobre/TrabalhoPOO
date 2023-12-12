package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entities.paciente;


public class AtualizarPaciente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txttelefone;
	private JTextField txtCidadepaciente;
	private JTextField txtEnderecopaciente;
	private JTextField txtNomepaciente;
	private paciente atualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AtualizarPaciente dialog = new AtualizarPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtualizarPaciente() {
		atualizar = gerenciarUsuarios.PacienteAtl;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txttelefone = new JTextField();
			txttelefone.setText(atualizar.getTelefone());
			txttelefone.setBounds(152, 112, 161, 20);
			contentPanel.add(txttelefone);
			txttelefone.setColumns(10);
		}
		
		System.out.println(atualizar.getCidade());
		
		txtCidadepaciente = new JTextField();
		txtCidadepaciente.setText(atualizar.getCidade());
		txtCidadepaciente.setColumns(10);
		txtCidadepaciente.setBounds(152, 154, 161, 20);
		contentPanel.add(txtCidadepaciente);
		
		txtEnderecopaciente = new JTextField();
		txtEnderecopaciente.setText(atualizar.getEndereco());
		txtEnderecopaciente.setColumns(10);
		txtEnderecopaciente.setBounds(152, 197, 161, 20);
		contentPanel.add(txtEnderecopaciente);
		
		JLabel lblNewLabel = new JLabel("Telefone");
		lblNewLabel.setBounds(198, 97, 161, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblConvevio = new JLabel("Endereço");
		lblConvevio.setBounds(198, 137, 161, 14);
		contentPanel.add(lblConvevio);
		
		JLabel lblEndereo = new JLabel("Cidade");
		lblEndereo.setBounds(198, 182, 161, 14);
		contentPanel.add(lblEndereo);
		
		txtNomepaciente = new JTextField();
		txtNomepaciente.setText(atualizar.getNome());
		txtNomepaciente.setColumns(10);
		txtNomepaciente.setBounds(152, 71, 161, 20);
		contentPanel.add(txtNomepaciente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(198, 56, 161, 14);
		contentPanel.add(lblNome);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBounds(224, 228, 89, 23);
		contentPanel.add(btnNewButton);
		btnNewButton.setActionCommand("OK");

		// Adicionando um ActionListener ao botão
		btnNewButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Chamando o método atualizarPaciente() quando o botão é clicado
		    	atualizarPaciente();
		        dispose();
		    }
		 });
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 228, 89, 23);
		contentPanel.add(btnCancelar);
		btnCancelar.setActionCommand("OK");
		btnNewButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Chamando o método atualizarPaciente() quando o botão é clicado
		    	
		        dispose();
		    }
		 });
		
	}
	
	private void atualizarPaciente() {
	  	
        String nome = txtNomepaciente.getText();
        String cidade = txtCidadepaciente.getText();
        String endereco = txtEnderecopaciente.getText();
        String telefone = txttelefone.getText();
        atualizar.atualizar(nome, cidade, endereco, telefone);
        gerenciarUsuarios.atualizarlistapaciente(atualizar);
        
        
  }
	
	
}
