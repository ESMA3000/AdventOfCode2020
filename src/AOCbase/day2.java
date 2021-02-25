package AOCbase;

import org.w3c.dom.css.Counter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class day2 extends AOCAssignmentBase{

    public day2(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {

        ArrayList<String> PasswordList = lines;
        ArrayList<String> ValidPasswordsOld = new ArrayList<>();
        ArrayList<String> ValidPasswordsNew = new ArrayList<>();
        String[] Scan;

        for(String Password : PasswordList){

            int Counter = 0;
            int Index = 0;
            boolean ExistOnFirstIndex = false;
            boolean ExistOnSecondIndex = false;

            Scan = Password.split("[- :]");
            //Scan[0] = Min Number
            //Scan[1] = Max Number
            //Scan[2] = Letter
            //Scan[3] = Empty
            //Scan[4] = Password

            if(Scan[4].contains(Scan[2])){

                for(char Seq : Scan[4].toCharArray()){

                    char temp = Scan[2].charAt(0);
                    Index++;

                    if(temp == Seq){

                        Counter++;

                        if(Index == Integer.parseInt(Scan[0])){
                            ExistOnFirstIndex = true;
                        }
                        if(Index == Integer.parseInt(Scan[1])){
                            ExistOnSecondIndex = true;
                        }

                    }
                }

                if (ExistOnFirstIndex ^ ExistOnSecondIndex){

                    ValidPasswordsNew.add(Scan[0] + "-" + Scan[1] + " " + Scan[2] + ":" + " " + Scan[4]);
                    //System.out.println(ValidPasswordsNew.get(ValidPasswordsNew.size()-1));
                }

                if(Counter >= Integer.parseInt(Scan[0]) && Counter <= Integer.parseInt(Scan[1])){

                    ValidPasswordsOld.add(Scan[0] + "-" + Scan[1] + " " + Scan[2] + ":" + " " + Scan[4]);
                    //System.out.println(ValidPasswordsOld.get(ValidPasswordsOld.size()-1));
                }
            }
        }
        System.out.format("Total Passwords in the system: %d%n", PasswordList.size());
        System.out.format("Valid Passwords in the old system: %d%n", ValidPasswordsOld.size());
        System.out.format("Valid Passwords in the new system: %d%n", ValidPasswordsNew.size());
    }
}
