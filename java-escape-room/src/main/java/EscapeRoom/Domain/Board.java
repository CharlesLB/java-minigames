package EscapeRoom.Domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Board {
	public static final int GRID_LENGTH = 24;
	private int markedNumbersTotal = 0;
	private List<Integer> data = createBoard();

	public void setMarkedNumbersTotal(int markedNumbersTotal) {
		this.markedNumbersTotal = markedNumbersTotal;
	}

	public List<Integer> getData() {
		return data;
	}

	private List<Integer> createBoard() {
		List<Integer> boardData = new ArrayList<>(GRID_LENGTH);
		int insertNumber;
		int positionValue;
		Random random = new Random();

		for (int i = 0; i < GRID_LENGTH; i++) {
			positionValue = getColumnValue(i);

			do {
				insertNumber = random.nextInt(15) + 1 + positionValue;
			} while (boardData.contains(insertNumber));

			boardData.add(insertNumber);
		}

		boardData.sort(Comparator.naturalOrder());
		return boardData;
	}

	private int getColumnValue(int position) {
		if (position < 5) {
			return 0;
		}

		if (position < 10) {
			return 15;
		}

		if (position < 14) {
			return 30;
		}

		if (position < 19) {
			return 45;
		}

		return 60;
	}

	public void markNumber(int number) {
		if (!this.getData().contains(number)) {
			return;
		}

		this.setMarkedNumbersTotal(this.markedNumbersTotal + 1);
	}

	public boolean isWinner() {
		return markedNumbersTotal == 24;
	}
}
