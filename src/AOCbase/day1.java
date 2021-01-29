package AOCbase;

import com.sun.jdi.IntegerType;

import java.io.IOException;

public class day1 extends AOCAssignmentBase {

    public day1(String day) throws IOException {
        super(day);
    }

    @Override
    void solve() {
        for (int i = 0; i < lines.size(); i++){
            for (int j = i + 1; j < lines.size(); j++){
                for (int k = j + 1; k < lines.size(); k++){
                    if (Integer.parseInt(lines.get(i))
                            + Integer.parseInt(lines.get(j))
                            + Integer.parseInt(lines.get(k)) == 2020 ){
                        System.out.println(Integer.parseInt(lines.get(i))
                                * Integer.parseInt(lines.get(j))
                                * Integer.parseInt(lines.get(k)));
                    }
                }
            }
        }
    }
}
