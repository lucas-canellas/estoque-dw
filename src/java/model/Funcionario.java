package model;

public class Funcionario {

    private Integer id;
    private String nome;
    private String cpf;
    private String senha;
    private String papel;

    public Funcionario() {

    }
    
        public Funcionario(String cpf, String senha) {
        
        this.cpf = cpf;
        this.senha = senha;
        
    }
    

    public Funcionario(String nome, String cpf, String senha, String papel) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.papel = papel;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the papel
     */
    public String getPapel() {
        return papel;
    }

    /**
     * @param papel the papel to set
     */
    public void setPapel(String papel) {
        this.papel = papel;
    }
    
    

}
