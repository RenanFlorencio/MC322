import java.util.Date;

public class Seguro_PJ extends Seguro{
    
    private Frota frota;
    private Cliente_PJ cliente;

    public Seguro_PJ(Seguradora seguradora, Cliente_PJ cliente, Date dataInicio, Date dataFim, Frota frota) {
        super(seguradora, cliente, dataInicio, dataFim);
        this.frota = frota;
        this.cliente = cliente;
    }

    @Override
    public String toString(){
        String saida = super.toString();
        saida += frota + "\n";
        return saida;
    }

    @Override
    public double calculaValor(){

        Cliente_PJ cliente = (Cliente_PJ)super.getCliente();
        double valor = (CalcSeguro.VALOR_BASE.getFator() * (10 + (cliente.getQtdeFuncionarios()/10 ) * 
                    (1 + 1/(cliente.getQtdeVeiculos() + 2)) *
                    (1 + 1/(cliente.calculaIdade() + 2)) * 
                    (2 + getQtdeSinistrosCliente()/10) *
                    (5 + getQtdeSinistrosCondutores()/10))
                    );
        return valor;
    }

    public boolean autorizarCondutor(){

        return false;
    }

    public boolean desautorizarCondutor(){
        return false;
    }

    public Frota getFrota() {
        return frota;
    }
    public void setFrota(Frota frota) {
        this.frota = frota;
    }
    public Cliente_PJ getCliente() {
        return cliente;
    }
    public void setCliente(Cliente_PJ cliente) {
        this.cliente = cliente;
    }




}
