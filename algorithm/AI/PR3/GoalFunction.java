/**
* @author Oscar Kurniawan Manule (0706272080)
* @version 1.0
* @date 13 Oktober 2009
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


public class GoalFunction<State>{

      State goalstate;

      public static int MAX_CANNIBALS;
      public static int MAX_MISSIONARIES;


      public GoalFunction(State goalstate, int maxcannibals, int maxmissionaries) {
          this.goalstate = goalstate;
          this.MAX_CANNIBALS = maxcannibals;
          this.MAX_MISSIONARIES = maxmissionaries;
      }

      public boolean isGoalState(State test) {
          return this.goalstate.equals(test);
      }

}
