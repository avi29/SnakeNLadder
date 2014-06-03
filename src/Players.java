
public class Players {
	int playersCount;
	int[] playersPostion;
	String[] playersStatus;
	int[] winnersOrder;
	int winnersCount;
	
	public Players(int playersCount) {
		this.playersCount = playersCount;
		this.playersPostion = new int[playersCount];
		this.playersStatus = new String[playersCount];
		this.winnersOrder = new int[playersCount];
		for(int i=0;i<playersCount;i++){
			playersStatus[i]="playing";
			playersPostion[i] = -1;
		}
		winnersCount = 0;
	}

	
	public boolean userGameCompleted(int i) {
		boolean status = false;
		if(playersPostion[i]==(99)){
			status = true;
			winnersCount++;	
			playersStatus[i] = "completed";
			winnersOrder[i] = winnersCount;
			playersPostion[i] = 100;
			
		}
		return status;
	}

	public boolean gameCompleted() {
		boolean status = false;
		if(winnersCount==playersCount-1){
			status = true;
		}
		return status;
	}

	
}
