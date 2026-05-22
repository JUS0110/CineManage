package main.java.br.ufrpe.cine_rural.model.beans;

public class Cliente {
    private String nome;
    private String cpf;
    private int idade;
    private String email;

    public Cliente (String nome, String cpf, int idade, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
    }

    public boolean podeAssistir(Filme filme, boolean acompanhante) {

        switch (filme.getClassificacao()) {

            case LIVRE:
                return true;

            case DEZ:
                return idade >= 10;

            case DOZE:
                return idade >= 12;

            case QUATORZE:
                return idade >= 14;

            case DEZESSEIS:
                return idade >= 16;

            case DEZOITO:
                return idade >= 18 || acompanhante;

            default:
                return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
