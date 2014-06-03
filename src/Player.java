
public class Player {
	
	private int position;
	private String status;
	private int winnerPosition;
	static int winnersCount = 0;
	
	public Player() {
		position = -1;
		status = "Playing";
		setWinnerPosition(0);
	}

	public boolean userGameCompleted() {
		boolean response = false;
		if(position==(99)){
			response = true;
			winnersCount++;	
			setStatus("completed");
			setWinnerPosition(winnersCount);
			setPosition(100);
			
		}
		return response;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWinnerPosition() {
		return winnerPosition;
	}

	public void setWinnerPosition(int winnerPosition) {
		this.winnerPosition = winnerPosition;
	}
	
	
}
