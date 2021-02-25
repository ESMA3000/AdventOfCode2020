package AOCbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class day4 extends AOCAssignmentBase{

    public day4(String day) throws IOException, IOException {
        super(day);
    }

    @Override
    void solve() {

        ArrayList<String> ValidPassportList = new ArrayList<>();
        ArrayList<String> PassportList = SortToOneString(lines);
        System.out.format("Passport in the system: %d%n", PassportList.size());

        for (String Passport : PassportList) {

            Boolean[] Check = {true, false, false, false, false, false, false, false};
            String[] Validation = Passport.split(" ");

            for (String ObjectString : Validation) {

                if (ObjectString.contains("byr")) {

                    String[] temp = ObjectString.split(":");

                    if (Integer.parseInt(temp[1]) >= 1920 && Integer.parseInt(temp[1]) <= 2002 && temp[1].length() == 4) {
                        Check[4] = true;
                    }
                }
                if (ObjectString.contains("iyr")) {

                    String[] temp = ObjectString.split(":");

                    if (Integer.parseInt(temp[1]) >= 2010 && Integer.parseInt(temp[1]) <= 2020 && temp[1].length() == 4) {
                        Check[2] = true;
                    }
                }
                if (ObjectString.contains("eyr")) {

                    String[] temp = ObjectString.split(":");

                    if (Integer.parseInt(temp[1]) >= 2020 && Integer.parseInt(temp[1]) <= 2030 && temp[1].length() == 4) {
                        Check[3] = true;
                    }
                }
                if (ObjectString.contains("hgt")) {

                    String[] temp = ObjectString.split(":");

                    if (temp[1].contains("cm")) {
                        String[] CM = temp[1].split("cm");
                        if (Integer.parseInt(CM[0]) >= 150 && Integer.parseInt(CM[0]) <= 193) {
                            Check[5] = true;
                        }
                    }

                    else if (temp[1].contains("in")) {
                        String[] In = temp[1].split("in");
                        if (Integer.parseInt(In[0]) >= 59 && Integer.parseInt(In[0]) <= 76) {
                            Check[5] = true;
                        }
                    }
                }
                if (ObjectString.contains("hcl") && ObjectString.contains("#")) {

                    String[] temp = ObjectString.split("#");
                    if (temp[1].matches("[0-9a-f]{6}")) {
                        Check[6] = true;
                    }
                }
                if (ObjectString.contains("ecl")) {

                    String[] HairColors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
                    String[] temp = ObjectString.split(":");

                    for (String Color : HairColors) {

                        if (temp[1].equals(Color)) {

                            Check[7] = true;
                            break;
                        }
                    }
                }
                if (ObjectString.contains("pid")) {

                    String[] PID = ObjectString.split(":");
                    if (PID[1].matches("[0-9]{9}")) {

                        Check[1] = true;
                    }
                }
                if (ObjectString.contains("cid")) {
                    Check[0] = true;
                }

            }

            if (Arrays.stream(Check).allMatch(Boolean.TRUE::equals)) {

                ValidPassportList.add(Passport);
            }
        }
        /*for(int i = 0; i < ValidPassportList.size(); i++){
            System.out.println(ValidPassportList.get(i));
        }*/
        System.out.format("Valid Passports: %d%n", ValidPassportList.size());
    }

    ArrayList<String> SortToOneString (ArrayList<String> PassportList) {

        ArrayList<String> PassportsSorted = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (String Passport : PassportList) {

            temp.append(Passport);
            temp.append(" ");

            if (Passport.equals("")) {

                PassportsSorted.add(temp.toString());
                temp.setLength(0);
            }
        }
        return PassportsSorted;
    }
}
