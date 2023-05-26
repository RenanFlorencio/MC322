public enum SubMenu {
    CADASTRAR_CLIENTE("Cadastrar Cliente"),
    CADASTRAR_VEICULO("Cadastrar Veículo"),
    CADASTRAR_SEGURADORA("Cadastrar Seguradora"),
    LISTAR_CLIENTES("Listar Clientes (PF/PJ) por Seg."),
    LISTAR_SINISTRO_S("Listar Sinistro por Seguradora"),
    LISTAR_SINISTRO_C("Listar Sinistro por Cliente"),
    LISTAR_VEICULO_C("Listar Veículo por Cliente"),
    LISTAR_VEICULO_S("Listar Veículo por Seguradora"),
    EXCLUIR_CLIENTE("Excluir Cliente"),
    EXCLUIR_VEICULO("Excluir Veículo"),
    EXCLUIR_SINISTRO("Excluir Sinistro"),
    VOLTAR("Voltar");

    private String texto;

    SubMenu(String texto){
        this.texto = texto;
    }

    public String getTexto(){
        return this.texto;
    }
}
