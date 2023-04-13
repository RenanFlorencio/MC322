import java.util.Date;

public class Cliente_PF extends Cliente {
    
    private final String CPF;
    private Date dataNascimento;

    public Cliente_PF(String nome, Date dataLicenca, String endereco, String educacao, String genero,
    String classeEconomica, String CPF, Date dataNascimento){

        super(nome, dataLicenca, endereco, educacao, genero, classeEconomica);

        // Verificar como fazer isso de maneira melhor
        if (validarCPF(CPF)){
            this.CPF = CPF;
        }
        else{
            this.CPF = null;
        }
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente_PF\nCPF:" + CPF + "\ndataNascimento:" + dataNascimento + "\n";
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

}
