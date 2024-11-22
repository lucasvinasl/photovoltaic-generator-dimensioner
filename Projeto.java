package org.example;

public class Projeto extends UC{

    private float geracao;
    private float potencia;
    private int disponibilidade;
    private float potenciaMod;

    // construtor
    public Projeto(float consumo, float desempenho, float hsp, String fase){

        super(consumo, desempenho, hsp, fase);

        /*
        Super:
            Inicializa atributos e/ou métodos da classe mãe.
            Pode instanciar o super em outro método e reparoveitar o método da classe mãe;

            public void calcularPotencia() {
                super.calcularConsumo(); // Reutiliza um método da classe UC
                // Adiciona lógica específica para Projeto
            }

         */

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

    @Override
    public void Resultado(){
        super.Resultado();

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


/*
    Polimorfismo:

        Usar o mesmo elemento de formas diferentes.

        Sobrecarga:

            Métodos iguais com assinaturas diferentes.

            public void almocar(){

            }

            public void almocar(int opcao){

            }

            public void almocar(String prato, int opcao){

            }

        Sobreescrita:

            Sobreescreve/redefine as informações de um método.

            @Override ->
                Redefine um método da classe pai.
                Um método em uma classe filha está sobrescrevendo (ou redefinindo) um método da classe pai.
                Assinatura do método deve ser idêntica (se forem assinaturas diferentes, é sobrecarga).

            Classe Mãe:
            public void apresentar(){
                sout("Olá Mundo!");
            }

            Classe Filha:
            @Override
            public void apresentar(){
                sout("Olá Terra!");
            }
            -> nesse caso irá realmente sobreescrever o método.
            -> Mas pode reaproveitar o método e adicionar outras funcionalidades:
                        @Override
                        public void apresentar(){
                            super.apresentar();
                            sout("Olá Terra!");
                        }

 */

/*
    Interface:
        Contrato que define um conjunto de métodos que toda classe que chamar a interface deve ter.
        Não implementa o método, mas diz a quais métodos devem exisitr.
        "implements".
        Pode-se confundir com Método Abstrato, já que é cria um método que "não faz nada".

        public interface ProjetoSolar {
            void calcularPotencia(); // Cálculo da potência necessária
            void calcularGeracao();  // Cálculo da geração de energia
            void exibirRelatorio();  // Gera o relatório do projeto
        }

        public class Monofasico implements ProjetoSolar {
            private float consumo, desempenho, hsp;

            public Monofasico(float consumo, float desempenho, float hsp) {
                this.consumo = consumo;
                this.desempenho = desempenho;
                this.hsp = hsp;
            }

            @Override
            public void calcularPotencia() {
                float potencia = (consumo / (desempenho / 100)) / hsp;
                System.out.println("Potência calculada para Monofásico: " + potencia + " kWp");
            }

            @Override
            public void calcularGeracao() {
                System.out.println("Geração para Monofásico calculada com base nos dados.");
            }

            @Override
            public void exibirRelatorio() {
                System.out.println("Relatório do Projeto Monofásico gerado.");
            }
        }

*/
