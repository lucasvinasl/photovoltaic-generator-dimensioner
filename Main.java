package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {

                UC uc = new UC();

                System.out.println("Informe o Consumo: ");
                float consumo = input.nextFloat();
                if (consumo == 0) {
                    System.out.println("Consumo inválido. Reiniciando...");
                    continue;
                }
                uc.setConsumo(consumo);


                System.out.println("Informe o Desempenho em %: ");
                float desempenho = input.nextFloat();
                if (desempenho == 0) {
                    System.out.println("Desempenho inválido. Reiniciando...");
                    continue; // Reinicia o loop
                }
                uc.setDesempenho(desempenho);


                System.out.println("Informe o HSP: ");
                float hsp = input.nextFloat();
                if (hsp == 0) {
                    System.out.println("HSP inválido. Reiniciando...");
                    continue;
                }
                uc.setHsp(hsp);
                input.nextLine();

                System.out.println("Informe a Fase (Monofasico / Bifasico / Trifasico): ");
                String fase = input.nextLine();
                uc.setFase(fase);

                Projeto project = new Projeto(uc.getConsumo(), uc.getDesempenho(), uc.getHsp(), uc.getFase());


                System.out.println("Informe a Potência do Módulo em Wp: ");
                float potenciaMod = input.nextFloat();
                if (potenciaMod == 0) {
                    System.out.println("Potência inválida. Reiniciando...");
                    continue;
                }

                project.setPotenciaMod(potenciaMod);
                project.setDisponibilidade();
                project.setPotencia();
                project.setGeracao();
                project.ResultadoProjeto();

                System.out.println("Deseja realizar outro dimensionamento? (S/N): ");
                char resposta = input.next().toLowerCase().charAt(0);

                if (resposta == 'n') {
                    continuar = false;
                    System.out.println("Obrigado!");
                }

        }

        input.close();
    }
}
