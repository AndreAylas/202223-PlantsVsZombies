package tp1.p1;

import java.util.Locale;
import java.util.Scanner;

import tp1.p1.control.Controller;
import tp1.p1.control.Level;
import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

/**
 * PlantsVsZombies main class.
 */
public class PlantsVsZombies {

	/**
	 * Show application help message
	 */
	private static void usage() {
		System.out.println(Messages.USAGE);
		System.out.println(Messages.USAGE_LEVEL_PARAM);
		System.out.println(Messages.USAGE_SEED_PARAM);
	}

	/**
	 * PlantsVSZombies entry point
	 * 
	 * @param args Arguments for the game.
	 */
	public static void main(String[] args) {
		// Required to avoid issues with tests
		Locale.setDefault(new Locale("es", "ES"));

		if (args.length < 1 || args.length > 2) {
			usage();
			return;
		}

		Level level = Level.valueOfIgnoreCase(args[0]);
		if (level == null) {
			System.out.println(Messages.ALLOWED_LEVELS);
			usage();
			return;
		}

		long seed = System.currentTimeMillis() % 1000;
		String seedParam = "";
		try {
			if (args.length == 2) {
				seedParam = args[1];
				seed = Long.parseLong(seedParam);
			}
		} catch (NumberFormatException nfe) {
			System.out.println(String.format(Messages.SEED_NOT_A_NUMBER_ERROR, seedParam));
			usage();
			return;
		}

		System.out.println(Messages.WELCOME);
		System.out.println(String.format(Messages.CONFIGURED_LEVEL, level.name()));
		System.out.println(String.format(Messages.CONFIGURED_SEED, seed));

		Game game = new Game(seed, level);
		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller(game, scanner);
		controller.run();
	}

}
