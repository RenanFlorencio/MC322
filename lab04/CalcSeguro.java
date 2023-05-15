public enum CalcSeguro {
    VALOR_BASE(100),
    FATOR_18_30(1.2),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    private final double fator;

    CalcSeguro(double fator){
        this.fator = fator;
    }

    public static double calcFator(int idade){

        if (idade >= 18 && idade < 30){
            return FATOR_18_30.getFator();
        }
        if (idade >= 30 && idade < 60){
            return FATOR_30_60.getFator();
        }
        if (idade >= 18 && idade < 30){
            return FATOR_60_90.getFator();
        }
        return 0;
    }

    public double getFator(){
        return this.fator;
    }
}
