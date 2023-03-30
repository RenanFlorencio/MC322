import java.util.Date;

public class Main{

    public static void main(String[] args) {
        
        Cliente cliente1;

        Date data = new Date();
        System.out.println(data);

        cliente1 = new Cliente_PJ("Renan", data, "blabla", "bla", "cpromtoa", "sim", "45959165821", data);
        System.out.println(cliente1);

        cliente1.setNome("Pedro");
        System.out.println(cliente1);

        Seguradora seg1;

        Veiculo veic1;
        veic1 = new Veiculo("12398huh", "Corsa", "Ferrari");
        System.out.println(veic1);
        
        // Testando o gerador de ID
        Sinistro s1, s2, s3;
 

    }

}