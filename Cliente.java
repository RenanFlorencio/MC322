import java.util.Date;
import java.util.ArrayList;

class Cliente{

    private String nome;
    private Date dataLicenca;
    private String endereco;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private ArrayList<Veiculo> listaVeiculos; // Pensar se devo usar ArrayList ou LinkedList

    // Construtor
    public Cliente(String nome, Date dataLicenca, String endereco, String educacao, String genero,
            String classeEconomica) {
        this.nome = nome;
        this.dataLicenca = dataLicenca;
        this.endereco = endereco;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    
    public String toString() {
        return "Cliente \nNome:" + nome + ", \nData Licenca:" + dataLicenca + "\nEndereco:" + endereco + "\nEducacao:"
                + educacao + "\nGenero:" + genero + "\nClasse Economica:" + classeEconomica + "\n";
    }

    // Getters e Setters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Date getDataLicenca(){
        return this.dataLicenca;
    }

    public void setdataLicenca(Date dataLicenca){
        this.dataLicenca = dataLicenca;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
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