import aima.search.csp.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ProcSchedule extends CSP{
	public static String T1 = "T1";
	public static String T2 = "T2";
	public static String T3 = "T3";
	public static String T4 = "T4";
	public static String T5 = "T5";
	public static String T6 = "T6";
	public static String T7 = "T7";

	private MapCSP(List<String> variables, Constraint constraints) {
		super(variables, constraints);

	}

	public static CSP getMap() {
		List<String> variables = new ArrayList<String>();
		variables.add(T1);
		variables.add(T2);
		variables.add(T3);
		variables.add(T4);
		variables.add(T5);
		variables.add(T6);
		variables.add(T7);

		List<String> colors = new ArrayList<String>();
		colors.add(RED);
		colors.add(BLUE);
		colors.add(GREEN);

		Domain domains = new Domain(variables);
		for (int i = 0; i < variables.size(); i++) {
			String variable = variables.get(i);
			domains.addToDomain(variable, colors);
		}

		Hashtable<String, List<String>> neighbors = new Hashtable<String, List<String>>();
		addToNeighbors(neighbors, T1,T4,T5);
		addToNeighbors(neighbors, T2,T6,T7);
		addToNeighbors(neighbors, NT, WA, SA, Q);
		addToNeighbors(neighbors, SA, WA, NT, Q, NSW, V);
		addToNeighbors(neighbors, Q, NT, SA, NSW);
		addToNeighbors(neighbors, NSW, SA, Q, V);
		addToNeighbors(neighbors, V, SA, NSW);
		Constraint mapConstraints = new MapColoringConstraint(neighbors);

		return new CSP(variables, mapConstraints, domains);
	}

}