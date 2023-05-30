public enum SubMenu {
    CADASTRAR_CLIENTE("Cadastrar Cliente"),
    CADASTRAR_VEICULO("Cadastrar Veículo"),
    CADASTRAR_FROTA("Cadastrar Frota"),
    CADASTRAR_CONDUTOR("Cadastrar Condutor"),
    ATUALIZAR_FROTA("Atualizar Frota"),
    CADASTRAR_SEGURADORA("Cadastrar Seguradora"),
    LISTAR_CLIENTES("Listar Clientes (PF/PJ) por Seg."),
    LISTAR_SEGUROS("Listar Seguros de uma Seguradora"),
    LISTAR_SINISTRO_S("Listar Sinistro por Seguro"),
    LISTAR_SINISTRO_C("Listar Sinistros por Condutor"),
    LISTAR_VEICULO_C("Listar Veículo por Cliente"),
    LISTAR_VEICULO_S("Listar Veículo por Seguradora"),
    LISTAR_FROTAS_C("Listar Frotas por Cliente"),
    TRANSFERIR_SEGURO_PF("Transferir seguro de PF para PF"),
    TRANSFERIR_SEGURO_PJ("Transferir seguro de PJ para PJ"),
    EXCLUIR_CLIENTE("Excluir Cliente"),
    EXCLUIR_VEICULO("Excluir Veículo"),
    EXCLUIR_SINISTRO("Excluir Sinistro"),
    DESAUTORIZAR_CONDUTOR("Desautorizar Condutor"),
    VOLTAR("Voltar");

    private String texto;

    SubMenu(String texto){
        this.texto = texto;
    }

    public String getTexto(){
        return this.texto;
    }
}
