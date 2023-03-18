public class Main{

    public static void main(String[] args) {
        
        Cliente cliente;
        Sinistro sinistro;
        cliente = new Cliente("teste", "12345678901", "01/01/2001", "teste", 19);
        sinistro = new Sinistro("01/01/2002", "teste");

        System.out.println(sinistro.gerarID());

    }

}