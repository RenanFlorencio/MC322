
public enum MenuOperacoes{
    
    CADASTRAR("1- Cadastrar ou atualizar", new SubMenu[]{
        SubMenu.CADASTRAR_CLIENTE, 
        SubMenu.CADASTRAR_SEGURADORA, 
        SubMenu.CADASTRAR_VEICULO,
        SubMenu.CADASTRAR_CONDUTOR,
        SubMenu.ATUALIZAR_FROTA,
        SubMenu.VOLTAR}),
    LISTAR("2- Listar", new SubMenu[] {
        SubMenu.LISTAR_CLIENTES,
        SubMenu.LISTAR_SINISTRO_C,
        SubMenu.LISTAR_SINISTRO_S,
        SubMenu.LISTAR_VEICULO_C,
        SubMenu.LISTAR_VEICULO_S,
        SubMenu.LISTAR_FROTAS_C,
        SubMenu.LISTAR_SEGUROS,
        SubMenu.VOLTAR
    }),
    EXCLUIR("3- Excluir ou desautorizar", new SubMenu[] {
        SubMenu.EXCLUIR_CLIENTE,
        SubMenu.EXCLUIR_SINISTRO,
        SubMenu.EXCLUIR_VEICULO,
        SubMenu.DESAUTORIZAR_CONDUTOR,
        SubMenu.VOLTAR
    }),
    GERAR_SINISTRO("4- Gerar Sinistro", new SubMenu[] {}),
    GERAR_SEGURO("5- Gerar Seguro", new SubMenu[] {}),
    TRANFERIR_SEGURO("6- Transferir Seguro", new SubMenu[] {
        SubMenu.TRANSFERIR_SEGURO_PF,
        SubMenu.TRANSFERIR_SEGURO_PJ,
    }),
    CALCULA_RECEITA("7- Calcular Receita Seguradora", new SubMenu[] {});
    

    public final String texto;
    private SubMenu[] subMenu;

    MenuOperacoes(String texto, SubMenu[] subMenu){
        this.texto = texto;
        this.subMenu = subMenu;
    }

    public static String exibirMenu(){
        String out = "";
        for (MenuOperacoes menu: MenuOperacoes.values()){
            out += menu.getTexto() + "\n";
        }
        return out;
    }

    public static String exibirSubMenu(MenuOperacoes op){
        String out = "";
        int cont = 1;
        for(SubMenu sub : op.getSubMenu()){
            out += cont + "- " + sub.getTexto() + "\n";
            cont++;
        }
        return out;
    }

    public String getTexto(){
        return this.texto;
    }

    public SubMenu[] getSubMenu(){
        return this.subMenu;
    }
}
