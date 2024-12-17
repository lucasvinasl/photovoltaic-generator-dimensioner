package cursodobackaofront;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            String codigoGeradora = JOptionPane.showInputDialog("Informe o Código da Geradora: ");
            float consumoGeradora = Float.parseFloat(JOptionPane.showInputDialog("Informe o Consumo da Geradora: "));
            float simultaneidadeGeradora = Float.parseFloat(JOptionPane.showInputDialog("Informe a % Simultaneidade: "));
            String faseGeradora = JOptionPane.showInputDialog("Informe a Fase (Monofasico / Bifasico / Trifasico): ");

            Projeto projeto = new Projeto(codigoGeradora, consumoGeradora, simultaneidadeGeradora, faseGeradora);

            projeto.setCodigoGeradora(codigoGeradora);
            projeto.setConsumoGeradora(consumoGeradora);
            projeto.setSimultaneidadeGeradora(simultaneidadeGeradora);
            projeto.setFaseGeradora(faseGeradora);
            System.out.println(projeto);

            int potenciaModulo = Integer.parseInt(JOptionPane.showInputDialog("Potência do Módulo em Wp: "));
            float desempenhoProjeto = Float.parseFloat(JOptionPane.showInputDialog("Desempenho do Sistema em %: "));
            float hspProjeto = Float.parseFloat(JOptionPane.showInputDialog("HSP do Local: "));

            int adicionarBeneficiaria = JOptionPane.showConfirmDialog(null,
                    "Deseja adicionar Beneficiária?");

            if(adicionarBeneficiaria == JOptionPane.YES_OPTION){
                int qtdBeneficiarias = Integer.parseInt(JOptionPane.showInputDialog("Quantas beneficiárias deseja adicionar?"));
                for(int i = 0; i < qtdBeneficiarias; i++){
                    Beneficiaria beneficiaria = new Beneficiaria();
                    String codigoBeneficiaria = JOptionPane.showInputDialog("Informe o Código da Beneficiária "+(i+1)+":");
                    float consumoBeneficiaria = Float.parseFloat(JOptionPane.showInputDialog("Informe o Consumo da Beneficiária "+(i+1)+":"));
                    beneficiaria.setCodigoBeneficiaria(codigoBeneficiaria);
                    beneficiaria.setConsumoBeneficiaria(consumoBeneficiaria);
                    projeto.getBeneficiarias().add(beneficiaria);

                }

                JOptionPane.showMessageDialog(null,"Beneficiárias Adicionadas!");

            }

            projeto.setPotenciaMod(potenciaModulo);
            projeto.setDesempenho(desempenhoProjeto);
            projeto.setHsp(hspProjeto);
            projeto.setDisponibilidade();
            projeto.setPotencia();
            projeto.setGeracao();
            System.out.println(projeto);

            HashMap<String, Float> percentuais = projeto.porcentagemBeneficiaria();
            for(Map.Entry<String, Float> entry : percentuais.entrySet()){
                System.out.println("Código da Beneficiária: " + entry.getKey() + " - Percentual: " + entry.getValue() + "%");
            }

            /*
                        JOptionPane.showMessageDialog(null,"Injetado: "+projeto.injetadoGeradora()+"\n"+
                    "Sobra para o Rateio: "+projeto.sobraRateio());
             */


    }
}