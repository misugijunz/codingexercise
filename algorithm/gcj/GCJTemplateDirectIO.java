import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GCJTemplateDirectIO{
	private BufferedReader br;
	
	public GCJTemplateDirectIO(){
		br = new BufferedReader(new InputStreamReader(System.in));
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
		try{
			//must be called under try catch
			String input[] = br.readLine().split(" ");	
		}
		catch(IOException ioe){
			//catch the exception
		}
	}

}