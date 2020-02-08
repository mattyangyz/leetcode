package MathRelated;

import java.util.ArrayList;
import java.util.List;

public class NestedLoops {

    public List<Double> nestedLoops() {

        List<Double> ans = new ArrayList<>();
        double a = 1;
        double b = 1;
        double c = 1;

        while (a <= 100) {
            while (b <= 100) {
                while (c <= 100) {
                    ans.add(Math.cbrt((a * a * a) + (b * b * b) - (c * c * c)));
                    c += 1;
                }
                b += 1;
            }
            c += 1;
        }
        return ans;
    }

    public List<Integer> nestedLoopsMostSenior() {
        List<Integer> ans = new ArrayList<>();
        int d = 1;
        while (d <= 100) {
            ans.add(d);
        }
        return ans;
    }

}
