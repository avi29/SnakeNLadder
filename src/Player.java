
public class Player {
	
	private int position;
	private PlayerStatus status;
	private int rank;
    //todo : find a better way than handling this as a static.
	static int winnersCount = 0;
    private String name;
	
	public Player() {
		position = -1;
		status = PlayerStatus.Playing;
		setRank(0);
	}

	public boolean userGameCompleted() {
		boolean response = false;
		if(position==(99)){
			response = true;
			winnersCount++;
			setStatus(PlayerStatus.Completed);
			setRank(winnersCount);
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

	public PlayerStatus getStatus() {
		return status;
	}

	public void setStatus(PlayerStatus status) {
		this.status = status;
	}

	public void setRank(int winnerPosition) {
		this.rank = winnerPosition;
	}


    public boolean isStillPlaying() {
        return this.getStatus() == PlayerStatus.Playing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

