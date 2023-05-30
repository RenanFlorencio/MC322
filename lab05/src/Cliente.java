
abstract class Cliente{ // Não é permitido criar um cliente que não seja PF ou PJ

    private String nome;
    private String identificacao; //CPF ou CNPJ para que seja mais simples a busca na lista de clientes
    private String endereco;
    private boolean atualizado;

    // Construtor
    public Cliente(String nome, String endereco, String identificacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.identificacao = identificacao;
        this.atualizado = false;
    }

    public String toString() {
        
        String str = "\nNome: " + nome + "\nEndereco: " + endereco + "\n";
        return str;
    }

    public String listarVeiculos(){
        // Só será usado em override
        return null;
    }

    // Getters e Setters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public boolean getAtualizado(){
        return this.atualizado;
    }

    public void setAtualizado(boolean status){
        atualizado = status;
    }

}