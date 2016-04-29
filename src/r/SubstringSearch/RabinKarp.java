package r.SubstringSearch;

public class RabinKarp {
    private final int R = 256;
    private final int Q = 997;
    private final int M;
    private long patHash;
    private long RM;


    public RabinKarp(String pat) {
        M = pat.length();
        RM = 1;
        for (int i = 1; i <= M - 1; ++i) {
            RM = (R * RM) % Q;
        }
        patHash = hash(pat);

    }

    private long hash(String key) {
        long h = 0;
        for (int j = 0; j < M; ++j) {
            h = (R * h + key.charAt(j)) % Q;
        }
        return h;
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt);
        if (patHash == txtHash) {
            return 0;
        }
        for (int i = M; i < N; ++i) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash) {
                return i - M + 1;
            }
        }
        return N;
    }
}
