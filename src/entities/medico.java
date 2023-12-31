package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class medico extends pessoa {
    protected String CRM;
    public static List<medico> listaMedicos = new ArrayList<>();
    // Construtor
    public medico(String nome, String cpf, String cidade, String endereco, String telefone, String email, String CRM, String genero) {
		super(nome, cpf, endereco, cidade, telefone, email, genero);
        this.CRM = CRM;
    	if (cpfJaExiste(cpf)) {
            
             
          }
    	else {
    	
        // Adiciona o paciente à lista de medicos
        listaMedicos.add(this);

    	}
        
    }
    public static ArrayList<medico> carregarDadosMedico() {
        ArrayList<medico> medicos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("dados_medico.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split da linha usando o ponto e vírgula como delimitador
                String[] dados = line.split(";");

                // Criar um novo médico com os dados lidos do arquivo
                medico medico = new medico(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]);
                medico.adicionarMedicoNaLista(medico);
                medicos.add(medico);
            }
            // Atribuir a lista de médicos à lista estática
            listaMedicos = medicos;
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados do médico: " + e.getMessage());
        }

        return medicos;
    }


    public void adicionarMedicoNaLista(medico medico) {
    	listaMedicos.add(medico);
    }

    
    public boolean cpfJaExiste(String cpf) {
        for (medico medico : listaMedicos) {
            if (medico.getCpf().equals(cpf)) {
                
            
            	return true; // CPF já existe
            }
        }
      
        return false; // CPF não existe
    }
    
    
    
    public void atualizar(String nome, String cidade,String endereco, String telefone) {
		this.setNome(nome);
    	this.setCidade(cidade);
    	this.setEndereco(endereco);
    	this.setTelefone(telefone);
    	
    }
    public boolean isAtivo() {
        return super.ativo;
    }
    

    // Método para carregar dados de um arquivo
  
    
    
    @Override
    public String toString() {
        return super.toString();
    }
    public String getNome() {
		return nome;
	}




	public String getEndereco() {
		return endereco;
	}




	public String getCpf() {
		return cpf;
	}




	public String getCidade() {
		return cidade;
	}




	public String getTelefone() {
		return telefone;
	}




	public String getEmail() {
		return email;
	}


	public String getCRM() {
		return CRM;
	}

	public String getGenero() {
		return genero;
	}
	@Override
	public void atualizar(String endereco, String telefone, String email) {
		
	}
 
}

