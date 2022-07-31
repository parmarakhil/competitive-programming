public class ReverseWords {
    public String reverseWords(String s) {
        s=s.trim(); //used to remove ends spaces
        String st[]=s.split(" ");
        String str="";
        for(int i=st.length-1;i>0;i--)
        {
            if(st[i]!="")
            {
                str=str+st[i]+" ";
            }
        }
        str=str+st[0];
        return str;
    }
}
