
public class BoardObject {
	
	int head;
	int tail;
	
	public BoardObject() {
		
		Utility utility = new Utility();
		
		head = utility.generateRandomNo(100);
		while(head==0){
			head = utility.generateRandomNo(100);
		}
		tail = utility.generateRandomNo(head);
	}

}
