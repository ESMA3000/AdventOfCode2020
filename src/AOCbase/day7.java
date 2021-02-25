package AOCbase;

import java.io.IOException;
import java.util.ArrayList;

public class day7 extends AOCAssignmentBase{
    public day7(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {
        /*ArrayList<String> AllBags = new ArrayList<>(lines);
        ArrayList<String> Baglist = new ArrayList<>();
        for(String Bags : AllBags){

            String[] findBag = Bags.split(" bags contain");
            if(Bags.trim())

        }*/
        ArrayList<String> input = new ArrayList<String>(lines);
        ArrayList<String> happyBags = new ArrayList<String>();
        happyBags.add("shiny gold");

        boolean foundNewHappyBag = true;

        while (foundNewHappyBag) {
            foundNewHappyBag = false;
            for (int i = 0; i < input.size(); i++) {
                String[] split = input.get(i).split(" contain ");
                String bag = split[0].replace("bags", "").trim();
                String contents = split[1].trim();

                for (int j = 0; j < happyBags.size(); j++) {
                    if (contents.contains(happyBags.get(j))) {
                        happyBags.add(bag);
                        foundNewHappyBag = true;
                        input.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
        System.out.println(happyBags.size() - 1);
    }

}
