package consoleView;

import zenGame.GraphicType;
import zenGame.Mode;
import zenGame.Square;

import java.util.Scanner;

import static java.lang.System.exit;

/**
 * This class is used to print the game
 * @author LePors
 * @version 1.0
 */
public class PrintGameMenu implements IGameMenu {

	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	private Square[][] grid;
	private int nbX, nbY;

	/**
	 * This method print the game menu
	 */
	public PrintGameMenu(Square[][] grid) {
		this.printFirstPage();
		this.grid = grid;
		this.nbX = grid.length;
		this.nbY = grid[0].length;
	}

	/**
	 * Use to print the first page on the terminal
	 */
	@Override
	public void printFirstPage() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|");
		System.out.println("\n" +
				"\n" + ANSI_YELLOW +
				"                =============== Bienvenue sur le jeu Zen l'Initié ===============" + ANSI_RESET);
		System.out.println("\n" +
				"\n" +
				"1 : JOUER\n" +
				"2 : REGLES\n" +
				"3 : QUITTER\n" +
				"VOTRE CHOIX : ");

		boolean loop = false;
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();

			if (str.equals("1") || str.equals("JOUER")) {
				System.out.println("Vous avez choisi \"JOUER\"");
				loop = true;
				this.printSecondPage();
			} else if (str.equals("2") || str.equals("REGLES")) {
				System.out.println("Vous avez choisi \"REGLES\" ");
				loop = true;
				this.rulesPage();
			} else if (str.equals("3") || str.equals("QUITTER")) {
				System.out.println("Vous avez choisi \"QUITTER\" ");
				loop = true;
				exit(0);
			} else {
				System.err.println("Mauvaise valeur recommencez :");
			}
		}
	}


	/**
	 * Ask the player about the mode
	 */
	@Override
	public Mode initializeMode() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|" + ANSI_RESET);
		System.out.println("\n");
		Mode m = null;
		boolean loop = false;
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez séléctionner le mode :\n" +
					"1 : Humain vs Humain \n" +
					"2 : Humain vs Robot");
			String str = sc.nextLine();

			if (str.equals("1") || str.equals("HumainHumain")) {
				m = Mode.HumainHumain;
				System.out.println("Vous avez choisi le mode humain vs humain");
				loop = true;
			} else if (str.equals("2") || str.equals("HumainRobot")) {
				System.out.println("Vous avez choisi le mode humain vs robot");
				m = Mode.HumainRobot;
				loop = true;
			} else {
				System.err.println("Mauvaise valeur recommencez :");
			}
		}
		return m;
	}

	/**
	 * Use to print the second page on the terminal
	 */
	@Override
	public void printSecondPage() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|" + ANSI_RESET);

		System.out.println("\n" +
				"\n" +
				"1 : NOUVELLE PARTIE\n" +
				"2 : CHARGER\n" +
				"3 : RETOUR\n" +
				"VOTRE CHOIX : ");

		boolean loop = false;
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();

			if (str.equals("1") || str.equals("NOUVELLE PARTIE")) {
				System.out.println("Vous avez choisi \"NOUVELLE PARTIE\"");
				loop = true;
			} else if (str.equals("2") || str.equals("CHARGER")) {
				System.out.println("Vous avez choisi \"CHARGER\" ");
				loop = true;

			} else if (str.equals("3") || str.equals("RETOUR")) {
				System.out.println("Vous avez choisi \"RETOUR\" ");
				loop = true;
				this.printFirstPage();
			} else {
				System.err.println("Mauvaise valeur recommencez :");
			}
		}
	}

	/**
	 * Display the grid page
	 */
	@Override
	public void gamePage(Square[][] grid) {
		this.grid = grid;
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}

		System.out.println(
				"\n" +
						"\n" +
						"            0       1       2       3       4       5       6       7       8       9       10\n" +
						"     +-------------------------------------------------------------------------------------+");
		for (int i = 10; i >= 0; i--) {
			System.out.print(i + " | ");
			for (int j = 0; j < this.nbY; j++) {
				System.out.print("       " + this.grid[i][j].getCharType());
			}
			System.out.println(" | " + i);
			System.out.println("  |                                                                                          |");
		}
		System.out.println("	  +-------------------------------------------------------------------------------------+");
		System.out.println("           0       1       2       3       4       5       6       7       8       9       10");
	}

	/**
	 * Display the rules page
	 */
	@Override
	public void rulesPage() {
		System.out.println("LES REGLES :");
	}

	/**
	 * Use to print the load page on the terminal
	 */
	@Override
	public void loadPage() {
		System.out.println("LOAD PAGE");
	}

	/**
	 * End game page
	 */
	@Override
	public void endGamePage() {
		System.out.println("=== LA PARTIE EST FINI ===");
		System.out.println("\n" +
				"\n" +
				"1 : MENU PRINCIPAL\n" +
				"2 : QUITTER\n" +
				"VOTRE CHOIX : ");

		boolean loop = false;
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();

			if (str.equals("1") || str.equals("MENU PRINCIPAL")) {
				System.out.println("Vous avez choisi \"MENU PRINCIPAL\"");
				this.printFirstPage();
				loop = true;
			} else if (str.equals("2") || str.equals("QUITTER")) {
				System.out.println("Vous avez choisi \"QUITTER\" ");
				loop = true;
				exit(0);
			} else {
				System.err.println("Mauvaise valeur recommencez :");
			}
		}
	}
}