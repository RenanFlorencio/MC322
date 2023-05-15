import java.util.Date;

public class Cliente_PJ extends Cliente {
    
    private final String CNPJ;
    private Date dataFundacao;
    private int qtdeFuncionarios;

    public Cliente_PJ(String nome, String endereco, String CNPJ, Date dataFundacao, int qtdeFuncionarios){

        super(nome, endereco);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    @Override
    public String toString() {
        String saida = super.toString() + "CNPJ: " + CNPJ + "\ndataFundacao: " + dataFundacao + "\n";
        return saida;
    }

    @Override
    public double calculaScore(){
        setAtualizado(true);
        return CalcSeguro.VALOR_BASE.getFator() * (1 + (qtdeFuncionarios)/100) * super.getListaVeiculos().size();
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

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        setAtualizado(false);
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

}
