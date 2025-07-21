package candidatura;

/*
*
* Programa de processo seletivo para vaga de emprego
*
* Regra de négocios:
*       - Serão aceitos candidatos que queiram um valor igual ou menor a 2000.
*       - Numero total de vagas 3 (não serão aceitos mais que 3 pessoas com salario igual ou menor a 2000)
*
* */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //candidatos e seus salarios
        String [] candidatos = {"VINICIUS", "ANNA", "IGOR", "FERNANDO", "PRISCILA", "BERNARDO", "MATHEUS", "MARIA", "JULIANA", "WLAD", "PAULO", "KWAN", "Carlos", "Silva"};
        double [] salariosPretendidos = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        //contadores do programa
        int totalCandidatosSelecionados = 0;
        boolean candidatoCeitou;

        for (int i = 0; i < candidatos.length; i++) {
            salariosPretendidos[i] = valorPretendido();
            System.out.printf(candidatos[i] + ": %.2f \n", salariosPretendidos[i]);
            candidatoCeitou = analisarCandidato(salariosPretendidos[i]);

            if (candidatoCeitou == true) {
                totalCandidatosSelecionados++;
            }
            if (totalCandidatosSelecionados == 3) {
                System.out.printf("TODOS CANDIDATOS ESCOLHIDOS");
                System.exit(0);
            }

        }

        System.out.println("Numero de candidatos selecionados: " + totalCandidatosSelecionados);
    }

    //Metodo que valida o salario pretendido e aceita se for menor ou igual a 2000. Se sim, liga para o candidato se ele aceita a vaga ou não
    public static boolean analisarCandidato(double salarioPretendido) {
        Random random = new Random();
        double salarioBase = 2000;
        boolean candidatoAceitou = false;


        //validacao
        if (salarioBase >= salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO");
            candidatoAceitou = random.nextBoolean();
            System.out.println("Candidato atendeu? " + candidatoAceitou);
            System.out.println("===========================================");
        } else {
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
            System.out.println("===========================================");
        }

        return candidatoAceitou;
    }

    //metodo que escolhe valor aleatorio entre 1800 a 2200
    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}