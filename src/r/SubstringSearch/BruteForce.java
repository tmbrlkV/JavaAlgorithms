package r.SubstringSearch;

public class BruteForce {
    public static int search(String pat, String text) {
        int M = pat.length();
        int N = text.length();

        for (int i = 0; i <= N - M; ++i) {
            int j;
            for (j = 0; j < M; ++j) {
                if (text.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        return N;
    }

    public static int searchUpdate(String pat, String text) {
        int i, j;
        int M = pat.length();
        int N = text.length();
        for (i = 0, j = 0; i < N && j < M; ++i) {
            if (text.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            return i - M;
        } else {
            return N;
        }
    }
}
