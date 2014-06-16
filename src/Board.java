



public class Board {
	String grid[][];
	String gridInList[];
	
	int snakesCount = 3;
	int laddersCount = 3;
	
	Snake[] snakes = new Snake[snakesCount];
	Ladder[] ladders = new Ladder[laddersCount];
	
	public Board() {
		this.gridInList = new String[100];
		for(int j=0;j<100;j++){
			gridInList[j] = String.valueOf(j+1);
		}
		
		//Initialising snakes and ladders on to this board
		for(int j=0;j<snakesCount;j++){
			snakes[j] = new Snake();
			ladders[j] = new Ladder();
			gridInList[snakes[j].headPosition] = "SH"+String.valueOf(j+1);
			gridInList[snakes[j].tailPosition] = "ST"+String.valueOf(j+1);
			gridInList[ladders[j].headPosition] = "LH"+String.valueOf(j+1);
			gridInList[ladders[j].tailPosition] = "LT"+String.valueOf(j+1);
			}
		
		this.grid = new String[10][10];		
		
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
			if(newPosition==snakes[i].headPosition){
				newPosition=snakes[i].tailPosition;
				break;
			}else if(newPosition==ladders[i].tailPosition){
				newPosition=ladders[i].headPosition;
			}
		}
		player.setPosition(newPosition);
		
	}
}
