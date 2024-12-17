package cursodobackaofront;

public class Beneficiaria {

    private String codigoBeneficiaria;
    private float consumoBeneficiaria;

    public Beneficiaria(){

    }

    public String getCodigoBeneficiaria(){
        return codigoBeneficiaria;
    }

    public float getConsumoBeneficiaria(){
        return consumoBeneficiaria;
    }

    public void setCodigoBeneficiaria(String codigo){
        this.codigoBeneficiaria = codigo;
    }

    public void setConsumoBeneficiaria(float consumo){
        this.consumoBeneficiaria = consumo;
    }

    @Override
    public String toString() {
        return "Beneficiaria{" +
                "codigoBeneficiaria='" + codigoBeneficiaria + '\'' +
                ", consumoBeneficiaria=" + consumoBeneficiaria +
                '}';
    }
}
