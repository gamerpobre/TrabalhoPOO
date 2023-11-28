package gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import entities.medico;
import entities.paciente;

public class gerenciarUsuarios extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<medico> medicoListModel = new DefaultListModel<>();
    private DefaultListModel<paciente> pacienteListModel = new DefaultListModel<>();

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
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btncadastrarpaciente = new JButton("Cadastrar");
        btncadastrarpaciente.setBounds(10, 69, 179, 23);
        contentPane.add(btncadastrarpaciente);

        JButton btncadastrarmedico = new JButton("Cadastrar");
        btncadastrarmedico.setBounds(243, 69, 165, 23);
        contentPane.add(btncadastrarmedico);

        JLabel lblNewLabel = new JLabel("Pacientes");
        lblNewLabel.setBounds(28, 43, 172, 14);
        contentPane.add(lblNewLabel);

        JLabel lblMedicos = new JLabel("Medicos");
        lblMedicos.setBounds(288, 44, 136, 14);
        contentPane.add(lblMedicos);

        // Adiciona JScrollPane para list_medicos
        JScrollPane scrollPaneMedicos = new JScrollPane();
        scrollPaneMedicos.setBounds(224, 114, 200, 136);
        contentPane.add(scrollPaneMedicos);

        JList<medico> list_medicos = new JList<>(medicoListModel);
        scrollPaneMedicos.setViewportView(list_medicos);

        // Adiciona JScrollPane para list_pacientes
        JScrollPane scrollPanePacientes = new JScrollPane();
        scrollPanePacientes.setBounds(0, 114, 200, 136);
        contentPane.add(scrollPanePacientes);

        JList<paciente> list_pacientes = new JList<>(pacienteListModel);
        scrollPanePacientes.setViewportView(list_pacientes);
        
        JButton btnNewButton = new JButton("Voltar");
        btnNewButton.setBounds(335, 11, 89, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(e -> {
        	setVisible(false);
        	Principal.main(null);
        });
        btncadastrarpaciente.addActionListener(e -> {
        	
        	
        	cadastroPaciente janelaPaciente = new cadastroPaciente();
        	janelaPaciente.setVisible(true);
            atualizarListas();
        });

        btncadastrarmedico.addActionListener(e -> {
        	CadastroMedico janelaMedico = new CadastroMedico();
        	janelaMedico.setVisible(true);
            atualizarListas();
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
}
