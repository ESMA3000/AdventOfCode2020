package AOCbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class day3 extends AOCAssignmentBase{

    public day3(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {

        long FinalAnswer = Travel(1,1) * Travel(3, 1) * Travel(5, 1) * Travel(7, 1) * Travel(1,2);

        System.out.format("All trees hit on all slopes multiplied: %d", FinalAnswer);
    }

    long Travel(int right, int down){

        ArrayList<String> Map = lines;
        int TreeCounter = 0;
        int Step = 0;

        for(int i = down; i < Map.size(); i += down){

            String Path = Map.get(i);
            char[] Position = Path.toCharArray();

            Step+=right;

            if(Step > Path.length()-1){
                Step = Step-Path.length();
            }

            if(Position[Step] == '#'){

                TreeCounter++;
                Position[Step] = 'X';

            } else Position[Step] = 'O';

            //System.out.println(Position);
        }
        System.out.format("Right: %d Down: %d Trees: %d%n", right, down, TreeCounter);
        return TreeCounter;
    }
}
