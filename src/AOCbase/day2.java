package AOCbase;

import java.io.IOException;

public class day2 extends AOCAssignmentBase{
    public day2(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {
        String[] splittedline;
        String[] minMax;
        char charLookUp;
        int min = 0,max = 0,check = 0,ans = 0;
        for (String line: lines) {
           splittedline = line.split(" ");
           minMax = splittedline[0].split("-");
           charLookUp = splittedline[1].charAt(0);
           min = Integer.parseInt(minMax[0]);
           max = Integer.parseInt(minMax[1]);

           for (char letter: splittedline[2].toCharArray()){
               if (letter == charLookUp){
                   check++;
               }
           }
           if (check >=min && check <=max){
               ans++;
           }
           check = 0;
        }
        System.out.println(ans);
    }
}