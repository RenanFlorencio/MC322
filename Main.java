
public class Main{

    public static void main(String[] args) {
        
        Cliente cliente1;
        Cliente cliente2;
        cliente1 = new Cliente("Renan", "123", "18/06/2003", "Rua 1", 19);
        cliente2 = new Cliente("Lucas", "444444444-44", "10/10/2010", "Rua 2", 15);
        System.out.println(cliente1);
        System.out.println(cliente2);

        cliente1.setCPF("459.591.658/21");
        cliente1.setNome("Pedro");
        System.out.println(cliente1);
        System.out.println(cliente2);

        System.out.println(cliente1.validarCPF(cliente1.getCPF()));
        System.out.println(cliente2.validarCPF(cliente2.getCPF()));
        cliente2.setCPF("43423423");
        System.out.println(cliente2.validarCPF(cliente2.getCPF()));

        Seguradora seg1;
        seg1 = new Seguradora("Seguradora", "10101001", "seguradora@hotmail", "Rua 3");
        System.out.println(seg1);
        seg1.setTelefone("324324");
        System.out.println(seg1);

        Veiculo veic1;
        veic1 = new Veiculo("12398huh", "Corsa", "Ferrari");
        System.out.println(veic1);
        
        // Testando o gerador de ID
        Sinistro s1, s2, s3;
        s1 = new Sinistro("321321", "aaaa");
        s2 = new Sinistro("432", "ccc");
        s3 = new Sinistro("54354", "bbb");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

}