package dev.swapi.starwars;

import dev.swapi.starwars.entity.Starwars;
import dev.swapi.starwars.menu.Menu;
import dev.swapi.starwars.service.StarwarsService;
import java.util.Scanner;
import dev.swapi.starwars.Dao.StarwarsDao;

import static dev.swapi.starwars.Dao.StarwarsDao.*;

public class StarwarsApplication {

	public static void main(String[] args) throws Exception {

		Boolean pareExecutar = false;
		int valor = 0;
		String nomeNave = "";

		Starwars starwars = null;
		while(!pareExecutar) {
			valor = Menu.executaMenu();

			if ((valor == 1) || (valor == 2)) {
				starwars = StarwarsService.pesquisa(valor);
			}
			switch (valor) {
				case 1:
					System.out.println("Name: " + starwars.getName());
					System.out.println("Model: " + starwars.getModel());
					System.out.println("Manufacturer: " + starwars.getManufacturer());
					System.out.println("Cost_in_credits: " + starwars.getCost_in_credits());
					System.out.println("Passengers: " + starwars.getPassengers());
					System.out.println("Cargo_capacity: " + starwars.getCargo_capacity());
					System.out.println("MGLT: " + starwars.getMGLT());
					inserirDados(starwars);
					break;
				case 2:
					System.out.println("Name: " + starwars.getName());
					System.out.println("Model: " + starwars.getModel());
					System.out.println("Manufacturer: " + starwars.getManufacturer());
					System.out.println("Cost_in_credits: " + starwars.getCost_in_credits());
					System.out.println("Passengers: " + starwars.getPassengers());
					System.out.println("Cargo_capacity: " + starwars.getCargo_capacity());
					System.out.println("MGLT: " + starwars.getMGLT());
					inserirDados(starwars);
					break;
				case 3:
					System.out.println("Nave mais lenta: " + consultaNaveMaisLenta());
					System.out.println("Nave mais rápida: " + consultaNaveMaisRapida());
					break;
				case 4:
					System.out.println("Nave transporta 300 passageiros em uma distância de 200 MGLT\n\n" + consultaNaveMenorNumeroParada());
					break;
				default:
					System.out.println("código se variável diferente de todos os valores");
				}
			}
			System.out.println("Deseja voltar para o menu inicial? sem Sim digite 1 senão digite qualquer valor");
			Scanner sc = new Scanner(System.in);
			int voltar = sc.nextInt();

			if (voltar != 1) {
				pareExecutar = true;
			}
		}
	}

