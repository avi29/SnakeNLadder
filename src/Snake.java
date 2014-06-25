
public class Snake extends BoardObject{

	@Override
	void reachFinalPosition(Player player) {
		if(player.getPosition()==head)
			player.setPosition(tail);
	}
}
