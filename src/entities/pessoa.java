package entities;

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
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
       
    }   
    


    public void setNome(String nome){
        
        this.nome = nome;
    }



	public void setEmail(String email) {
		this.email = email;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public void setTelefone(String telefone) {
	    
	    this.telefone = telefone;
	}

	public void setCpf(String cpf){
	   
	    this.cpf = cpf;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}







	public void setGenero(String genero) {
		this.genero = genero;
	}



	public void atualizar(String nome, String cidade,String endereco, String telefone) {
		this.setNome(nome);
    	this.setCidade(cidade);
    	this.setEndereco(endereco);
    	this.setTelefone(telefone);
        
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




	public String getGenero() {
		return genero;
	}




	@Override
	public String toString() {
		return  nome;
	}
	
}