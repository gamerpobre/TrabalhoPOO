package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Agenda;

public class GerenciarAgendas extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    
    private DefaultListModel<Agenda> listagerenAgenda = new DefaultListModel<>();

    public static void main(String[] args) {
        try {
        	GerenciarAgendas dialog = new GerenciarAgendas();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public GerenciarAgendas() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Agenda");
        lblNewLabel.setBounds(10, 11, 156, 14);
        contentPanel.add(lblNewLabel);

        JList<Agenda> list = new JList<>(listagerenAgenda);
        list.setBounds(128, 66, 176, 152);
        contentPanel.add(list);

        JButton btnNewButton = new JButton("Agendar");
        btnNewButton.setBounds(335, 194, 89, 23);
        contentPanel.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Consultas");
        lblNewLabel_1.setBounds(183, 46, 96, 14);
        contentPanel.add(lblNewLabel_1);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe a janela da classe AgendarConsulta
                AgendarConsulta agendarConsulta = new AgendarConsulta();
                agendarConsulta.setVisible(true);
            }
        });

        // Adicionar consultas existentes à lista quando a janela for criada
        atualizarListaConsultas();

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para ação do botão "Voltar"
                dispose(); // Fecha a janela atual
            }
        });
        btnVoltar.setActionCommand("OK");
        btnVoltar.setBounds(10, 194, 89, 23);
        contentPanel.add(btnVoltar);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            JButton okButton = new JButton("OK");
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
        }
    }

    private void atualizarListaConsultas() {
        // Limpar a lista para evitar duplicatas
        listagerenAgenda.clear();

        // Adicionar cada consulta à lista GUI usando o método toString
        for (Agenda p : Agenda.getListaAgenda()) {
            listagerenAgenda.addElement(p);
        }

        // Set the model for the List component
  //      list.setModel(listagerenAgenda);
    }

    }

