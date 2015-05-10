import java.io.*;
import java.util.regex.*;

/**
* Solution for <a href="https://code.google.com/codejam/contest/90101/dashboard">this</a> problem
* passed for both small and large inputs
* Alien Language, Qualification Round GCJ 2009
*/
public class MainAlienLanguage{

	public static void main(String []args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			String input[] = br.readLine().split(" ");
			int L,D,N;
			L = Integer.parseInt(input[0]);
			D = Integer.parseInt(input[1]);
			N = Integer.parseInt(input[2]);
			
			String words[] = new String[D];
			
			for(int i=0; i < D; i++){
				words[i] = br.readLine();
			}
			//the strategy for this problem is to build regular expression pattern
            //against the alien words and search the matched words
			for (int i=0; i < N; i++){
				int counter = 0;
				String regex = br.readLine();
				StringBuffer sb = new StringBuffer();
				for (int k = 0; k < regex.length(); k++){
					if (regex.charAt(k)=='(')
						sb.append('[');
					else if (regex.charAt(k) == ')')
						sb.append(']');
					else sb.append(regex.charAt(k));
				}
				regex = sb.toString();
				//System.out.println(regex);
				Pattern p = Pattern.compile(regex);
				for (int j = 0; j < D; j++){
					Matcher m = p.matcher(kata[j]);
					//System.out.println(m.pattern().toString());
					if (m.find())
						counter++;
				}
				System.out.println("Case #"+(i+1)+": "+counter);
			}
		}
		catch(IOException ioe){}
	}

}