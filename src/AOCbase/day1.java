package AOCbase;

import com.sun.jdi.IntegerType;

import java.io.IOException;
import java.util.ArrayList;

public class day1 extends AOCAssignmentBase {

    public day1(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {

        final int RightSum = 2020;
        int[] IntArray = StringToInt(lines);

        for (int i = 0; i < IntArray.length; i++){

            for (int j = IntArray.length - 1; j > i; j--){

                for (int value : IntArray){

                    if (IntArray[i] + IntArray[j] + value == RightSum) {

                        int FinalAnswer = IntArray[i] * IntArray[j] * value;
                        System.out.format("%d + %d + %d = %d%n", IntArray[i], IntArray[j], value, RightSum);
                        System.out.format("%d * %d * %d = %d%n", IntArray[i], IntArray[j], value, FinalAnswer);
                        System.out.format("It took %d attempts%n", i);

                        break;
                    }
                }
            }
        }
    }

    int[] StringToInt(ArrayList<String> StringList){

        int[] IntArray = new int[StringList.size()];

        for(int i = 0; i < StringList.size(); i++){

            IntArray[i] = Integer.parseInt(StringList.get(i));
        }
        return IntArray;
    }
}
