public class NumberDecoding {

    public int numberDecoding(String s){
        if(s.charAt(0)=='0') return 0;
        int oneJump=1, twoJump=1, temp=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'==0){
                if(s.charAt(i-1)-'0'==0 || s.charAt(i-1)-'0'>2) return  0;
                oneJump = twoJump;
                twoJump =1;
            }else {
                temp = oneJump;
                if(s.charAt(i-1)-'0'==1 || (s.charAt(i-1)-'0'==2 && s.charAt(i-1)-'0'<7)){
                    oneJump+=twoJump;
                }
                twoJump=temp;
            }
        }
        return oneJump;
    }
}
