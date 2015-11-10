package task3;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Question> questions = new ArrayList<>();
	private List<String> answers = new ArrayList<>();
	private int currentQuestion = 0;
	private GameStatus gameStatus = GameStatus.RUNNING;

	public void addQuestion(String q, String answ1, String answ2, String answ3, String answ4, String correctAnsw) {
		questions.add(new Question(q, answ1, answ2, answ3, answ4));
		answers.add(correctAnsw);
	}

	public String getNextQuestion() {
		return printQuestion(questions.get(currentQuestion));
	}

	private String printQuestion(Question question) {
		StringBuilder builder = new StringBuilder();
		appendLine(builder, question.q);
		appendLine(builder, "1. " + question.answ1);
		appendLine(builder, "2. " + question.answ2);
		appendLine(builder, "3. " + question.answ3);
		appendLine(builder, "4. " + question.answ4);
		return builder.toString();
	}

	private void appendLine(StringBuilder builder, String line) {
		builder.append(line).append(System.lineSeparator());
	}

	private void checkAnswer(Question q, String answer) {
		boolean result = answers.get(questions.indexOf(q)).equals(answer);
		changeStatus(result);
	}

	private void changeStatus(boolean isAnswerCorrect) {
		if (!isAnswerCorrect) {
			gameStatus = GameStatus.LOST;
		} else {
			if (currentQuestion == questions.size() - 1) {
				gameStatus = GameStatus.WON;
			}
			currentQuestion++;
		}

	}

	public void proposeAnswer(String answer) {
		checkAnswer(questions.get(currentQuestion), answer);
	}

	public boolean isEnded() {
		return gameStatus != GameStatus.RUNNING;
	}

	public boolean isWon() {
		return gameStatus == GameStatus.WON;
	}
}