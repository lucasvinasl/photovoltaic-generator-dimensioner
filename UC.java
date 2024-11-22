package org.example;

import java.sql.ResultSet;

public class UC {
    // atributos
    private float consumo;
    private float desempenho;
    private float hsp;
    private String fase;

    // construtor
    public UC(){
        consumo = 0;
        desempenho = 0;
        hsp = 0;
        fase = "";
    }


    public UC(float consumo, float desempenho, float hsp, String fase){
        this.consumo = consumo;
        this.desempenho = desempenho;
        this.hsp = hsp;
        this.fase = fase;
    }

    // métodos get - Retornam os valores
    public float getConsumo(){
        return consumo;
    }
    public float getDesempenho(){
        return desempenho;
    }
    public float getHsp(){
        return hsp;
    }
    public String getFase(){
        return fase;
    }

    // métodos set - NÃO RETORNA NADA (void), apenas atribui
    public void setConsumo(float consumo){
        this.consumo = consumo;
    }
    public void setDesempenho(float desempenho){
        this.desempenho = desempenho/100;
    }
    public void setHsp(float hsp){
        this.hsp = hsp;
    }
    public void setFase(String fase){
        this.fase = fase;
    }

    public void Resultado(){

        float consumo = getConsumo();
        float desempenho = (getDesempenho()*100);
        float hsp = getHsp();
        System.out.printf("Projeto Realizado para Unidade Consumidora com Consumo: %.2f kWh/mês. %n", consumo);
        System.out.printf("Considerando um Desempenho de %.2f% e HSP de %.2f %n.", desempenho,hsp);
        System.out.println("");

    }


}
