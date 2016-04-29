package t.DataCompression;

import p.Tries.TST;

import java.util.ArrayDeque;
import java.util.Queue;

public class LZW {
    private static final int R = 256;
    private static final int L = 4096;
    private static final int W = 12;

    public static TST<Integer> compress(String input) {
        TST<Integer> tr = new TST<>();
        TST<Integer> out = new TST<>();
        for (int i = 0; i < R; ++i) {
            tr.put("" + (char) i, i);
        }
        int code = R + 1;

        while (input.length() > 0) {
            String s = tr.longestPrefixOf(input);
            out.put(W + "", tr.get(s));
            int t = s.length();
            if (t < input.length() && code < L) {
                tr.put(input.substring(0, t + 1), code++);
            }
            input = input.substring(t);
        }
        return out;
    }

    public static Queue<String> expand(TST<Integer> in) {
        String[] st = new String[L];
        Queue<String> out = new ArrayDeque<>();
        int i;

        for (i = 0; i < R; ++i) {
            st[i] = "" + (char) i;
        }
        st[i++] = " ";

        int codeWord = in.get(W + "");
        if (codeWord == R) {
            return null;
        }
        String val = st[codeWord];

        while (true) {
            out.offer(val);
            codeWord = in.get(W + "");
            if (codeWord == R) {
                break;
            }
            String s = st[codeWord];
            if (i == codeWord) {
                s = val + val.charAt(0);
            }
            if (i < L) {
                st[i++] = val + s.charAt(0);
            }
            val = s;
        }
        return out;
    }
}
