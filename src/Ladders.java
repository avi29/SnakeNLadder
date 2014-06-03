
public class Ladders {

	int[] headPositions;
	int[] tailPositions;
	
	public Ladders() {
		headPositions = new int[3];
		tailPositions = new int[3];
		Utility utility = new Utility();
		
		for(int i=0;i<3;i++){
		headPositions[i] = utility.generateRandomNo(100);
		while(headPositions[i]==0){
			headPositions[i] = utility.generateRandomNo(100);
		}
		tailPositions[i] = utility.generateRandomNo(headPositions[i]);
		}
	}
}
