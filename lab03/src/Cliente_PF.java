import java.util.Date;

public class Cliente_PF extends Cliente {
    
    private final String CPF;
    private Date dataNascimento;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;

    public Cliente_PF(String nome, Date dataLicenca, String endereco, String educacao, String genero,
    String classeEconomica, String CPF, Date dataNascimento){

        super(nome, endereco);
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
    }

    @Override
    public String toString() {
        return super.toString() + "CPF: " + CPF + "\nData de Nascimento: " + dataNascimento + "\nData da Licenca: "
        + dataLicenca + "\nEducacao: " + educacao + "\nGenero: " + genero + "\n";

    }

    public static boolean validarCPF (String cpf){
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


    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF(){
        return this.CPF;
    }
    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDalaLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

}
