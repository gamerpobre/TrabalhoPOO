package gui;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import entities.medico;
import entities.paciente;

public class gerenciarUsuarios extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static DefaultListModel<medico> medicoListModel = new DefaultListModel<>();
    private static DefaultListModel<paciente> pacienteListModel = new DefaultListModel<>();
    public static paciente PacienteAtl;
    protected static medico MedicoAtl;
	protected static Object list_medicos;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gerenciarUsuarios frame = new gerenciarUsuarios();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public gerenciarUsuarios() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 631, 441);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btncadastrarpaciente = new JButton("Cadastrar");
        btncadastrarpaciente.setBounds(10, 80, 179, 23);
        contentPane.add(btncadastrarpaciente);

        JButton btncadastrarmedico = new JButton("Cadastrar");
        btncadastrarmedico.setBounds(405, 80, 179, 23);
        contentPane.add(btncadastrarmedico);

        JLabel lblNewLabel = new JLabel("Pacientes");
        lblNewLabel.setBounds(72, 55, 172, 14);
        contentPane.add(lblNewLabel);

        JLabel lblMedicos = new JLabel("Medicos");
        lblMedicos.setBounds(469, 55, 136, 14);
        contentPane.add(lblMedicos);

        // Adiciona JScrollPane para list_medicos
        JScrollPane scrollPaneMedicos = new JScrollPane();
        scrollPaneMedicos.setBounds(405, 210, 200, 136);
        contentPane.add(scrollPaneMedicos);
        
                JList<medico> list_medicos = new JList<>(medicoListModel);
                scrollPaneMedicos.setViewportView(list_medicos);

        // Adiciona JScrollPane para list_pacientes
        JScrollPane scrollPanePacientes = new JScrollPane();
        scrollPanePacientes.setBounds(10, 210, 200, 136);
        contentPane.add(scrollPanePacientes);
        
                JList<paciente> list_pacientes = new JList<>(pacienteListModel);
                scrollPanePacientes.setViewportView(list_pacientes);
        
        JButton btnNewButton = new JButton("Voltar");
        btnNewButton.setBounds(516, 368, 89, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(e -> {
            // Cria e exibe a janela da classe cadastroPaciente
        	Principal.main(null);
        	dispose();
        });
        
        JButton btnAtualizarpaciente = new JButton("Atualizar");
        btnAtualizarpaciente.setBounds(10, 114, 179, 23);
        contentPane.add(btnAtualizarpaciente);
        btnAtualizarpaciente.addActionListener(e -> {
            // Cria e exibe a janela da classe cadastroPaciente
        	paciente pacienteSelecionado = list_pacientes.getSelectedValue();
        	 if (pacienteSelecionado != null) {
        		 setPacienteSelecionado(pacienteSelecionado);
                 AtualizarPaciente janelaatlpaciente = new AtualizarPaciente();
                 janelaatlpaciente.setVisible(true);
             	 atualizarListas();
             	 apagarDadosPaciente();
                 copiarDadosParaArquivoPaciente(pacienteListModel);
                 list_pacientes.updateUI();
                
             } else {
                 // Caso nenhum paciente seja selecionado, exibe uma mensagem ou toma outra ação adequada
                 JOptionPane.showMessageDialog(gerenciarUsuarios.this, "Selecione um paciente para remover.");
                 
             }

        });
        
        JButton btnRemoverpaciente = new JButton("Remover");
        btnRemoverpaciente.setBounds(10, 153, 179, 23);
        contentPane.add(btnRemoverpaciente);
        btnRemoverpaciente.addActionListener(e -> {
            // Obtém o paciente selecionado na lista de pacientes
            paciente pacienteSelecionado = list_pacientes.getSelectedValue();

            // Verifica se algum paciente está selecionado
            if (pacienteSelecionado != null) {
                pacienteListModel.removeElement(pacienteSelecionado);
                
                apagarDadosPaciente();
                copiarDadosParaArquivoPaciente(pacienteListModel);
                
               
                list_pacientes.updateUI();
               
            } else {
                // Caso nenhum paciente seja selecionado, exibe uma mensagem ou toma outra ação adequada
                JOptionPane.showMessageDialog(gerenciarUsuarios.this, "Selecione um paciente para remover.");
                
            }
        });
        
        JButton btnAtualizarmedico = new JButton("Atualizar");
        btnAtualizarmedico.setBounds(405, 114, 179, 23);
        contentPane.add(btnAtualizarmedico);
        btnAtualizarmedico.addActionListener(e -> {
            // Cria e exibe a janela da classe cadastroPaciente
        	 medico medicoSelecionado = list_medicos.getSelectedValue();
        	 if (medicoSelecionado != null) {
        		 setMedicoSelecionado(medicoSelecionado);
                 AtualizarMedico janelaatlmedico = new AtualizarMedico();
                 janelaatlmedico.setVisible(true);
             	 atualizarListas();
             	 apagarDadosMedico();
                 copiarDadosParaArquivoMedico(medicoListModel);
                 list_pacientes.updateUI();
                
             } else {
                 // Caso nenhum paciente seja selecionado, exibe uma mensagem ou toma outra ação adequada
                 JOptionPane.showMessageDialog(gerenciarUsuarios.this, "Selecione um paciente para remover.");
                 
             }

        });
        
        JButton btnRemovermedico = new JButton("Remover");
        btnRemovermedico.setBounds(405, 153, 179, 23);
        contentPane.add(btnRemovermedico);
        btnRemovermedico.addActionListener(e -> {
            // Obtém o paciente selecionado na lista de pacientes
            medico medicoSelecionado = list_medicos.getSelectedValue();

            // Verifica se algum paciente está selecionado
            if (medicoSelecionado != null) {
                medicoListModel.removeElement(medicoSelecionado);
                
                apagarDadosMedico();
                copiarDadosParaArquivoMedico(medicoListModel);
                list_medicos.updateUI();
               
            } else {
                // Caso nenhum paciente seja selecionado, exibe uma mensagem ou toma outra ação adequada
                JOptionPane.showMessageDialog(gerenciarUsuarios.this, "Selecione um medico para remover.");
                
            }
        });

        
        btncadastrarpaciente.addActionListener(e -> {        	
        	cadastroPaciente janelaPaciente = new cadastroPaciente();
        	janelaPaciente.setVisible(true);
            dispose();
        });
        

        btncadastrarmedico.addActionListener(e -> {
        	CadastroMedico janelaMedico = new CadastroMedico();
        	janelaMedico.setVisible(true);
        	dispose();
        });
        
        medico.carregarDadosMedico();
        paciente.carregarDadosPaciente();
        atualizarListas();
        
    }

    private void atualizarListas() {
        // Inicializa os modelos
        medicoListModel.clear();
        pacienteListModel.clear();

        // Adiciona elementos de médico ao modelo
        for (medico m : medico.listaMedicos) {
            medicoListModel.addElement(m);
        }

        // Adiciona elementos de paciente ao modelo
        for (paciente p : paciente.listaPacientes) {
            pacienteListModel.addElement(p);
        }
    }
    
    public static void copiarDadosParaArquivoMedico(DefaultListModel<medico> medicoListModel) {
        // Apaga todos os dados existentes no arquivo
        apagarDadosMedico();

        // Copia os dados da lista para o arquivo
        for (int i = 0; i < medicoListModel.size(); i++) {
            medico medico = medicoListModel.getElementAt(i);//(nome + ";" + cpf + ";"+ cidade + ";" + endereco + ";" + telefone + ";" + email + ";" + CRM + ";" + genero )
           salvarDadosMedico(
                medico.getNome(),
                medico.getCpf(),
                medico.getCidade(),
                medico.getEndereco(),
                medico.getTelefone(),
                medico.getEmail(),
                medico.getCRM(),
                medico.getGenero()
            );
        }
    }
    public static void atualizarlistamedico(medico medico) {
        // Encontrar o índice do paciente na lista
        int index = medicoListModel.indexOf(medico);

        // Verificar se o paciente está na lista antes de tentar removê-lo
        if (index != -1) {
            medicoListModel.remove(index); // Remove o paciente da lista
            medicoListModel.addElement(medico); // Adiciona o paciente de volta à lista (atualizado)
            apagarDadosMedico();
            copiarDadosParaArquivoMedico(medicoListModel);
        
        }
    }
    public static void atualizarlistapaciente(paciente paciente) {
        // Encontrar o índice do paciente na lista
        int index = pacienteListModel.indexOf(paciente);

        // Verificar se o paciente está na lista antes de tentar removê-lo
        if (index != -1) {
            pacienteListModel.remove(index); // Remove o paciente da lista
            pacienteListModel.addElement(paciente); // Adiciona o paciente de volta à lista (atualizado)
            apagarDadosPaciente();
            copiarDadosParaArquivoPaciente(pacienteListModel);
        
        }
    }
    public static void copiarDadosParaArquivoPaciente(DefaultListModel<paciente> pacienteListModel) {
        // Apaga todos os dados existentes no arquivo
        apagarDadosPaciente();

        // Copia os dados da lista para o arquivo
        for (int i = 0; i < pacienteListModel.size(); i++) {
            paciente paciente = pacienteListModel.getElementAt(i);
           salvarDadosPaciente(
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getCidade(),
                paciente.getEndereco(),
                paciente.getTelefone(),
                paciente.getEmail(),
                paciente.getConvenio(),
                paciente.getGenero()
            );
        }
    }
    public static void apagarDadosMedico() {
    	try (PrintWriter writer = new PrintWriter("dados_medico.txt")) {
    		// Cria um arquivo vazio, apagando assim todos os dados anteriores
    	} catch (IOException e) {
    		System.err.println("Erro ao apagar dados do medico: " + e.getMessage());
    	}
    }
    public static void apagarDadosPaciente() {
    	try (PrintWriter writer = new PrintWriter("dados_paciente.txt")) {
    		// Cria um arquivo vazio, apagando assim todos os dados anteriores
    	} catch (IOException e) {
    		System.err.println("Erro ao apagar dados do paciente: " + e.getMessage());
    	}
    }
    public static void salvarDadosMedico(String nome, String cpf, String cidade, String endereco, String telefone, String email, String CRM, String genero) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_medico.txt", true))) {
            writer.write(nome + ";" + cpf + ";"+ cidade + ";" + endereco + ";" + telefone + ";" + email + ";" + CRM + ";" + genero );
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados do medico: " + e.getMessage());
        }
    }   
    public static void salvarDadosPaciente(String nome, String cpf, String cidade, String endereco, String telefone, String email, String convenio, String genero) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados_paciente.txt", true))) {
            writer.write(nome + ";" + cpf + ";"+ cidade + ";" + endereco + ";" + telefone + ";" + email + ";" + convenio + ";" + genero );
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados do paciente: " + e.getMessage());
        }
    }
    private void setPacienteSelecionado(paciente paciente) {
        PacienteAtl = paciente;
    }

    public paciente getPacienteSelecionado() {
        return PacienteAtl;
    }
    private void setMedicoSelecionado(medico medico) {
        MedicoAtl = medico;
    }

    public medico getMedicoSelecionado() {
        return MedicoAtl;
    }

}
