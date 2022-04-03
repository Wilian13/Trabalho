package br.edu.univas.main;
import java.util.Scanner;

import br.edu.univas.vo.Player;
import br.edu.univas.vo.Tipo;

import java.util.ArrayList;
import java.util.Random;

public class StartApp {
	
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in); 
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<Tipo>tipos = new ArrayList<>();
		int option = 0;
		
		do {
            printMenu();
            option = readInt(scanner);

            if (option == 1) {
            	cadastrarPlayer(players, scanner);
            } else if (option == 2) {
            	cadastrarPlayer(players, scanner);
            	CadastrarTitulo(tipos,players, scanner);
            } else if (option == 3) {
            	menuBusca(tipos,players, scanner);
            } else if (option == 4) {
            		buscaPorGenero(tipos,players, scanner);
            }else if (option == 5) {
            		recomendacaoAleatoria(tipos);
            }else if (option != 9) {
                System.out.println("Opção invalida!");
            }
        } while(option != 9);

        scanner.close();
    }
		
			
	
	
		public static void cadastrarPlayer(ArrayList<Player>players,Scanner scanner) {

			
		Player player = new Player();
		System.out.println("Informe o nome da plataforma");
		player.setNome(readString(scanner));
		System.out.println("Informe o site");
		player.setSite(readString(scanner));
		
		players.add(player);

		}
		public static void CadastrarTitulo(ArrayList<Tipo>tipos, ArrayList<Player>players, Scanner scanner) {
	    Tipo tipo = new Tipo();
	    
	
	System.out.println("Informe o titulo:");
	tipo.setTitulo(readString(scanner));
	System.out.println("Informe elenco:");
	tipo.setElenco(readString(scanner));
	System.out.println("Descrição:");
	tipo.setDescricao(readString(scanner));
	System.out.println("Informe o genero:");
	tipo.setGenero(readString(scanner));
	System.out.println("Informe o diretor:");
	tipo.setDiretor(readString(scanner));
	System.out.println("Informe a classificação etária:");
	tipo.setClassificacaoEtaria(readString(scanner));
	
	tipos.add(tipo);

	}
		public static String readString(Scanner scanner) {
		String aux = scanner.nextLine();
		return aux;

		}

		public static int readInt(Scanner scanner) {
		int aux = scanner.nextInt();
		scanner.nextLine();
		return aux;
		}




	public static void menuBusca(ArrayList<Tipo>tiposList,ArrayList<Player>players, Scanner scanner) {
			System.out.println("Busca por titulo");
			String aux = scanner.nextLine();
			int contador = 0;
			
	 for(int i = 0; i < tiposList.size(); i++){
		 if (tiposList.get(i).getTitulo().equals(aux)) {
			 
			 System.out.println("Titulo: "+tiposList.get(i).getTitulo());
			 System.out.println("Elenco: "+tiposList.get(i).getElenco());
			 System.out.println("Descrição: "+tiposList.get(i).getDescricao());
			 System.out.println("Genêro: "+tiposList.get(i).getGenero());
			 System.out.println("Classificação Etaria: "+tiposList.get(i).getClassificacaoEtaria());
			 System.out.println("Diretor: "+tiposList.get(i).getDiretor());
			 System.out.println("Plataforma: "+players.get(i).getNome());
			 System.out.println("Url: "+players.get(i).getSite());
			 
			 
			 contador++;
			
			
		 }
	 }
	 
	   if(contador == 0) {
		   System.out.println("Titulo não encontrado!");
		   
	   }
		}
	  
	 private static void printMenu() {
		 System.out.println("1- Cadastrar Player");
		 System.out.println("2- Cadastrar Titulo");
		 System.out.println("3- Busca por Titulo do filme");
		 System.out.println("4- Busca por genêro");
		 System.out.println("5- Recomendação aleatória");
		 System.out.println("9- Sair");
	 }
	 
	 public static void recomendacaoAleatoria(ArrayList<Tipo>tiposList) {
		 if( tiposList.size() == 0) {
			 System.out.println("Nenhum titulo cadastrado!");
			 
		 }
	 
		 
		 else { 
			 
			 Random random = new Random();
		 

		 int aleatorio = random.nextInt(tiposList.size());
		 
		 System.out.println("Recomendação"+ tiposList.get(aleatorio).toString());

		 }		
	 }
		 
	 public static void buscaPorGenero(ArrayList<Tipo>tiposList, ArrayList<Player>players, Scanner scanner) {
		 
		 System.out.println("Busca por genêro");
			String aux2 = scanner.nextLine();
			int contador = 0;
	 
			for(int i = 0; i < tiposList.size(); i++){
				 if (tiposList.get(i).getGenero().equals(aux2)) {
					 System.out.println("Titulo: "+tiposList.get(i).getTitulo());
					 System.out.println("Elenco: "+tiposList.get(i).getElenco());
					 System.out.println("Descrição: "+tiposList.get(i).getDescricao());
					 System.out.println("Genêro: "+tiposList.get(i).getGenero());
					 System.out.println("Classificação Etaria: "+tiposList.get(i).getClassificacaoEtaria());
					 System.out.println("Diretor: "+tiposList.get(i).getDiretor());
					 System.out.println("Plataforma: "+players.get(i).getNome());
					 System.out.println("Url: "+players.get(i).getSite());
					 
					 
					 contador++;
					
					}
		 
		 
	 }
			 if(contador == 0) {
				   System.out.println("Titulo não encontrado!");
				   
			   }
	 }	 
}
