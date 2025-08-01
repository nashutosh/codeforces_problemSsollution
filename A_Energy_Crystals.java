import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Solution for Codeforces - A. Energy Crystals
 * Educational Codeforces Round 179 (Rated for Div. 2)
 */
public class EnergyCrystals {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader for fast I/O in competitive programming
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // Use a StringBuilder for fast output aggregation
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long x = Long.parseLong(br.readLine());
            sb.append(solve(x)).append("\n");
        }
        System.out.print(sb.toString());
    }
    private static long solve(long x) {
        // Base case: If the target is 0, no actions are needed.
        if (x == 0) {
            return 0;
        }
        long actions = 0;
        long currentLevel = 0;
        // Loop until our current balanced level reaches the target
        while (currentLevel < x) {
            long requiredLevelForFinalJump = x / 2;
            if (currentLevel >= requiredLevelForFinalJump) {
                // Final 3-step upgrade to reach x in all 3 crystals
                actions += 3;
                break;
            } else {
                // Keep boosting synchronously: (c, c, c) -> (2c+1, 2c+1, 2c+1)
                actions += 3;
                currentLevel = 2 * currentLevel + 1;
            }
        }
        return actions;
    }
}
