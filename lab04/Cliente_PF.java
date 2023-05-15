import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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

    public int calculaIdade(Date dataNascimento){
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.ofInstant(dataNascimento.toInstant(), ZoneId.systemDefault());

        return Period.between(date, now).getYears();
    }

    @Override
    public double calculaScore(){
    
        int idade = calculaIdade(dataNascimento);
        double fator = CalcSeguro.calcFator(idade);
        setAtualizado(true);
        return CalcSeguro.VALOR_BASE.getFator() * fator * super.getListaVeiculos().size();
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
