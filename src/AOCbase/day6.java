package AOCbase;

import java.io.IOException;
import java.util.ArrayList;

public class day6 extends AOCAssignmentBase{
    public day6(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {
        ArrayList<String> CustomsForms = new ArrayList<>(lines);
        ArrayList<Character> Scanner = new ArrayList<>();
        int YesCounter = 0;

        for(String Form : CustomsForms){

            if(Form.equals("")){

                Scanner.clear();
            }

            for(char Answer : Form.toCharArray()){

                if(!Scanner.contains(Answer)){

                    Scanner.add(Answer);
                    YesCounter++;
                }
            }
        }
        System.out.format("Solution to part 1: %d%n", YesCounter);
        Part2();
    }

    void Part2(){

        ArrayList<String> CustomsForms = new ArrayList<>(lines);
        ArrayList<Character> Scanner = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        int YesCounter = 0;
        int GroupCheck = 0;

        for(String Form : CustomsForms){

            if(!Form.equals("")){

                for(char Answer : Form.toCharArray()){

                    if(!Scanner.contains(Answer)){

                        Scanner.add(Answer);
                    }
                }

                temp.add(Form);
            }

            else{

                for(char Answer : Scanner){

                    for (String s : temp){

                        if (s.contains(String.valueOf(Answer))) {

                            GroupCheck++;
                        }

                        if(GroupCheck == temp.size()){

                            YesCounter++;
                        }
                    }

                    GroupCheck = 0;
                }

                Scanner.clear();
                temp.clear();
            }
        }
        System.out.format("Solution to part 2: %d%n", YesCounter);
    }
}
