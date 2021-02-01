package AOCbase;

import java.io.IOException;
import java.util.*;

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
                    if (checkKeyValue(part)){
                        currentPassportKeys.add(part.split(":")[0]);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    boolean checkKeyValue(String key){
        String[] eyeColour = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        String[] keySplit;
        keySplit = key.split(":");
        boolean isValid = false;
        boolean check = false;
        char[] valueSplit;

        switch (keySplit[0]){
            case "byr":
                if ((Integer.parseInt(keySplit[1]) >= 1920 || Integer.parseInt(keySplit[1]) <= 2002)
                        && keySplit.length == 4)
                    isValid = true;
                break;
            case "iyr":
                if ((Integer.parseInt(keySplit[1]) >= 2010 || Integer.parseInt(keySplit[1]) <= 2020)
                        && keySplit.length == 4)
                    isValid = true;
                break;
            case "eyr":
                if ((Integer.parseInt(keySplit[1]) >= 2020 || Integer.parseInt(keySplit[1]) <= 2030)
                        && keySplit.length == 4)
                    isValid = true;
                break;
            case "hgt":
                valueSplit = keySplit[1].toCharArray();
                for(char c: valueSplit){
                    if (c == 'i'){
                        if (Integer.parseInt(keySplit[1].split("i")[0]) >= 59
                                && Integer.parseInt(keySplit[1].split("i")[0]) <= 76)
                            isValid = true;
                    }
                    else if (c == 'c'){
                        if (Integer.parseInt(keySplit[1].split("c")[0]) >= 150
                                && Integer.parseInt(keySplit[1].split("c")[0]) <= 193)
                            isValid = true;
                    }
                }
                /*if (valueSplit[valueSplit.length - 1] == 'i'){
                    if (Integer.parseInt(keySplit[1]) >= 59 && Integer.parseInt(keySplit[1]) <= 76)
                        isValid = true;
                else if (valueSplit[valueSplit.length - 1] == 'c'){
                    if (Integer.parseInt(keySplit[1]) >= 150 && Integer.parseInt(keySplit[1]) <= 193)
                        isValid = true;
                    }*/
                break;
            case "hcl":
                valueSplit = keySplit[1].toCharArray();
                for (char c : valueSplit) {
                    if ((Character.isLetterOrDigit(c) || c == '#') && keySplit.length == 6) {
                        check = true;
                    } else {
                        check = false;
                        break;
                    }
                }
                if (check)
                    isValid = true;
                break;
            case "ecl":
                for(String color: eyeColour)
                    if (color.equals(keySplit[1])) {
                        isValid = true;
                        break;
                    }
                break;
            case "pid":
                valueSplit = keySplit[1].toCharArray();
                for (char c : valueSplit) {
                    if (Character.isDigit(c) && keySplit.length == 9) {
                        check = true;
                    } else {
                        check = false;
                        break;
                    }
                }
                if (check)
                    isValid = true;
                break;
        }
        return isValid;
    }
}
