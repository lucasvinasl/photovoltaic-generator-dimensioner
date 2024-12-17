package cursodobackaofront;

import java.util.HashMap;

public class Projeto extends Geradora{

    private float geracao;
    private float potencia;
    private int custoDisponibilidade;
    private float potenciaMod;
    private float desempenho;
    private float hsp;

    public Projeto(String codigo, float consumo, float simultaneidade, String fase) {
        super(codigo, consumo, simultaneidade, fase);
    }

    public float getGeracao() {
        return geracao;
    }

    public void setGeracao(float geracao) {
        this.geracao = geracao;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public int getCustoDisponibilidade() {
        return custoDisponibilidade;
    }

    public void setCustoDisponibilidade(int custoDisponibilidade) {
        this.custoDisponibilidade = custoDisponibilidade;
    }

    public float getPotenciaMod() {
        return potenciaMod;
    }

    public void setPotenciaMod(float potenciaMod) {
        this.potenciaMod = potenciaMod;
    }

    public float getDesempenho() {
        return (desempenho/100);
    }

    public void setDesempenho(float desempenho) {
        this.desempenho = desempenho;
    }

    public float getHsp() {
        return hsp;
    }

    public void setHsp(float hsp) {
        this.hsp = hsp;
    }

    public float consumoFinal(){
        float consumoBeneficiarias = 0;
        for(int i = 0; i < getBeneficiarias().size(); i++){
            consumoBeneficiarias += getBeneficiarias().get(i).getConsumoBeneficiaria();
        }

        float consumoTotal = (this.getConsumoGeradora()+consumoBeneficiarias);
        return consumoTotal;
    }

    public void setGeracao(){
        this.geracao = this.getPotencia()*this.getHsp()*30.0f * this.getDesempenho();
    }

    public void setPotencia(){
        float potMod = this.potenciaMod / 1000.0f;
        float potencia_inicial = this.consumoFinal() / (this.getHsp() * 30.0f * this.getDesempenho());
        float qtdMod = (float)Math.ceil((double)(potencia_inicial / potMod));
        this.potencia = qtdMod * potMod;
    }

    public void setDisponibilidade() {
        String fase = this.getFaseGeradora().toLowerCase();
        if (fase.equalsIgnoreCase("monofasico")) {
            this.custoDisponibilidade = 30;
        } else if (fase.equalsIgnoreCase("bifasico")) {
            this.custoDisponibilidade = 50;
        } else {
            if (!fase.equalsIgnoreCase("trifasico")) {
                throw new IllegalArgumentException("Fase inválida. Use Monofásico, Bifásico ou Trifásico.");
            }
            this.custoDisponibilidade = 100;
        }
    }

    public HashMap<String, Float> porcentagemBeneficiaria(){

            HashMap<String, Float> percentuais = new HashMap<String, Float>();
            float consumoTotal = 0;
            for(int i = 0; i < getBeneficiarias().size(); i++ ){
                consumoTotal += getBeneficiarias().get(i).getConsumoBeneficiaria();
            }

            for(Beneficiaria beneficiaria: getBeneficiarias()){
                float consumoBeneficiaria_i = beneficiaria.getConsumoBeneficiaria();
                float percentual = (consumoBeneficiaria_i / consumoTotal)*100;
                percentuais.put(beneficiaria.getCodigoBeneficiaria(), percentual);
            }

            return percentuais;
    }



    public float injetadoGeradora() {
            float consumoInst = getGeracao() * getSimultaneidadeGeradora();
            float injetado = getGeracao() - consumoInst;
            return injetado;
    }


    public float sobraRateio(){
            float injetado = injetadoGeradora();
            float consumo = getConsumoGeradora();
            float sobra = consumo-injetado;

            return sobra;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "geracao=" + geracao +
                ", potencia=" + potencia +
                ", custoDisponibilidade=" + custoDisponibilidade +
                ", potenciaMod=" + potenciaMod +
                ", desempenho=" + desempenho +
                ", hsp=" + hsp +
                '}';
    }


}



