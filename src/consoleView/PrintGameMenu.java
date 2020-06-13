package consoleView;

import zenGame.GraphicType;
import zenGame.Mode;

import java.util.Scanner;

/**
 * This class is used to print the game
 * @author LePors
 * @version 1.0
 */
public class PrintGameMenu implements IGameMenu{

	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	/**
	 * This method print the game menu
	 */
	public PrintGameMenu() {
		this.printFirstPage();
	}

	/**
	 * This method print the rules
	 */
	public void printRules() {
		// TODO - implement PrintGameMenu.printRules
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
					"1 : HumainHumain \n" +
					"2 : HumainRobot");
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

	@Override
	public void GamePage() {
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|" +ANSI_RESET);

		System.out.println(
				"\n" +
				"\n" +
				"         A		   B		C			" +
				"		+------------------------------");
	}

}