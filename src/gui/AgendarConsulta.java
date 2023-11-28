package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import entities.Agenda;
import entities.medico;
import entities.paciente;
import java.awt.Choice;
import javax.swing.JLabel;

public class AgendarConsulta extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private DefaultListModel<medico> medicoListModel = new DefaultListModel<>();
    private DefaultListModel<paciente> pacienteListModel = new DefaultListModel<>();

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

        Label label_1 = new Label("Paciente");
        label_1.setBounds(341, 30, 62, 22);
        contentPanel.add(label_1);

        Label label_2 = new Label("Medico");
        label_2.setBounds(26, 30, 62, 22);
        contentPanel.add(label_2);

        // Adiciona JScrollPane para list_medicos
        JScrollPane scrollPaneMedicos = new JScrollPane();
        scrollPaneMedicos.setBounds(319, 58, 94, 140);
        contentPanel.add(scrollPaneMedicos);

        JList<medico> list_medicos = new JList<>(medicoListModel);
        scrollPaneMedicos.setViewportView(list_medicos);

        // Adiciona JScrollPane para list_pacientes
        JScrollPane scrollPanePacientes = new JScrollPane();
        scrollPanePacientes.setBounds(10, 58, 94, 140);
        contentPanel.add(scrollPanePacientes);

        JList<paciente> list_pacientes = new JList<>(pacienteListModel);
        scrollPanePacientes.setViewportView(list_pacientes);
        
        Choice choice = new Choice();
        choice.setBounds(153, 58, 94, 20);
        choice.add("");
        choice.add("9:00");  // Adiciona a opção "unimed" à Choice de convênios
        choice.add("10:00");  // Adiciona 
        choice.add("11:00");
        choice.add("14:00");
        choice.add("15:00");
        choice.add("16:00");
        choice.add("17:00");
        contentPanel.add(choice);
        
        JLabel lblNewLabel = new JLabel("Horarios");
        lblNewLabel.setBounds(180, 38, 67, 14);
        contentPanel.add(lblNewLabel);
        medico.carregarDadosMedico();
        paciente.carregarDadosPaciente();
        atualizarListas();

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton agendarButton = new JButton("Agendar");
            agendarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obter os itens selecionados de cada lista
                    medico medicoSelecionado = list_medicos.getSelectedValue();
                    paciente pacienteSelecionado = list_pacientes.getSelectedValue();
                    String Horario = choice.getSelectedItem();
                    // Fazer algo com os itens selecionados
                    if (medicoSelecionado != null && pacienteSelecionado != null) {
                        // Exibir mensagem com os itens selecionados
                    	Agenda novaagenda = new Agenda(medicoSelecionado,pacienteSelecionado,Horario);
                    	novaagenda.setMedicoSelecionado(medicoSelecionado);
                    	novaagenda.setPacienteSelecionado(pacienteSelecionado);
                    	novaagenda.setHorario(Horario);
                    } else {
                        // Exibir mensagem de aviso se não houver seleção em ambas as listas
                        System.out.println("Selecione um médico e um paciente.");
                    }
                }
            });
            buttonPane.add(agendarButton);
            getRootPane().setDefaultButton(agendarButton);

            JButton voltarButton = new JButton("Voltar");
            voltarButton.addActionListener(e -> {
                // Cria e exibe a janela da classe cadastroPaciente
            	GerenciarAgendas janelaAgenda = new GerenciarAgendas();
            	janelaAgenda.setVisible(true);
            });
            buttonPane.add(voltarButton);
        }
    }

    private void atualizarListas() {
        // Inicializa os modelos
        medicoListModel.clear();
        pacienteListModel.clear();

        // Adiciona elementos de médico ao modelo (substitua 'medico.listaMedicos' pelo nome correto da sua lista de médicos)
        for (medico m : medico.listaMedicos) {
            medicoListModel.addElement(m);
        }

        // Adiciona elementos de paciente ao modelo (substitua 'paciente.listaPacientes' pelo nome correto da sua lista de pacientes)
        for (paciente p : paciente.listaPacientes) {
            pacienteListModel.addElement(p);
        }
    }
}
