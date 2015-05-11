/**
* @author Oscar Kurniawan Manule (0706272080)
* @version 1.0
* @date 11 Oktober 2009
*/

import java.util.ArrayList;

/**
* Class ini merepresentasikan objek sebuah state
* Terdiri dari tiga tuple yaitu:
* > jumlah missionaries di kiri
* > jumlah cannibals di kiri
* > posisi boat
* > informasi sisanya dapat diturunkan dari ketiga informasi diatas
*/
public class State {
  private int missionaries;
  private int cannibals;
  private String boatposition;
  public static final String LEFT_POSITION = "left";
  public static final String RIGHT_POSITION = "right";

  /**
  * Ini adalah constructor utama dan satu-satunya dari class State
  * @param missionaries merepresentasikan jumlah missionaries di kiri
  * @param cannibals merepresentasikan jumlah cannibals di kiri
  * @param boatposition merepresentasikan posisi boat sekarang
  * constructor ini akan membuat state awal dan state yang diekspansi berikutnya
  */
  public State(int missionaries, int cannibals, String boatposition) {
    this.missionaries = missionaries;
    this.cannibals = cannibals;
    this.boatposition = boatposition;
  }

  public int getMissionariesState() {
    return missionaries;
  }

  public int getCannibalsState() {
    return cannibals;
  }

  public String getBoatPosition() {
    return boatposition;
  }

  public String getOppositeBoatPosition() {
    if (this.getBoatPosition().equals(State.LEFT_POSITION)) {
      return State.RIGHT_POSITION;
    }
    else {
      return State.LEFT_POSITION;
    }
  }

  public boolean equals(Object o) {
    if (!(o instanceof State))
      return false; //bukan instance dari State berarti objek tidak sama

    State s = (State)o;

    if (s.getMissionariesState() == missionaries &&
        s.getCannibalsState() == cannibals &&
        s.getBoatPosition().equals(boatposition))
      return true; //objek State yang sama berarti semua fieldnya sama nilainya

    return false; // jika tidak memenuhi syarat sebelumnya kembalikan false
  }

  public String toString() {
    return "State: left missionaries";
  }

}
