package org.example;

public class Projeto extends UC{

    private float geracao;
    private float potencia;
    private int disponibilidade;
    private float potenciaMod;

    // construtor
    public Projeto(float consumo, float desempenho, float hsp, String fase){
        super(consumo, desempenho, hsp, fase);
    }

    // métodos - get
    public float getPotenciaMod(){
        return potenciaMod;
    }
    public float getGeracao(){
        return geracao;
    }
    public float getPotencia(){
        return potencia;
    }
    public int getDisponibilidade(){
        return disponibilidade;
    }

    // métodos - set

    public void setPotenciaMod(float potenciaMod){
        this.potenciaMod = potenciaMod;
    }

    public float consumoFinal() {
        return getConsumo() - getDisponibilidade();
    }


    public void setGeracao(){
        this.geracao = getPotencia()*getHsp()*30*getDesempenho();
    }

    public void setPotencia(){
        float potMod = this.potenciaMod/1000;
        float potencia_inicial = (consumoFinal()  / (getHsp() * 30 * getDesempenho()));
        float qtdMod = (float) Math.ceil(potencia_inicial/(potMod));
        this.potencia = qtdMod * potMod;
    }

    public void setDisponibilidade(){
        String fase = getFase().toLowerCase();

        if(fase.equalsIgnoreCase("monofasico")){
            this.disponibilidade = 30;
        }else if( fase.equalsIgnoreCase("bifasico")){
            this.disponibilidade = 50;
        } else if (fase.equalsIgnoreCase("trifasico")) {
            this.disponibilidade = 100;
        }else{
            throw new IllegalArgumentException("Fase inválida. Use Monofásico, Bifásico ou Trifásico.");
        }
    }

    public void ResultadoProjeto(){

        float potencia = getPotencia();
        float geracao = getGeracao();
        int disponibilidade = getDisponibilidade();
        float consumoFinal = consumoFinal();

        System.out.println("**** Dimensionamento Final: ****\n");
        System.out.printf("Potência Necessária do Sismtea: %.2f kWp \n", potencia);
        System.out.printf("Geração Média Mensal Prevista: %.2f Kwh/Mês \n",geracao);
        System.out.printf("Considerando %d kWh de Disponibilidade um Consumo Final de %.2f kWh/mês\n",disponibilidade,consumoFinal);
        System.out.println("");
        System.out.println("**** Projeto Concluído com Sucesso! ****\n");

    }

}
