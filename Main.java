import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();

        Cliente cliente1;

        System.out.println("Informe o CNPJ: ");
        String cnpj = scanner.nextLine();

        if (Cliente_PJ.validarCNPJ(cnpj)){
            cliente1 = new Cliente_PJ("Renan", data, "blabla", "bla", "cpromtoa", "sim", "13.347.016/0001-17", data);
            System.out.println("Deu certo");
        }
        
        Seguradora seg1;

        Veiculo veic1;
        veic1 = new Veiculo("12398huh", "Corsa", "Ferrari");
        System.out.println(veic1);
        
        // Testando o gerador de ID
        Sinistro s1, s2, s3;
 

    }

}