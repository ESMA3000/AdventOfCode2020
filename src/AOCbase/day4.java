package AOCbase;

import java.io.IOException;
import java.util.ArrayList;

public class day4 extends AOCAssignmentBase{
    public day4(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {
        int ans = 0;
        String[] validPassportKeys = new String[]{"byr","iyr","eyr","hgt","hcl","ecl","pid"};
        ArrayList<String> currentPassportKeys = new ArrayList<>();

        for(String line: lines){
            if (line.isBlank()){
                boolean validPassword = true;
                for (String key: validPassportKeys){
                    if (!currentPassportKeys.contains(key)){
                        validPassword = false;
                        break;
                    }
                }
                if (validPassword){
                    ans++;
                }
                currentPassportKeys.clear();
            }
            else{
                String[] lineKeys = line.split(" ");
                for(String part: lineKeys){
                    currentPassportKeys.add(part.split(":")[0]);
                }
            }
        }
        System.out.println(ans);
    }
}
