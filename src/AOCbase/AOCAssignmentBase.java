package AOCbase;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public abstract class AOCAssignmentBase {
    public ArrayList<String> lines;

    public AOCAssignmentBase(String day) throws IOException {
        lines = GetInput(day);
        solve();
    }
    abstract void solve();

    private ArrayList<String> GetInput(String dayNumber) throws IOException {
        File dayInput = new File("Input/day" + dayNumber + ".txt");
        Scanner file = new Scanner(dayInput);
        ArrayList<String> lines = new ArrayList<>();
        while (file.hasNextLine()){
            lines.add(file.nextLine());
        }
        return lines;
    }
}
