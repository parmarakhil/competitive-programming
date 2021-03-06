public class CountAndSay {

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String ans="1";
        for(int i=2;i<=n;i++) {
            ans=fun(ans);
        }

        return ans;
    }

    public static String fun(String s) {
        int count=1;
        char ch=s.charAt(0);
        StringBuilder sb=new StringBuilder();
        int len=s.length();
        for(int i=1;i<len;i++)
        {
            if(s.charAt(i)==ch){
                count++;
            }
            else
            {
                sb.append(count).append(ch);
                ch=s.charAt(i);
                count=1;
            }
        }
        sb.append(count).append(ch);

        return sb.toString();
    }
}
