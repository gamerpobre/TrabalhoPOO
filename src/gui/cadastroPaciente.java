package gui;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.paciente;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JLabel;

public class cadastroPaciente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCidade;
	private JTextField texttelefone;
	private JTextField textCpf;
	private JTextField textendereco;
	private JTextField textemail;
	private Choice choice_convenio;
	private Choice choice_genero;
	
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    cadastroPaciente frame = new cadastroPaciente();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	
	public cadastroPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.setBounds(307, 227, 117, 23);
		contentPane.add(btncadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(208, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		textNome = new JTextField();
		textNome.setBounds(10, 30, 171, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(10, 78, 171, 20);
		contentPane.add(textCidade);
		
		texttelefone = new JTextField();
		texttelefone.setColumns(10);
		texttelefone.setBounds(10, 125, 171, 20);
		contentPane.add(texttelefone);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(253, 30, 171, 20);
		contentPane.add(textCpf);
		
		textendereco = new JTextField();
		textendereco.setColumns(10);
		textendereco.setBounds(253, 78, 171, 20);
		contentPane.add(textendereco);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(253, 125, 171, 20);
		contentPane.add(textemail);
		
		choice_convenio = new Choice();
		choice_convenio.setBounds(10, 177, 171, 20);
		choice_convenio.add("");
        choice_convenio.add("unimed");  // Adiciona a opção "unimed" à Choice de convênios
        choice_convenio.add("cauzzo");  // Adiciona 
        choice_convenio.add("SUS");
        choice_convenio.add("Não possui");
		contentPane.add(choice_convenio);
		
		choice_genero = new Choice();
		choice_genero.setBounds(253, 177, 171, 20);
		choice_genero.add("");
        choice_genero.add("Masculino");  // Adiciona a opção "unimed" à Choice de convênios
        choice_genero.add("Feminino");
        choice_genero.add("Não informar");
		contentPane.add(choice_genero);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 171, 14);
		contentPane.add(lblNome);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 61, 171, 14);
		contentPane.add(lblCidade);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(253, 11, 171, 14);
		contentPane.add(lblCpf);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(253, 61, 171, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 109, 171, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(253, 109, 171, 14);
		contentPane.add(lblEmail);
		
		JLabel lblConvenio = new JLabel("Convenio:");
		lblConvenio.setBounds(10, 157, 171, 14);
		contentPane.add(lblConvenio);
		
		JLabel lblGnero = new JLabel("Gênero:");
		lblGnero.setBounds(253, 156, 171, 14);
		
		contentPane.add(lblGnero);
		   btnCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Hide the current frame (cadastroPaciente)
	                setVisible(false);

	                // Show the main frame
	                main.main(null);
	            }
	        });
	

		btncadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cadastrarPaciente();
            	
            	  setVisible(false);

	                // Show the main frame
	                main.main(null);
            }
	
        });
	}
	
	public static void carregarDadosPaciente() {
    	try (BufferedReader reader = new BufferedReader(new FileReader("dados_paciente.txt"))) {
    	  String line;
    	  while ((line = reader.readLine()) != null) {
    	      // Split da linha usando o ponto e vírgula como delimitador
    	      String[] dados = line.split(";");

    	      // Criar um novo paciente com os dados lidos do arquivo
    	      paciente paciente = new paciente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]  );
    	      paciente.adicionarPacienteNaLista(paciente);
    	      paciente.toString();
    	  }
    	} catch (IOException e) {
    	  System.err.println("Erro ao carregar dados do paciente: " + e.getMessage());
    	}
    	}
	public void salvarDados(String nome, String cpf, String cidade, String endereco, String telefone, String email, String convenio, String genero) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_paciente.txt", true))) {
            writer.write(nome + ";" + cpf + ";"+ cidade + ";" + endereco + ";" + telefone + ";" + email + ";" + convenio + ";" + genero );
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados do paciente: " + e.getMessage());
        }
    }   

	  private void cadastrarPaciente() {
	        String nome = textNome.getText();
	        String cpf = textCpf.getText();
	        String cidade = textCidade.getText();
	        String endereco = textendereco.getText();
	        String telefone = texttelefone.getText();
	        String email = textemail.getText();
	        String convenio = choice_convenio.getSelectedItem(); // obtém o item selecionado na Choice de convênios
	        String genero = choice_genero.getSelectedItem(); // obtém o item selecionado na Choice de gêneros
	        carregarDadosPaciente();
	        paciente novaPessoa = new paciente(nome, cpf, cidade, endereco, telefone, email, convenio, genero);
	        salvarDados(nome, cpf, cidade, endereco, telefone, email, convenio, genero);	    }
	
}