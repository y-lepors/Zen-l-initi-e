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
public class PrintGameMenu implements IGameMenu{

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

	@Override
	public void printFirstPage(){
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
		while(!loop) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();

			if(str.equals("1") || str.equals("JOUER")){
				System.out.println("Vous avez choisi \"JOUER\"");
				loop = true;
				this.printSecondPage();
			} else if(str.equals("2") || str.equals("REGLES")){
				System.out.println("Vous avez choisi \"REGLES\" ");
				loop = true;
				this.rulesPage();
			} else if(str.equals("3") || str.equals("QUITTER")) {
				System.out.println("Vous avez choisi \"QUITTER\" ");
				loop = true;
				exit(0);
			}else{
				System.err.println("Mauvaise valeur recommencer :");
			}
		}
	}


	/**
	 * Ask the player about the mode
	 */
	@Override
	public Mode initializeMode(){
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|" +ANSI_RESET);
		Mode m = null;
		boolean loop = false;
		while(!loop) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez séléctionner le mode :\n" +
					"1 : Humain vs Humain \n" +
					"2 : Humain vs Robot");
			String str = sc.nextLine();

			if(str.equals("1") || str.equals("HumainHumain")){
				m = Mode.HumainHumain;
				System.out.println("Vous avez choisi le mode humain humain");
				loop = true;
			} else if(str.equals("2") || str.equals("HumainRobot")){
				System.out.println("Vous avez choisi le mode humain robot");
				m = Mode.HumainRobot;
				loop = true;
			} else {
				System.err.println("Mauvaise valeur recommencer :");
			}
		}
		return m;
	}

	@Override
	public void printSecondPage() {
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|" +ANSI_RESET);

		System.out.println("\n" +
				"\n" +
				"1 : NOUVELLE PARTIE\n" +
				"2 : CHARGER\n" +
				"3 : RETOUR\n" +
				"VOTRE CHOIX : ");
	}

	/**
	 * Display the grid page
	 */
	@Override
	public void gamePage() {

		System.out.println(
				"\n" +
				"\n" +
				"       0       1       2       3       4       5       6       7       8       9       10\n" +
				"	+-------------------------------------------------------------------------------------+");
		for(int i = 0; i < this.nbX ; i++){
			for(int j = 0; j < this.nbY ; j++){
				System.out.print("       "+this.grid[i][j].getCharType());
			}
			System.out.println(" | " + i);
			System.out.println("                                                                                         |");
			//System.out.println("                                                                                         |");
		}
		System.out.println("	+-------------------------------------------------------------------------------------+");
		System.out.println("       0       1       2       3       4       5       6       7       8       9       10");
	}

	/**
	 * Display the rules page
	 */
	@Override
	public void rulesPage(){
		System.out.println("LES REGLES :");
	}

}