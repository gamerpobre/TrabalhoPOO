package entities;

import Exception.CpfInvalidoException;
import Exception.NomeInvalidoException;
import Exception.TelefoneInvalidoException;

public abstract class pessoa implements Cadastro {
    protected String nome;
    protected String endereco;
    protected String cpf;
    protected String cidade;
    protected String telefone;
    protected String email;
    protected boolean ativo;
    protected String genero;

    // Construtor
    public pessoa(String nome, String cpf, String cidade, String endereco, String telefone, String email, String genero) {
        this.ativo = true;
        this.endereco = endereco;
        this.cidade = cidade;
        this.email = email;
        this.genero = genero;

        try {
            setNome(nome);
            setCpf(cpf);
            setTelefone(telefone);
        } catch (NomeInvalidoException | CpfInvalidoException | TelefoneInvalidoException e) {
            // Lidar com as exceções, se necessário
            System.err.println("Erro ao criar pessoa: " + e.getMessage());
        }
    }   
    



    // Implementação padrão do método excluir
//    @Override
//    public void excluir() {
//        this.ativo = false;
//        System.out.println("Cliente excluído: " + nome);
//    }

    // Implementação padrão do método atualizar

    public void setNome(String nome) throws NomeInvalidoException {
        if (nome == null || nome.isEmpty() || nome.matches(".*\\d+.*")) {
            throw new NomeInvalidoException("Nome inválido: não pode ser nulo, vazio ou conter números.");
        }
        this.nome = nome;
    }



	public void setEmail(String email) {
		this.email = email;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public void setTelefone(String telefone) throws TelefoneInvalidoException {
	    if (telefone == null || telefone.length() < 10 || telefone.length() > 11 || !telefone.matches("\\d+")) {
	        throw new TelefoneInvalidoException("Telefone inválido: deve ter entre 10 e 11 números.");
	    }
	    this.telefone = telefone;
	}

	public void setCpf(String cpf) throws CpfInvalidoException {
	    if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
	        throw new CpfInvalidoException("CPF inválido: deve ter exatamente 11 números.");
	    }
	    this.cpf = cpf;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}







	public void setGenero(String genero) {
		this.genero = genero;
	}



	public void atualizar(String endereco, String telefone, String email) {
    	this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        
    }

   
    
	@Override
	public String toString() {
		return  nome;
	}
	
}