package o.StringSort;

import java.util.Arrays;

public class Suffix {

    public String lsr(String s) {
        int N = s.length();

        String[] suffixes = new String[N];
        for (int i = 0; i < N; ++i) {
            suffixes[i] = s.substring(i, N);
        }

        Arrays.sort(suffixes);

        String lsr="";
        for (int i = 0; i < N - 1; ++i) {
            int len = lcp(suffixes[i], suffixes[i + 1]);
            if (len > lsr.length()) {
                lsr = suffixes[i].substring(0, len);
            }
        }

        return lsr;
    }

    private int lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != t.charAt(i)) return i;
        }
        return N;
    }
}
