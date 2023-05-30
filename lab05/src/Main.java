import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws ParseException {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Seguradora> listaSeguradoras = new ArrayList<>();
        Date date = new GregorianCalendar(2003, Calendar.JUNE, 18).getTime();

        Seguradora seg = new Seguradora("33617465000145", "Seguradora", "90919019", "seg@email.com", "rua dos bobos");
        Cliente_PF cliente1 = new Cliente_PF("sadasd", "dsada", "dsadsada", "dsadadwad", "45959165821", date);
        Cliente_PF cliente2 = new Cliente_PF("222", "aaaa", "eee", "dsadadwad", "11047614839", date);

        Veiculo veic1 = new Veiculo("placa", "Corsa", "Rebaixado", 2012);
        cliente1.cadastrarVeiculo(veic1);
        listaSeguradoras.add(seg);

        seg.cadastrarCliente(cliente1);
        seg.gerarSeguro(cliente1);

        seg.transferirSeguro(cliente1, cliente2);
        
        Veiculo veic2 = new Veiculo("VAICORIN", "Saveiro", "Cromada", 2015);
        date = new GregorianCalendar(2003, Calendar.JUNE, 18).getTime();

        Cliente_PF clPF;
        date = new GregorianCalendar(1910, Calendar.SEPTEMBER, 1).getTime();
        Cliente_PJ clPJ;



        date = new GregorianCalendar(2020, Calendar.SEPTEMBER, 1).getTime();

        date = new GregorianCalendar(2020, Calendar.SEPTEMBER, 1).getTime();

        MenuOperacoes[] menuOperacoes = MenuOperacoes.values();

        System.out.println(MenuOperacoes.exibirMenu());
        int operacao = scanner.nextInt();
        MenuOperacoes escolhaMenu;
        SubMenu subop;
        
        while(operacao != 0){

            escolhaMenu = menuOperacoes[operacao - 1];
            switch(escolhaMenu){
            
                case CADASTRAR:
                    System.out.println(MenuOperacoes.exibirSubMenu(escolhaMenu));
                    subop = MenuOperacoes.CADASTRAR.getSubMenu()[scanner.nextInt() - 1];
                    if(!realizarOperacao(subop, listaSeguradoras)){
                        System.out.println("Houve um erro durante a execução, verifique a existencia do cliente ou seguradora");
                    };
                    break;
                
                case LISTAR:
                    System.out.println(MenuOperacoes.exibirSubMenu(escolhaMenu));
                    subop = MenuOperacoes.LISTAR.getSubMenu()[scanner.nextInt() - 1];
                    if(!realizarOperacao(subop, listaSeguradoras)){
                        System.out.println("Nao ha itens a serem mostrados");
                    }
                    break;
    
                case EXCLUIR:
                    System.out.println(MenuOperacoes.exibirSubMenu(escolhaMenu));
                    subop = MenuOperacoes.EXCLUIR.getSubMenu()[scanner.nextInt() - 1];
                    if(!realizarOperacao(subop, listaSeguradoras)){
                        System.out.println("Erro ao excluir. O item pode nao existir.");
                    }
                    break;
    
                case GERAR_SINISTRO:
                    String entrada;
                    Seguradora seguradora = null;
                    System.out.print("Informe a seguradora: ");
                    entrada = scanner.next();
                    
                    for(Seguradora seg1 : listaSeguradoras){
                        if (seg1.getNome().equals(entrada)){
                            seguradora = seg1;
                            break;
                        }
                    }

                    System.out.print("Informe o nome cliente: ");
                    entrada = scanner.next();
                    Cliente cliente = null;
                    
                    for (Cliente cl : seguradora.getListaClientes()){
                        if(cl.getNome().equals(entrada)){
                            cliente = cl;
                            break;
                        }
                    }

                    // System.out.print("Informe a placa do veiculo: ");
                    // Veiculo veiculo = null;
                    // for (Veiculo veic : cliente.getListaVeiculos()){
                    //     if (veic.getPlaca().equals(scanner.next())){
                    //         veiculo = veic;
                    //     }
                    // }
                    // if (veiculo == null || cliente == null || seguradora == null){
                    //     System.out.println("Seguradora, cliente ou veiculo nao encontrados. Verfique as entradas.");
                    // }
                    // else{
                    //     seguradora.adicionarSinistro(Entradas.lerSinistro(veiculo, cliente, seguradora));
                    // }
                    // break;

                case GERAR_SEGURO:

                    System.out.print("Informe o CNPJ da seguradora: ");
                    String cnpj = scanner.next();
                    System.out.print("Informe o CPF ou CNPJ do cliente: ");
                    String identificacao = scanner.next();
                    seguradora = null;

                    for (Seguradora seg1 : listaSeguradoras){
                        if (seg1.getCNPJ().equals(cnpj)){
                            seguradora = seg1;
                            break;
                        }
                    }
                    if (seguradora == null){
                        System.out.print("Seguradora não encontrada");
                        break;
                    }
                    cliente = seguradora.buscarCliente(identificacao);
                    if (!seguradora.gerarSeguro(cliente)){
                        System.out.println("Falha ao criar seguro!");
                    }
                    break;

                case TRANFERIR_SEGURO:

                    System.out.println(MenuOperacoes.exibirSubMenu(escolhaMenu));
                    subop = MenuOperacoes.TRANFERIR_SEGURO.getSubMenu()[scanner.nextInt() - 1];
                    if(!realizarOperacao(subop, listaSeguradoras)){
                        System.out.println("Houve um erro durante a execução, verifique os documentos informados!");
                    };
                    break;

                case CALCULA_RECEITA:
                    double receita = 0;

                    for(Seguradora seg1 : listaSeguradoras){
                        receita = seg1.calcularReceita();
                        System.out.println("O valor da receita de " + seg.getNome() + " é: " + receita);
                    }
                    break;
            }

            System.out.println("Operação finalizada!");
            System.out.println(MenuOperacoes.exibirMenu());
            operacao = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Programa finalizado...");
    }


    public static boolean realizarOperacao(SubMenu operacao, ArrayList<Seguradora> listaSeguradoras) throws ParseException{
    
        // Função suporte para realizar as operações desejadas no menu

        Scanner scanner = new Scanner(System.in);
        Seguradora seg = null;
        Condutor condutor = null;
        Cliente cliente = null;
        String identificacao;
        Frota frota = null;
        Cliente_PF cliente_PF = null;
        Cliente_PJ cliente_PJ = null;
        Veiculo veiculo = null;
        String nome;
        
        switch (operacao){

            case CADASTRAR_CLIENTE:
                // É necessário informar uma seguradora pois não há outra forma de acessar um cliente
                if (listaSeguradoras.size() != 0){

                    System.out.print("\nInforme o nome da seguradora: ");
                    String nomeSeg = scanner.next();

                    for (Seguradora seguradora : listaSeguradoras) {
                        if (nomeSeg.equals(seguradora.getNome())){
                            seg = seguradora;
                            break;
                        }
                    }
                    if(seg == null){
                        scanner.close();
                        return false;
                    }

                    System.out.print("\nInforme o tipo de cliente (PF ou PJ): ");
                    String tipo = scanner.next();
                    scanner.close();

                    if(tipo.equals("PF")){
                        Cliente_PF clientePF = Entradas.lerClientePF();
                        if(clientePF == null){
                            System.out.println("CPF inválido!");
                            return false;
                        }
                        seg.cadastrarCliente(clientePF);
                    }
                    else if (tipo.equals("PJ")){
                        Cliente_PJ clientePJ = Entradas.lerClientePJ();
                        if (clientePJ == null){
                            System.out.println("CNPJ inválido!");
                            return false;
                        }
                        seg.cadastrarCliente(clientePJ);
                    }
                    return true;
                }
                else{
                    System.out.println("Crie uma seguradora.");
                    scanner.close();
                    return false;
                }
            
            case CADASTRAR_CONDUTOR:

                System.out.print("Informe o CNPJ da seguradora: ");
                nome = scanner.next();
                System.out.print("Informe o CPF ou CNPJ do Cliente responsável: ");
                identificacao = scanner.next();
                scanner.close();
                Seguradora seguradora = null;

                for (Seguradora seg1 : listaSeguradoras){
                    if (seg1.getCNPJ().equals(nome)){
                        seguradora = seg1;
                        break;
                    }
                }
                if (seguradora == null){
                    return false;
                }
                Seguro seguro = seguradora.buscarSeguroCliente(identificacao);
                condutor = Entradas.lerCondutor();

                return seguro.autorizarCondutor(condutor);

            case CADASTRAR_SEGURADORA:
                
                scanner.close();
                seg = Entradas.lerSeguradora();
                listaSeguradoras.add(seg);
                return true;
            
            case CADASTRAR_VEICULO:

                veiculo = null;
                cliente_PF = null;
                System.out.print("Informe o CPF do cliente: ");
                String clientestr = scanner.next();
                scanner.close();

                for(Seguradora seg1: listaSeguradoras){
                    cliente_PF = (Cliente_PF)seg1.buscarCliente(clientestr);
                    if (cliente_PF != null){
                        break;
                    }
                }

                if (cliente_PF == null){
                    return false;
                }

                veiculo = Entradas.lerVeiculo();
                return cliente_PF.cadastrarVeiculo(veiculo);
    
            case CADASTRAR_FROTA:

                frota = null;
                cliente_PJ = null;
                System.out.print("Informe o CNPJ do cliente: ");
                String cnpj = scanner.next();
                scanner.close();

                for(Seguradora seg1: listaSeguradoras){
                    cliente_PJ = (Cliente_PJ)seg1.buscarCliente(cnpj);
                    if (cliente_PJ != null){
                        break;
                    }
                }

                if (cliente_PJ == null){
                    return false;
                }

                frota = Entradas.lerFrota();
                return cliente_PJ.cadastrarFrota(frota);

            case ATUALIZAR_FROTA:

                System.out.print("Informe o CNPJ do cliente: ");
                cnpj = scanner.next();

                for(Seguradora seg1 : listaSeguradoras){
                    cliente_PJ = (Cliente_PJ)seg1.buscarCliente(cnpj);
                    if (cliente_PJ != null){
                        break;
                    }
                }
                cliente_PJ.atualizarFrota();

            case EXCLUIR_CLIENTE:

                System.out.print("Informe o CPF ou CNPJ do cliente a ser excluido: ");
                identificacao = scanner.next();
                seg = null;
                scanner.close();

                for(Seguradora seg1: listaSeguradoras){
                    if (seg1.removerCliente(identificacao)){
                        return true;
                    }
                }
                return false;
            
            case DESAUTORIZAR_CONDUTOR:

                System.out.print("Informe o CNPJ da seguradora: ");
                cnpj = scanner.next();
                System.out.print("Informe o CPF ou CNPJ do cliente resposável: ");
                identificacao = scanner.next();
                System.out.print("Informe o CPF do condutor: ");
                nome = scanner.next();
                scanner.close();
                seguradora = null;
                cliente = null;
                seguro = null;

                for (Seguradora seg1 : listaSeguradoras){
                    if (seg1.getCNPJ().equals(cnpj)){
                        seguradora = seg1;
                        break;
                    }
                }
                if (seguradora == null){
                    return false;
                }

                seguro = seguradora.buscarSeguroCliente(identificacao);
                if (seguro == null){
                    return false;
                }

                for (Condutor cond : seguro.getListaCondutores()){
                    if (cond.getCpf().equals(nome)){
                        return seguro.getListaCondutores().remove(cond);
                    }
                }
                return false;


            case EXCLUIR_SINISTRO:

                System.out.print("Informe o ID do sinistro a ser removido: ");
                int id = scanner.nextInt();
                // sinistro = null;
                // seg = null;
                // scanner.close();

                // for(Seguradora seg1: listaSeguradoras){
                //     for(Sinistro sin: seg1.getListaSinistros()){
                //         if (id == sin.getID()){
                //             sinistro = sin;
                //             seg = seg1;
                //         }
                //     }
                // }
                // if (seg == null){
                //     return false;
                // }

                // return seg.removerSinistro(sinistro);

            case EXCLUIR_VEICULO:

                System.out.print("Informe o CPF do cliente que terá o carro removido: ");
                identificacao = scanner.next();
                System.out.print("Informe a placa do carro a ser removido: ");
                nome = scanner.next();
                veiculo = null;
                cliente_PF = null;
                scanner.close();

                for(Seguradora seg1: listaSeguradoras){
                    cliente_PF = (Cliente_PF)seg1.buscarCliente(identificacao);
                    if (cliente_PF != null){
                        break;
                    }
                }

                if (cliente_PF == null){
                    return false;
                }

                veiculo = cliente_PF.buscarVeiculo(nome);
                if (veiculo == null){
                    return false;
                }

                return cliente_PF.removerVeiculo(veiculo);

            case TRANSFERIR_SEGURO_PF:

                System.out.print("Informe o CNPJ da seguradora: ");
                cnpj = scanner.next();
                System.out.print("Informe o CPF do transferidor: ");
                String transfString = scanner.next();
                System.out.print("Informe o CPF do recipiente: ");
                String recpString = scanner.next();
                scanner.close();
                seguradora = null;

                for (Seguradora seg1 : listaSeguradoras){
                    if (seg1.getCNPJ().equals(cnpj)){
                        seguradora = seg1;
                    }
                }
                if (seguradora == null){
                    return false;
                }

                seguro = seguradora.buscarSeguroCliente(transfString);
                if (seguro == null || seguro.getClass() != Seguro_PF.class){
                    return false;
                }


                seguro.setCliente(seguradora.buscarCliente(recpString));
                Seguro_PF seguro_PF = (Seguro_PF)seguro;
                seguro_PF.setCliente((Cliente_PF)seguradora.buscarCliente(recpString));
                return true;

            case LISTAR_SEGUROS:

                // TEM QUE FAZER


            case LISTAR_CLIENTES:

                scanner.close();
                
                String saida = "";
                for(Seguradora seg1: listaSeguradoras){
                    saida += seg1.getNome().toUpperCase() +  "-----------------------\n";
                    saida += seg1.listarClientes();
                }
                if (saida.equals("")){
                    return false;
                }

                System.out.println(saida);
                return true;

            case LISTAR_SINISTRO_C:
                
                scanner.close();
                saida = "";
                for (Seguradora seg1 : listaSeguradoras){

                    for (Seguro segr : seg1.getListaSeguros()){

                        for (Condutor cond : segr.getListaCondutores()){

                            if (cond.getListaSinistros().size() != 0){
                                saida += cond.getCpf() + ":\n";
                                saida += cond.getListaSinistros() + "\n";
                                saida += "--------------\n";
                            }
                        }
                    }
                }
                if (saida != ""){
                    System.out.println(saida);
                    return true;
                }
                return false;
                    
            case LISTAR_SINISTRO_S:
                saida = "";
                seguro = null;
                
                System.out.print("Informe o ID do seguro: ");
                id = scanner.nextInt();
                scanner.close();

                for (Seguradora seg1 : listaSeguradoras){
                    seguro = seg1.buscarSeguro(id);
                    if (seguro != null){
                        break;
                    }
                }

                if (seguro == null){
                    return false;
                }

                for (Sinistro sinistro : seguro.getListaSinistros()){
                    saida += sinistro;
                }

                System.out.println(saida);
                return true;

            case LISTAR_VEICULO_C:

                cliente_PF = null;
                saida = "";
                scanner.close();

                for(Seguradora seg1 : listaSeguradoras){
                    for (Cliente cl : seg1.getListaClientes()){

                        if (cl.getClass() == Cliente_PF.class){
                            cliente_PF = (Cliente_PF)cl;
                            saida += cliente_PF.getCPF() + "\n";
                            if (cliente_PF.getListaVeiculos().size() == 0){
                                saida += "Não há veículos registrados!";
                            }
                            else{
                                saida += cliente_PF.getListaVeiculos() + "\n";
                            }
                            saida += "----------------------\n";
                        }
                    }
                }
                System.out.println(saida);
                return true;

            case LISTAR_FROTAS_C:

            cliente_PF = null;
            saida = "";
            scanner.close();

            for(Seguradora seg1 : listaSeguradoras){
                for (Cliente cl : seg1.getListaClientes()){

                    if (cl.getClass() == Cliente_PJ.class){
                        cliente_PJ = (Cliente_PJ)cl;
                        saida += cliente_PJ.getCNPJ() + "\n";
                        if (cliente_PJ.getListaFrotas().size() == 0){
                            saida += "Não há veículos registrados!";
                        }
                        else{
                            saida += cliente_PJ.getListaFrotas() + "\n";
                        }
                        saida += "----------------------\n";
                    }
                }
            }
            System.out.println(saida);
            return true;
            

            case LISTAR_VEICULO_S:

                saida = "";
                cliente_PF = null;
                cliente_PJ = null;
                System.out.print("Informe o CNPJ da seguradora: ");
                identificacao = scanner.next();
                scanner.close();
                seguradora = null;

                for (Seguradora seg1 : listaSeguradoras){
                    if (seg1.getCNPJ().equals(identificacao)){
                        seguradora = seg1;
                        break;
                    }
                }
                if (seguradora == null){
                    return false;
                }

                for (Cliente cl : seguradora.getListaClientes()){
                    cl.listarVeiculos();
                }
                return true;
                
            case VOLTAR:
                scanner.close();
                return true;
            default:
                scanner.close();
                return true;
                
        }
    }

}