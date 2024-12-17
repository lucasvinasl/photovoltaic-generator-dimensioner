package cursodobackaofront;

import java.util.List;
import java.util.ArrayList;

public class Geradora{

    private String codigoGeradora;
    private float consumoGeradora;
    private float simultaneidadeGeradora;
    private String faseGeradora;

    private Projeto projeto;


    private List<Beneficiaria> beneficiarias;

    public Geradora(){
        this.beneficiarias = new ArrayList<>();
    }

    public Geradora(String codigo, float consumo, float simultaneidade, String fase) {
        this.codigoGeradora = codigo;
        this.consumoGeradora = consumo;
        this.simultaneidadeGeradora = simultaneidade;
        this.faseGeradora = fase;
        this.beneficiarias = new ArrayList<>();
    }

    public List<Beneficiaria> getBeneficiarias() {
        return beneficiarias;
    }

    public String getCodigoGeradora(){
        return codigoGeradora;
    }

    public float getConsumoGeradora(){
        return consumoGeradora;
    }

    public void setCodigoGeradora(String codigo){
        this.codigoGeradora = codigo;
    }

    public void setConsumoGeradora(float consumo){
        this.consumoGeradora = consumo;
    }

    public float getSimultaneidadeGeradora(){
        return (simultaneidadeGeradora/100);
    }

    public String getFaseGeradora() {
        return faseGeradora;
    }

    public void setFaseGeradora(String faseGeradora) {
        this.faseGeradora = faseGeradora;
    }

    public void setSimultaneidadeGeradora(float simultaneidade){
        this.simultaneidadeGeradora = simultaneidade;
    }


    @Override
    public String toString() {
        return "Geradora{" +
                "codigoGeradora='" + codigoGeradora + '\'' +
                ", consumoGeradora=" + consumoGeradora +
                ", simultaneidadeGeradora=" + simultaneidadeGeradora +
                ", faseGeradora='" + faseGeradora + '\'' +
                ", beneficiarias=" + beneficiarias +
                '}';
    }
}
