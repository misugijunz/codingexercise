/**
* @author modified and understood by Oscar Kurniawan Manule (0706272080)
* 
*/

import java.util.Vector;
import java.util.Stack;
import java.util.Scanner;

/**
* Kelas utama yang merepresentasikan masalah Missionaris dan Cannibals
*/
public class MandC {
	
	/** objek yang akan dijadikan sebagai state awal dari masukkan user*/
   static State initial_state;
   
   /**
   * Method utama
   * @param args Menyimpan argumen dari user
   */
   public static void main(String[] args) {
      
	  int nc = 0,nm = 0; // variabel untuk menyimpan jumlah awal kanibal dan misionaris
	  
	  /*jika program dijalankan tanpa argumen akan diberikan petunjuk cara mengoperasikan kemudian program terminate*/
      if (args.length == 0) {
		System.out.println("Masukkan jumlah missionaries dan cannibals dalam format:");
		System.out.println("nama_program jumlah_missionaries jumlah_cannibals");
		try {
			Thread.sleep(200);
		}
		catch (Exception e) { }
		return;
	  }
	  /*jika program dijalankan dengan dua argumen sesuai petunjuk, nilai dari argumen disimpan program*/
	  else if (args.length == 2) {
		nm = Integer.parseInt(args[0]);
		nc = Integer.parseInt(args[1]);
	  }
	  /*jika user asal masukkan argumen yang tidak benar*/
	  else {
		System.out.println("\n\nAnda tidak memasukkan input dalam format yang benar!");
		System.out.println("Program akan dihentikan.");
		try {
			Thread.sleep(200);
		}
		catch (Exception e) { }
		return;
	  }
	  /*jika argumen yang dimasukkan ternyata jumlah missionaries lebih kecil dari jumlah kanibal*/
	  if (nm < nc) {
		System.out.println("Anda memasukkan kondisi yang tidak mungkin");
		System.out.println("Missionaries anda telah dimakan bwahahahahah");
		try {
			Thread.sleep(200);
		}
		catch (Exception e) { }
		return;
	  }
	  
	  initial_state = new State(nm, nc, 'L', 0, 0); //menginisialisasi state awal sesuai argumen yang dimasukkan
	  
	  Node node = solveByDFS( initial_state ); //memanggil method yang melakukan pencarian dengan metode DFS berdasarkan state awal
	  /*var node tidak terinisialisasi dengan node yang merepresentasikan goal state*/
      if (node == null)
         System.out.println("Solusi tidak tersedia."); //cetak keterangan solusi tidak tersedia
      else {
         System.out.println("Solusinya adalah:\n"); // jika var node terinisialisasikan dengan Node yang merepresentasikan goal state
         node.printBackTrace(); // cetak laporan dari root sampai node goal state
      }
      System.out.println();
   }
   
   /**
	* Kelas dalam yang merepresentasikan sebuah state dalam masalah Missionaris dan Cannibals
	*/
   static class State {
      int ml, cl;  // missionaris dan kanibal di kiri
      int mr, cr;  // mssionaris dan kanibal di kanan
      char boat;   // posisi perahu, 'L' atau 'R'
	  
	  /**
	  * Konstruktor dari objek state dengan 5 tuple
	  * @param ml jumlah missionaris di kiri
	  * @param cl jumlah kanibal di kiri
	  * @param boat sebuah karakter yang berisi 'L' atau 'R' yang menyatakan posisi perahu sekarang
	  * @param mr posisi missionaris di kanan
	  * @param cr posisi kanibal di kanan
	  */
      public State(int ml, int cl, char boat, int mr, int cr) {
         this.ml = ml;
         this.cl = cl;
         this.boat = boat;
         this.mr = mr;
         this.cr = cr;
      }
	  
	  /**
	  * Method yang digunakan untuk mengecek apakah telah sampai pada goal state
	  * @return true jika state adalah goal test selain itu kembalikan false
	  */
      public boolean goal_test() {
         return ml == 0 && cl == 0;
      }
	  
	  /**
	  * Method yang digunakan untuk mencetak tuple suatu state
	  * @return String bentukan tuple suatu state
	  */
	  @Override
      public String toString() {
         return "(" + ml + " " + cl + " " + boat + " " + mr + " " + cr + ")";
      }
	  
	  /**
	  * Method yang digunakan untuk mengecek apakah dua objek State adalah sama atau tidak
	  * @return boolean true jika suatu objek state sama secara definisi selain itu false
	  */
	  @Override
      public boolean equals(Object obj) {
         if ( ! (obj instanceof State) )
            return false;
         State s = (State)obj;
         return (s.ml == ml && s.cl == cl && s.boat == boat
                       && s.cr == cr && s.mr == mr);
      }
	  
	  /**
	  * Sebuah method fungsi yang mengekspand state - state selanjutnya dari parent state
	  * @return sebuah object Vector yang berisi sebuah state beserta actionnya yang terekspansi
	  */
      public Vector<StateActionPair> successor_function() {
         Vector<StateActionPair> v = new Vector<StateActionPair>();
         if (boat == 'L') {
            testAndAdd(v,new StateActionPair(
                          new State(ml-2,cl,'R',mr+2,cr),
                          new Action("Dua missionaris menyebrang dari kiri ke kanan.")));
            testAndAdd(v,new StateActionPair(
                          new State(ml,cl-2,'R',mr,cr+2),
                          new Action("Dua kanibal menyebrang dari kiri ke kanan.")));
            testAndAdd(v,new StateActionPair(
                          new State(ml-1,cl-1,'R',mr+1,cr+1),
                          new Action("Satu missionaris dan satu kanibal menyebrang dari kiri ke kanan.")));
            testAndAdd(v,new StateActionPair(
                          new State(ml-1,cl,'R',mr+1,cr),
                          new Action("Satu missionaris menyebrang dari kiri ke kanan.")));
            testAndAdd(v,new StateActionPair(
                          new State(ml,cl-1,'R',mr,cr+1),
                          new Action("Satu kanibal menyebrang dari kiri ke kanan.")));
         }
         else {
            testAndAdd(v,new StateActionPair(
                          new State(ml+2,cl,'L',mr-2,cr),
                          new Action("Dua missionaries menyebrang dari kanan ke kiri.")));
            testAndAdd(v,new StateActionPair(
                          new State(ml,cl+2,'L',mr,cr-2),
                          new Action("Dua kanibal menyebrang dari kanan ke kiri.")));
            testAndAdd(v,new StateActionPair(
                          new State(ml+1,cl+1,'L',mr-1,cr-1),
                          new Action("Satu missionaries dan satu kanibal menyebrang dari kanan ke kiri.")));
            testAndAdd(v,new StateActionPair(
                          new State(ml+1,cl,'L',mr-1,cr),
                          new Action("Satu missionaries menyebrang dari kanan ke kiri.")));
            testAndAdd(v,new StateActionPair(
                          new State(ml,cl+1,'L',mr,cr-1),
                          new Action("Satu kanibal menyebrang dari kanan ke kiri.")));
         }
         return v;
      }
	  
	  /**
	  * Sebuah method yang mengecek apakah suatu state melanggar pembatas yang ditentukan atau tidak
	  * jika tidak melanggar masukkan kedalam vector kumpulan state-state yang dapat diekspansi
	  */
      private void testAndAdd(Vector<StateActionPair> v, StateActionPair pair) {
         State state = pair.state;
         if (state.ml >= 0 && state.mr >= 0 && state.cl >= 0 && state.cr >= 0
               && (state.ml == 0 || state.ml >= state.cl)
               && (state.mr == 0 || state.mr >= state.cr))
            v.addElement(pair);
      }
   } // akhir kelas State
   
	/**
	* Kelas dalam yang merepresentasikan sebuah action dalam suatu state dalam masalah Missionaris dan Cannibals
	*/
   static class Action {
	  /** variabel text untuk menyimpan action yang dilakukan state dalam objek ini*/
      String text;
	  
	  /**
	  * Konstuktr objek Action
	  * @param text Keterangan action yang disimpan dalam objek ini
	  */
      public Action(String text) {
         this.text = text;
      }
	  
	  /**
	  * Representasi String dari objek ini
	  * @return text Keterangan action yang disimpan dalam objek ini
	  */
      public String toString() {
         return text;
      }
	  
	  /**
	  * Representasi cost traverse dari parent state ke child state
	  * @return double nilai cost dari traverse
	  */
      public double cost() {
         return 1;
      }
   }
	
   /**
	* Kelas dalam yang merepresentasikan sebuah pair dari action dan state dalam suatu state dalam masalah Missionaris dan Cannibals
	*/
   static class StateActionPair {
	  /** State yang dipair dengan suatu action*/
      public State state;
	  /** Action yang dipair dengan suatu State*/
      public Action action;
	  
	  /**
	  * Konstruktor yang membentuk pair antara suatu State dengan suatu Action
	  * @param state yang akan di pair
	  * @param action yang akan di pair
	  */
      public StateActionPair(State state, Action action) {
         this.state = state;
         this.action = action;
      }
   }
   
	/**
	* Kelas dalam yang merepresentasikan sebuah Node pada tree pencarian dalam masalah Missionaris dan Cannibals
	*/
   static class Node {
      public State state;
      public Node parent_node;
      public Action action;
      public double path_cost;
      public int depth;
	  
	  /**
	  * Konstruktor untuk membuat root node
	  * @param state dari state awal
	  */
      public Node(State state) {
         this.state = state;
         parent_node = null;
         action = new Action("State awal");
         path_cost = 0;
         depth = 0;
      }
	  
	  /**
	  * Konstruktor untuk membuat sebuah node selain node awal
	  * @param state yang diwakili oleh node ini
	  * @param parent node parent dari node ini
	  * @param action action dari sebuah state node
	  */
      public Node(State state, Node parent, Action action) {
         this.state = state;
         this.parent_node = parent;
         this.action = action;
         this.path_cost = action.cost() + parent.path_cost;
         this.depth = 1 + parent.depth;
      }
	  
	  /**
	  * Method yang akan mencetak jalur dari parent ke goal node/state secara rekursif
	  */
      public void printBackTrace() {
         if (parent_node != null)
            parent_node.printBackTrace();
         System.out.println("   " + depth + ". " + action + " ---> " + state);
      }
   }
   
   /**
   * Method utama untuk search goal state secara DFS menggunakan implementasi Stack
   * method ini mencatat state yang dikunjungi agar tidak terjadi infinite loop (cycle trap)
   * @param initial_state state awal sebagai tree
   * @return node yang dicari (goal node) akan tetapi kembalikan null jika goal node tidak ketemu
   */
   public static Node solveByDFS(State initial_state) {
      Stack<Node> fringe = new Stack<Node>(); //untuk menyimpan node-node yang akan dikunjungi secara DFS
      Vector<State> visited = new Vector<State>(); //untuk menyimpan node-node yang sudah dikunjungi
      fringe.push( new Node(initial_state) );
      while ( true ) {
         if (fringe.isEmpty())//goal node tidak ketemu
            return null;
         Node node = fringe.pop(); //pop yang paling atas untuk ditraverse kembali childnya 
         Vector successors = node.state.successor_function(); //cari semua childny ayang mungkin
         for (int i = 0; i < successors.size(); i++) {
            StateActionPair successor = (StateActionPair)successors.elementAt(i);
            if ( ! containsState(visited,successor.state) ) {
               Node newNode = new Node(successor.state,node,successor.action);
               if (successor.state.goal_test())
                  return newNode; //tes apakah childnya merupakan goal node
               fringe.push(newNode);
               visited.add(successor.state);
            }
         }
      }
   }
   
   /**
   * Method utama untuk search apakah state yang dites pernah dikunjungi apa tidak
   * method ini untuk mengetes  cycle trap
   * @param visitedStates koleksi state-state yang pernah dikunjungi
   * @param state yang akan di tes
   * @return boolean true jika state yang dites sudah pernah dikunjungi sebaliknya false
   */
   public static boolean containsState(Vector visitedStates, State state) {
      for (int i = 0; i < visitedStates.size(); i++) {
         if (visitedStates.elementAt(i).equals(state))
            return true;
      }
      return false;
   }

}
