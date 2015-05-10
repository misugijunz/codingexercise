import java.util.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class GCJTemplate{
	private final static String PROBLEM_NAME = "PROBLEM";
	private final static String FILE_LOC = "/";
	private final static String FILE_INPUT_NAME = "file.in";
	private final static Strinf FILE_OUTPUT_NAME = "file.out";
	private Scanner sc;
	private PrintWritter pw;
	
	public GCJTemplate(){
		sc = new Scanner(new FileReader(FILE_LOC + FILE_INPUT_NAME));
		pw = new PrintWriter(new FileWriter(FILE_LOC + FILE_OUTPUT_NAME));
	}
	
	public static void main(String []args){
		GCJTemplate template = new GCJTemplate();
		template.preprocess();
		template.solve();
	}
	
	private void preprocess(){
		//placeholder used for preprocessing some data helpers/informations	
	}
	
	private void solve(){
		//placeholder used for solving the problem
	}

}