/**
* @author Oscar Kurniawan Manule (0706272080)
* @version 1.0
* @date 11 Oktober 2009
*/
public class Action {

	private String action;

	public Action(String action) {
		this.action = action;
	}

	public int cost() {
		return 1;
	}

	public String getAction() {
		return action;
	}


}
