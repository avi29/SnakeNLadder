
public class BoardObject {
	
	int[] head;
	int[] tail;
	
	public BoardObject() {
		head = new int[3];
		tail = new int[3];
		Utility utility = new Utility();
		
		for(int i=0;i<3;i++){
		head[i] = utility.generateRandomNo(100);
		while(head[i]==0){
			head[i] = utility.generateRandomNo(100);
		}
		tail[i] = utility.generateRandomNo(head[i]);
		}
	}

}
