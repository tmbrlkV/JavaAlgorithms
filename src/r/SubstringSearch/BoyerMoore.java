package r.SubstringSearch;

public class BoyerMoore {
    private String pat;
    private final int R = 256;
    private int[] right = new int[R];

    public BoyerMoore(String pat) {
        this.pat = pat;
        for (int i = 0; i < R; ++i) {
            right[i] = -1;
        }

        for (int i = 0; i < pat.length(); ++i) {
            right[pat.charAt(i)] = i;
        }

    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; --j) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j - right[txt.charAt(j + i)]);
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }
        return N;
    }
}
