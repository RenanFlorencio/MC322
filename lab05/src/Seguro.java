import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

abstract class Seguro {
    
    private final int id;
    private static int id_cont = 0;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private Cliente cliente;
    private double valorMensal;

    public Seguro(Seguradora seguradora, Cliente cliente, Date dataInicio, Date dataFim) {

        this.id = gerarID();
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = calculaValor();
    }

    public String toString(){

        String saida = "";
        saida += "Cliente: " + cliente.getNome();
        saida += "\nData de inicio: " + dataInicio;
        saida += "\nData de fim: " + dataFim;

        if (listaCondutores.size() != 0){
            saida += listaCondutores;
        }
        saida += "\nValor mensal: " + valorMensal + "\n";
        return saida;
    }

    public double calculaValor(){
        return 0;
    }

    public boolean autorizarCondutor(Condutor condutor) throws ParseException{

        if (!getListaCondutores().contains(condutor)){
            return getListaCondutores().add(condutor);
        }
        return false;
    }

    public boolean desautorizarCondutor(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o CPF do condutor: ");
        String cpf = scanner.next();
        scanner.close();
        Condutor condutor = null;

        for(Condutor cond : getListaCondutores()){
            if (cond.getCpf().equals(cpf)){
                condutor = cond;
                break;
            }
        }

        if (condutor == null){
            System.out.println("Condutor informado não encontrado.");
            return false;   
        }

        return getListaCondutores().remove(condutor);
    }

    public Condutor buscarCondutor(String cpf){
        for (Condutor condutor : listaCondutores){
            if (condutor.getCpf().equals(cpf)){
                return condutor;
            }
        }
        return null;
    }

    public boolean gerarSinistro() throws ParseException{

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o CPF do condutor: ");
        String condutorString = scanner.next();
        scanner.close();
        Condutor condutor = null;

        for(Condutor cond : getListaCondutores()){
            if (cond.getCpf().equals(condutorString)){
                condutor = cond;
                break;
            }
        }

        if (condutor == null){
            System.out.println("Condutor não encontrado: tente novamente ou cadastre o condutor.");
        }

        Sinistro sinistro = Entradas.lerSinistro(condutor, this);

        if (!getListaSinistros().contains(sinistro)){
            cliente.setAtualizado(false);
            return getListaSinistros().add(sinistro);
        }

        return false;
    }

    public boolean gerarSinistro(Sinistro sinistro, Condutor condutor){

        if (!getListaSinistros().contains(sinistro)){
            cliente.setAtualizado(false);
            return getListaSinistros().add(sinistro);
        }
        return false;
    }

    public String listarSinistros(){
        String saida = "";
        for (Sinistro sinistro : listaSinistros){
            saida += sinistro;
        }
        return saida;
    }

    public String listarCondutores(){
        String saida = "";
        for (Condutor condutor : listaCondutores){
            saida += condutor;
        }
        return saida;
    }

    public int getQtdeSinistrosCondutores(){

        if (getListaCondutores() == null){
            return 0;
        }
        int total = 0;
        for (Condutor condutor : getListaCondutores()){
            total += condutor.getListaSinistros().size();
        }
        return total;
    }

    public int getQtdeSinistrosCliente(){

        if (getListaSinistros() == null){
            return 0;
        }
        return getListaSinistros().size();
    }

    private int gerarID(){
        int id = id_cont;
        id_cont++;
        return id;
    }

    public int getId() {
        return id;
    }
    
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Seguradora getSeguradora() {
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }
    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }
    public double getValorMensal() {

        if (cliente.getAtualizado() == false){
            this.valorMensal = calculaValor();
        }

        return valorMensal;
    }
    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }

}
