public class FirstRepeatedCharacter {
    /**
     * String input - first repeated element in string except special character */


    public static void firstRepeatedCharacter(String s){
        boolean[] repeated= new boolean[256];
        for(int i=0;i<s.length();i++){
            try{
                char c = s.charAt(i);
                boolean flag = repeated[c-'0'];
                if(flag){
                    System.out.println(c);
                    break;
                }
                else {
                    repeated[c-'0']=true;

                }
            }catch (IndexOutOfBoundsException e){}
        }
    }

}
