import java.util.*;

/**
* Solution for <a href="https://code.google.com/codejam/contest/90101/dashboard#s=p1">this</a> problem
* passed for small input, large input were failing
* Watersheds, Qualification Round GCJ 2009
*/
public class MainWatersheds{

	public static void main(String []args){
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		for (int ii = 1; ii <= T; ii++){
			int H,W;
			H = in.nextInt(); W = in.nextInt();
			int [][]map = new int[H][W];
			boolean [][]islabeled = new boolean[H][W];
			char [][]basin = new char[H][W];
            
            
            preprocess(map, islabeled);
            solve(map, islabeled, basin);
			
			//print
            System.out.println("Case #"+ii+":");
			for (int i = 0; i < H; i++){
				for(int j = 0; j < W; j++){
					if (j == 0)
						System.out.print(basin[i][j]);
					else System.out.print(" "+basin[i][j]);
				}
				System.out.println();
			}

		}
	}
    
    private static void preprocess(int [][]map, boolean [][]isLabeled){
        for(int i = 0; i < H; i++){
				for( int j = 0; j < W; j++){
					map[i][j] = in.nextInt();
				}
			}

        for (int i = 0; i < H; i++){
            Arrays.fill(isLabeled[i], false);
        }

    }
    
    private static void solve(int [][]map, boolean [][]islabeled, char [][]basin){
        int counter = 0;

			for(int i = 0; i < H; i++){
				for(int j = 0; j < W; j++){
					if (!islabeled[i][j]){
						int a = i, b = j;
						
						Vector<Integer> path = new Vector<Integer>();
						
						path.add(i * 10 + j);
						
						while(!islabeled[a][b]){
							islabeled[a][b] = true;
							basin[a][b] = (char)('a'+counter);

							boolean sinka = false,sinkb = false,sinkc = false,sinkd = false;
							int min = 11000;

							//current position

							/*check rule: North, West, East, South.*/

							//check issink
		
							boolean isSink = true;
							
							/*check north*/
							if (a - 1 >= 0){
								sinka = (map[a-1][b] >= map[a][b]);
								isSink = isSink && sinka;
							}

							/*check west*/
							if (b - 1 >= 0){
								sinkb = (map[a][b] <= map[a][b-1]);
								isSink = isSink && sinkb;
							}

							/*check east*/
							if (b + 1 < W ){
								sinkc = (map[a][b] <= map[a][b+1]);
								isSink = isSink && sinkc;
							}

							/*check south*/
							if (a + 1 < H ){
								sinkd = (map[a][b] <= map[a+1][b]);
								isSink = isSink && sinkd;
							}

							if (isSink){
								counter++;
								break;
							}

							//check flow

							/*check north*/
							if ((a - 1 >= 0) && (min >= map[a-1][b]))
								min = map[a-1][b];
							/*check west*/
							if ( (b-1 >= 0) && (min >= map[a][b-1]))
								min = map[a][b-1];
							/*check east*/
							if ( (b+1 < W) && (min >= map[a][b+1]))
								min = map[a][b+1];
							/*check south*/
							if ( (a+1 < H) && (min >= map[a+1][b]))
								min = map[a+1][b];

							int _a = a, _b = b;
							
                            //moving position
							/*check north*/
							if ( (a-1 >= 0) && (map[a-1][b] == min) )
								a--;
							/*check west*/
							else if ( (b-1 >= 0) && (min == map[a][b-1]) )
								b--;
							/*check east*/
							else if ( (b+1 < W) && (min == map[a][b+1]) )
								b++;
							/*check south*/
							else if ( (a+1 < H) && (min == map[a+1][b]) )
								a++;
					
							
							if (islabeled[a][b]){
								//System.out.println("islabeled! "+a+" "+b);
								for (int w = 0; w < path.size(); w++){
								    _a = path.get(w)/10; _b = path.get(w)%10;
									basin[_a][_b] = basin[a][b];
								}
								break;
							}
							path.add(a * 10 +b);
						}

					}

				}

			}       
    }

}