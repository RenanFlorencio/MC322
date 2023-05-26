import java.util.ArrayList;

public class Frota {
    
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    
    public Frota(String code) {
        this.code = code;
        listaVeiculos = new ArrayList<Veiculo>();
    }

    public String toString(){
        String saida = "";

        saida += "Código: " + code + "\n";
        if (listaVeiculos != null){
            saida += listaVeiculos;
        }
        saida += "\n";
        return saida;
    }

    public boolean addVeiculo(Veiculo veiculo){

        if (!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeVeiculo(Veiculo veiculo){

        return listaVeiculos.remove(veiculo);
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    

}
