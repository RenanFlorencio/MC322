import java.util.Date;

public class Cliente_PJ extends Cliente {
    
    private final String CNPJ;
    private Date dataFundacao;



    public Cliente_PJ(String nome, Date dataLicenca, String endereco, String educacao, String genero,
    String classeEconomica, String CNPJ, Date dataFundacao){

        super(nome, dataLicenca, endereco, educacao, genero, classeEconomica);

        // Verificar como fazer isso de maneira melhor
        if (validarCNPJ(CNPJ)){
            this.CNPJ = CNPJ;
        }
        else{
            this.CNPJ = null;
        }
        this.dataFundacao = dataFundacao;
    }

    @Override
    public String toString() {
        String saida = super.toString() + "Cliente_PJ\nCNPJ:" + CNPJ + "\ndataFundacao:" + dataFundacao + "\n";
        return saida;
    }

    public boolean validarCNPJ(String cnpj){

        cnpj = cnpj.replaceAll("[^\\d]", "");
        int tamanhoCNPJ = cnpj.length();

        if (tamanhoCNPJ != 14){
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
