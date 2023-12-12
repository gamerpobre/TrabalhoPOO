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

import entities.medico;


public class AtualizarMedico extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txttelefone;
	private JTextField txtCidademedico;
	private JTextField txtEnderecomedico;
	private JTextField txtNomemedico;
	private medico atualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AtualizarMedico dialog = new AtualizarMedico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AtualizarMedico() {
		atualizar = gerenciarUsuarios.MedicoAtl;
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
		
		txtCidademedico = new JTextField();
		txtCidademedico.setText(atualizar.getCidade());
		txtCidademedico.setColumns(10);
		txtCidademedico.setBounds(152, 154, 161, 20);
		contentPanel.add(txtCidademedico);
		
		txtEnderecomedico = new JTextField();
		txtEnderecomedico.setText(atualizar.getEndereco());
		txtEnderecomedico.setColumns(10);
		txtEnderecomedico.setBounds(152, 197, 161, 20);
		contentPanel.add(txtEnderecomedico);
		
		JLabel lblNewLabel = new JLabel("Telefone");
		lblNewLabel.setBounds(198, 97, 161, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblConvevio = new JLabel("Endereço");
		lblConvevio.setBounds(198, 137, 161, 14);
		contentPanel.add(lblConvevio);
		
		JLabel lblEndereo = new JLabel("Cidade");
		lblEndereo.setBounds(198, 182, 161, 14);
		contentPanel.add(lblEndereo);
		
		txtNomemedico = new JTextField();
		txtNomemedico.setText(atualizar.getNome());
		txtNomemedico.setColumns(10);
		txtNomemedico.setBounds(152, 71, 161, 20);
		contentPanel.add(txtNomemedico);
		
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
		        atualizarmedico();
		        
		        dispose();
		    }
		});
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 228, 89, 23);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		        dispose();
		    }
		});
	}
	
	private void atualizarmedico() {
	  	
        String nome = txtNomemedico.getText();
        String cidade = txtCidademedico.getText();
        String endereco = txtEnderecomedico.getText();
        String telefone = txttelefone.getText();
        atualizar.atualizar(nome, cidade, endereco, telefone);
        gerenciarUsuarios.atualizarlistamedico(atualizar);
        
        
  }
	
	
}
