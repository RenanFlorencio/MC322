import java.util.Date;

public class Cliente_PJ extends Cliente {
    
    private final String CNPJ;
    private Date dataFundacao;

    public Cliente_PJ(String nome, Date dataLicenca, String endereco, String educacao, String genero,
    String classeEconomica, String CNPJ, Date dataFundacao){

        super(nome, dataLicenca, endereco, educacao, genero, classeEconomica);

        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String toString() {
        String saida = super.toString() + "Cliente_PJ\nCNPJ:" + CNPJ + "\ndataFundacao:" + dataFundacao + "\n";
        return saida;
    }

    public static boolean validarCNPJ(String cnpj){
        cnpj = cnpj.replaceAll("[^\\d]", "");
        int tamanhoCNPJ = cnpj.length();

        if (tamanhoCNPJ != 14){
            return false;
        }

        // Verificando se todos os digitos são iguais
        int contador_caracteresIguais = 0;
        char num_atual = cnpj.charAt(0);
        for (int i = 1; i < tamanhoCNPJ; i++){
        
            if (cnpj.charAt(i) != num_atual){
                break;
            }
        
            else {
                contador_caracteresIguais++;
                num_atual = cnpj.charAt(i);
            }
        }
        if (contador_caracteresIguais == 14){
            return false;
        }

        // Validando o primeiro digito verificador
        int soma = 0;
        int multiplicador = 5;
        for(int i = 0; i < tamanhoCNPJ - 2; i++){

            soma += (cnpj.charAt(i) - 48) * multiplicador;
            
            if(multiplicador - 1 < 2){
                multiplicador = 10;
            }
            multiplicador--;
        }

        int resto = soma % 11;
        if (resto < 2){
            resto = 0;
        }
        else{
            resto = 11 - resto;
        }
        if (resto != cnpj.charAt(12) - 48){
            return false;
        }

        // Validando o segundo digito verificador
        multiplicador = 6;
        soma = 0;
        for(int i = 0; i < tamanhoCNPJ - 1; i++){

            soma += (cnpj.charAt(i) - 48) * multiplicador;
            
            if(multiplicador - 1 < 2){
                multiplicador = 10;
            }
            multiplicador--;
        }

        resto = soma % 11;
        if (resto < 2){
            resto = 0;
        }
        else{
            resto = 11 - resto;
        }
        if (resto != cnpj.charAt(13) - 48){
            return false;
        }

        return true;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getCNPJ(){
        return this.CNPJ;
    }

}
