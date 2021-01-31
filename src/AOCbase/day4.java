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

        for(int i = 0; i < lines.size(); i++){
            if (lines.get(i).isBlank()){
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
            else if (lines.get(i).equals(lines.get(lines.size() - 1)) && !lines.get(i).isBlank()){
                String[] lineKeys = lines.get(i).split(" ");
                for(String part: lineKeys){
                    currentPassportKeys.add(part.split(":")[0]);
                }
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
                String[] lineKeys = lines.get(i).split(" ");
                for(String part: lineKeys){
                    currentPassportKeys.add(part.split(":")[0]);
                }
            }
        }
        System.out.println(ans);
        solve2();
    }

    void solve2(){

    }
}
