package dev.swapi.starwars.menu;

import java.util.Scanner;

public class Menu {
    static Scanner opcao = new Scanner(System.in);
    String nomeNave = "";

    public static int executaMenu() {

        System.out.println("\n\nConsumindo o WebService da API Star Wars\n");
        System.out.println("1 - Listar os dados da nave Millennium Falcon, digite 1");
        System.out.println("2 - Listar todas as naves existentes, digite 2");
        System.out.println("3 - Exibir nave mais lenta e mais rápida, digite 3");
        System.out.println("4 - Exibir nave transporta 300 passageiros em uma distância de 200 MGLT com o menor número de paradas, digite 4");

        int valor = opcao.nextInt();
        return valor;
    }
}
