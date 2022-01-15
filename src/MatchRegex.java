public class MatchRegex {

    public boolean isMatch(String s, String p) {
        // optional step, remove repeated .*
        StringBuilder sb = new StringBuilder();
        sb.append(p.charAt(0));
        int i = 1;
        while (i < p.length()) {
            sb.append(p.charAt(i));
            if (p.charAt(i++) == '*' && p.charAt(i-2) == '.') {
                while (i < p.length() - 1 && p.charAt(i) == '.' && p.charAt(i+1) == '*') {
                    i += 2;
                }
            }
        }
//        System.out.println(sb);
        return isMatch(s.toCharArray(), 0, sb.toString().toCharArray(), 0);
    }

    private boolean isMatch(char[] s, int si, char[] p, int pi) {
        if (si == s.length && pi == p.length) {
            return true;
        } else if (pi == p.length) {
            return false;
        } else if (si == s.length) {
            while (++pi < p.length && p[pi] == '*') {
                ++pi;
            }
            return pi > p.length;
        } else {
            if (pi + 1 < p.length && p[pi+1] == '*') {
                if (isMatch(s, si, p, pi + 2)) {
                    return true;
                } else {
                    while (si < s.length && (p[pi] == '.' || p[pi] == s[si])) {
                        if (isMatch(s, ++si, p, pi + 2)) {
                            return true;
                        }
                    }
                    return false;
                }
            } else {
                if (p[pi] == '.' || p[pi] == s[si]) {
                    return isMatch(s, ++si, p, ++pi);
                } else {
                    return false;
                }
            }
        }
    }

}
