/**
* @author Oscar Kurniawan Manule (0706272080)
* @version 1.0
* @date 11 Oktober 2009
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


public class Node<State> {

	private State state;
	private Node parent;
	private Action act;
	private int pathcost;
	private int depth;

	public Node(State state) {

		this.state = state;
		this.parent = null;
		this.act = new Action("Initial State");
		this.pathcost = 0;
		this.depth = 0;

	}

	public Node(Node parent, State state, Action act) {

		this.parent = parent;
		this.state = state;
		this.act = act;
		this.pathcost = parent.getPathCost() + act.cost();
		this.depth = parent.getDepth() + 1;

	}

	public State getData() {

			return state;
	}

	public int getPathCost() {

			return pathcost;
	}

	public int getDepth() {

			return depth;
	}

	public void printBackTrack() {
			if (parent != null)
				parent.printBackTrack();
			System.out.println("   " + depth + ". " + act + " ---> " + state);
	}

	public ArrayList<Node<State>> getSuccessorStates(Node<State> par) {

			/*
			 * possible move any condition, test all!
			 * add 2 missionaries --> 1st condition
			 * add 2 kannibal --> 2nd condition
			 * add 1 missionaries --> 3rd condition
			 * add 1 kannibal --> 4th condition
			 * add 1 missionaries dan 1 kannibal --> 5th condition
			 */

			ArrayList<Node<State>> successors = new ArrayList<Node<State>>();

			State pr = par.getData();

			int rc = pr.getCannibalsState();
			int rm = pr.getMissionariesState();
			int lc = GoalFunction.MAX_CANNIBALS - rc;
			int lm = GoalFunction.MAX_MISSIONARIES - rm;

			State temp;
			Node<State> node;

			if (pr.getBoatPosition().equals(State.LEFT_POSITION)) {

				  if (rm + 2 <= GoalFunction.MAX_CANNIBALS && rc <= rm + 2 && lc  <= lm - 2) {
					  temp = new State(rm + 2, rc, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("Two Missionaries sail to right side"));
					  successors.add(node);
				  }

				  if (rc + 2 <= GoalFunction.MAX_CANNIBALS && rc + 2 <= rm && lc - 2  <= lm) {
					  temp = new State(rm, rc + 2, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("Two Cannibals sail to right side"));
					  successors.add(node);
				  }

				  if (rm + 1 <= GoalFunction.MAX_MISSIONARIES && rc <= rm + 1 && lc <= lm - 1) {
					  temp = new State(rm + 1, rc, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("One Missionaries sail to right side"));
					  successors.add(node);
				  }

				  if (rc + 1 <= GoalFunction.MAX_CANNIBALS && rc + 1 <= rm && lc - 1  <= lm) {
					  temp = new State(rm, rc + 1, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("Two Cannibals sail to right side"));
					  successors.add(node);
				  }

				  if (rm + 1 <= GoalFunction.MAX_MISSIONARIES && rc + 1 <= GoalFunction.MAX_CANNIBALS &&
						rc + 1 <= rm + 1 && lc - 1 <= lm - 1) {

					  temp = new State(rm + 1, rc + 1, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("One Missionaries sail to right side"));
					  successors.add(node);
				  }
			}
			else {


				if (rm - 2 <= GoalFunction.MAX_CANNIBALS && rc <= rm - 2 && lc  <= lm + 2) {
					  temp = new State(rm - 2, rc, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("Two Missionaries sail to right side"));
					  successors.add(node);
				}

				if (rc - 2 <= GoalFunction.MAX_CANNIBALS && rc - 2 <= rm && lc + 2  <= lm) {
					  temp = new State(rm, rc - 2, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("Two Cannibals sail to right side"));
					  successors.add(node);
				}

				if (rm - 1 <= GoalFunction.MAX_MISSIONARIES && rc <= rm - 1 && lc <= lm + 1) {
					  temp = new State(rm - 1, rc, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("One Missionaries sail to right side"));
					  successors.add(node);
				}

				if (rc - 1 <= GoalFunction.MAX_CANNIBALS && rc - 1 <= rm && lc + 1  <= lm) {
					  temp = new State(rm, rc - 1, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("Two Cannibals sail to right side"));
					  successors.add(node);
				}

				if (rm - 1 <= GoalFunction.MAX_MISSIONARIES && rc - 1 <= GoalFunction.MAX_CANNIBALS &&
					  rc - 1 <= rm - 1 && lc + 1 <= lm + 1) {

					  temp = new State(rm - 1, rc - 1, pr.getOppositeBoatPosition());
					  node = new Node<State>(par, temp, new Action("One Missionaries sail to right side"));
					  successors.add(node);
				}
			}

			return successors;
	}

	public boolean depthFirstSearch(Node<State> start, Stack<Node<State>> results,
			ArrayList<Node<State>> visited, GoalFunction gf) {

			if (visited.contains(node)) {
				return false;
			}

			visited.add(start);

			results.push(start);

			if (gf.isGoalState(start)) {
				return true;
			}

			for (Node<State> v: start.getSuccessorStates(start.getData())) {
				depthFirstSearch(v,results,visited,gf);
			}

			results.pop(start);

			return false;

	}

	public boolean equals(Object o) {
			if (!(o instanceof Node)) {
				return false;
			}
			Node<State> s = (Node<State>)o;
			return this.getData().equals(s.getData());
	}
}
