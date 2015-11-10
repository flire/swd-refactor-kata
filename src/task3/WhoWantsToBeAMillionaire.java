package task3;

import java.util.Scanner;

/**
 * Simplify and make Game API more robust where possible
 */
public class WhoWantsToBeAMillionaire {
	public static void main(String[] args) {
		Game game = initializeGame();
		play(game);
	}

	private static void play(Game game) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (!game.isEnded()) {
				makeTurn(game, scanner);
			}
			if (game.isWon()) {
				System.out.println("Take your Million!");
			}
			System.out.println("You've lost");
		}
	}

	private static void makeTurn(Game game, Scanner scanner) {
		System.out.println(game.getNextQuestion());
		game.proposeAnswer(scanner.nextLine());
	}

	private static Game initializeGame() {
		Game game = new Game();
		game.addQuestion("What is the Capital of Great Britain?", "Paris", "Karaganda", "Dublin", "London", "London");
		game.addQuestion("Who is the author of Godfather novel?", "Hemingway", "Puzo", "Vonnegut", "Tolstoy", "Puzo");
		game.addQuestion("What is the distance to the Moon?", "156 000 km", "384 000 km", "432 000 km", "521 000 km",
				"384 000 km");
		return game;
	}
}
