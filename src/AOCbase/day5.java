package AOCbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day5 extends AOCAssignmentBase{

    public day5(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {
        ArrayList<String> AllBoardingPasses = lines;
        Integer[] SeatID = new Integer[AllBoardingPasses.size()];
        int Index = 0;

        for(String BoardingPass : AllBoardingPasses){

            int MaxRow = 127;
            int MinRow = 0;
            int MaxCol = 7;
            int MinCol = 0;
            char[] ObjectString = BoardingPass.toCharArray();

            for (int i = 0; i < ObjectString.length-2; i++){

                switch (ObjectString[i]) {
                    case ('F') -> MaxRow = MaxRow-((MaxRow - MinRow) / 2) - 1;
                    case ('B') -> MinRow = MinRow+((MaxRow - MinRow) / 2) + 1;
                }
            }

            for (int i = 7; i < ObjectString.length; i++){

                switch (ObjectString[i]) {
                    case ('L') -> MaxCol = MaxCol-((MaxCol - MinCol) / 2) - 1;
                    case ('R') -> MinCol = MinCol+((MaxCol - MinCol) / 2) + 1;
                }
            }

            SeatID[Index] = MinRow * 8 + MinCol;
            Index++;
        }

        Arrays.sort(SeatID);
        int MySeatID = SeatID[SeatID.length-1];
        List<Integer> SeatList = new ArrayList<>(Arrays.asList(SeatID));

        System.out.format("Total Boarding passes: %d%n", AllBoardingPasses.size());

        /*for(int x : SeatList){
            System.out.format("SeatID: %d%n", x);
        }*/

        while (SeatList.contains(MySeatID)){
            MySeatID--;
        }
        System.out.format("My SeatID: %d%n", MySeatID);
    }
}
