

public class Board {
	String grid[][];
	String gridInList[];
	
	Snakes snakes;
	Ladders ladders;
	
	public Board() {
		this.gridInList = new String[100];
		for(int j=0;j<100;j++){
			gridInList[j] = String.valueOf(j+1);
		}
		
		snakes = new Snakes();
		ladders = new Ladders();
		initializeSnLOnBoard();
		this.grid = new String[10][10];		
		
	}
	
	//Initialising snakes and ladders on to this board
	private void initializeSnLOnBoard() {
		for(int y=0;y<snakes.headPositions.length;y++){
			gridInList[snakes.headPositions[y]] = "SH"+String.valueOf(y+1);
			gridInList[snakes.tailPositions[y]] = "ST"+String.valueOf(y+1);
			gridInList[ladders.headPositions[y]] = "LH"+String.valueOf(y+1);
			gridInList[ladders.tailPositions[y]] = "LT"+String.valueOf(y+1);
		}
	}

	public void showBoard(Player[] players){
		int k = 0;
		for(int i=9;i>-1;i--){
			if(i%2==1){
			for(int j=0;j<10;j++){
				grid[i][j]=gridInList[k];
				for(int x=0;x<players.length;x++){
					if(players[x].getPosition()==k){
						grid[i][j] = "P"+String.valueOf(x+1)+grid[i][j];
					}
				}
				k++;
			}
			}else{
				for(int j=9;j>-1;j--){
					grid[i][j]=gridInList[k];
					for(int x=0;x<players.length;x++){
						if(players[x].getPosition()==k){
							grid[i][j] = "P"+String.valueOf(x+1)+grid[i][j];
						}
					}
					k++;
				}
			}
		}
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(grid[i][j].length()>5){
					grid[i][j] = grid[i][j].substring(0, 5);
				}
				System.out.print(grid[i][j]);
				System.out.print(" ");
				if(grid[i][j].length()<5){
					int x = 0;
					while((grid[i][j].length()+x)!=5){
						System.out.print(" ");
						x++;
					}
				} 
			}
			System.out.println();
		}
	}
	

	public void processMove(Player player, int move) {
		int initialPosition = (player.getPosition());
		int newPosition = initialPosition + move;
		if(initialPosition==-1&&(move!=1&&move!=6)){
			newPosition = initialPosition;
		}
		if(newPosition>99)newPosition = initialPosition;
		for(int i=0;i<3;i++){
			if(newPosition==snakes.headPositions[i]){
				newPosition=snakes.tailPositions[i];
				break;
			}else if(newPosition==ladders.tailPositions[i]){
				newPosition=ladders.headPositions[i];
			}
		}
		player.setPosition(newPosition);
		
	}
}
