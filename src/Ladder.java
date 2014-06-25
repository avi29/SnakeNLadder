
public class Ladder extends BoardObject{

	@Override
	void reachFinalPosition(Player player) {
		if(player.getPosition()==tail)
			player.setPosition(head);
	}
}
