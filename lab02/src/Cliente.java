class Cliente{

    private  String nome;
    private  String cpf;
    private  String dataNascimento;
    private  String endereco;
    private  int idade;

    // Construtor
    public Cliente(String nome, String cpf, String nascimento, String endereco, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = nascimento;
        this.endereco = endereco;
        this.idade = idade;
    }

    public String toString(){

        String saida = "Nome:" + this.nome + "\nCPF:" + this.cpf + "\n"
         + "Data de Nascimento:" + this.dataNascimento + "\nEndereco:" + this.endereco + "\nIdade:" + this.idade + "\n";
         return saida;
    }

    public boolean validarCPF (String cpf){
        /* Verifica se o CPF informado é válido */

        // Formatando o CPF
        cpf = cpf.replaceAll("[^\\d]", "");
        int tamanhoCPF = cpf.length();

        // Verificando a quantidade de digitos
        if (tamanhoCPF != 11){
            return false;
        }
        
        // Verificando se todos os digitos são iguais
        int contador_caracteresIguais = 0;
        char num_atual = cpf.charAt(0);
        for (int i = 1; i < tamanhoCPF; i++){

            if (cpf.charAt(i) != num_atual){
                break;
            }

            else {
                contador_caracteresIguais++;
                num_atual = cpf.charAt(i);
            }
        }
        if (contador_caracteresIguais == 10){
            return false;
        }

        // Validando o primeiro digito do CPF
        int soma_digitos = 0;
        for (int i = 0; i < tamanhoCPF - 2; i++){
            
            // Convertendo usando a tabela ASCII
            soma_digitos += (cpf.charAt(i) - '0') * (i + 1);
        }

        int resto_divisao = soma_digitos % 11;
        if (resto_divisao == 10){
            resto_divisao = 0;
        }

        if (resto_divisao != cpf.charAt(9) - '0'){
            return false;
        }

        // Validando o segundo digito do CPF
        soma_digitos = 0;
        for (int i = 0; i < tamanhoCPF - 1; i++){

            // Convertendo usando a tabela ASCII
            soma_digitos += (cpf.charAt(i) - '0') * (i);
            }
        
        resto_divisao = soma_digitos % 11;
        if (resto_divisao == 10){
            resto_divisao = 0;
        }

        if (resto_divisao != cpf.charAt(10) - 48){
            return false;
        }

        return true;
    }

    // Getters e Setters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return this.cpf;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setNome(int idade){
        this.idade = idade;
    }

}