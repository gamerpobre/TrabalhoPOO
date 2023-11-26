package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class paciente extends pessoa {
    protected String convenio;
    public static List<paciente> listaPacientes = new ArrayList<>();

    // Construtor(nome, cpf, cidade, endereco, telefone, email, convenio, genero)
    public paciente(String nome, String cpf, String cidade, String endereco, String telefone, String email, String convenio, String genero) {
    	super(nome, cpf, endereco, cidade, telefone, email, genero);
        this.convenio = convenio; 
        if (cpfJaExiste(cpf)) {
              System.out.println("Usuário já existe.");
             
          }
    	else {
    	
        // Adiciona o paciente à lista de pacientes
        listaPacientes.add(this);
        System.out.println(listaPacientes);
    	}
    }
    
    public void adicionarPacienteNaLista(paciente paciente) {
        listaPacientes.add(paciente);
    }

    
  
	public boolean cpfJaExiste(String cpf) {
        for (paciente paciente : listaPacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return true; // CPF já existe
            }
        }
        return false; // CPF não existe
    }


    public void atualizar(String endereco, String telefone, String email) {
        super.atualizar(endereco, telefone, email);
        System.out.println("Paciente atualizado: " + nome);
    }

    public boolean isAtivo() {
        return super.ativo;
    }

    // Método para salvar dados em um arquivo
   
    public String getCpf() {
    	return cpf;
    	
    }
    public static ArrayList<paciente> carregarDadosPaciente() {
        ArrayList<paciente> pacientes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("dados_paciente.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split da linha usando o ponto e vírgula como delimitador
                String[] dados = line.split(";");

                // Criar um novo médico com os dados lidos do arquivo
                paciente paciente = new paciente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]);
                paciente.adicionarPacienteNaLista(paciente);
                pacientes.add(paciente);
            }
            // Atribuir a lista de médicos à lista estática
            listaPacientes = pacientes;
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados do médico: " + e.getMessage());
        }

        return pacientes;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
   
   
 
}

