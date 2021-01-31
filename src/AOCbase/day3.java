package AOCbase;

import java.io.IOException;

public class day3 extends AOCAssignmentBase{
    public day3(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {
        char[] route;
        int ans = 0, j = 3, maxLength;
        for (int i = 1; i < lines.size(); i++){
            route = lines.get(i).toCharArray();
            maxLength = route.length - 1;
            if(route[j] == '#'){
                ans++;
            }
            if (j+3 <= maxLength){
                j+=3;
            }
            else if (j+3 > maxLength){
                j = 3 - (maxLength - j) - 1;
            }
        }
        System.out.println("Part 1: " + ans);
        solve2();
    }
    void solve2(){
        int ans = 0;
        ans = SlopeCalc(1,1);
        ans *= SlopeCalc(3,1);
        ans *= SlopeCalc(5,1);
        ans *= SlopeCalc(7,1);
        ans *= SlopeCalc(1,2);
        System.out.println("Part 2: " + ans);

    }

    int SlopeCalc(int right, int down) {
        char[] route;
        int ans = 0, maxLength;
        int j = right;
        for (int i = down; i < lines.size(); i+=down){
            route = lines.get(i).toCharArray();
            maxLength = route.length - 1;
            if(route[j] == '#'){
                ans++;
            }
            if (j+right <= maxLength){
                j+=right;
            }
            else if (j+right > maxLength){
                j = right - (maxLength - j) - 1;
            }
        }
        return ans;
    }

}
