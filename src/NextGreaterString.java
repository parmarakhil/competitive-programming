import java.util.Arrays;

public class NextGreaterString {

    static String nextGreaterString(String word){
        char[] charArray = word.toCharArray();
        int n = charArray.length;
        int endIndex=0;

        // step-1 Start from the right most character and find the first character that is smaller than the previous character
        for(endIndex=n-1;endIndex>0;endIndex--){
            if(charArray[endIndex]>charArray[endIndex-1]){
                break;
            }
        }
        // if no greater character is found then all characters are in decending order
        // therfore there cannot be a greater String with same set of characters
        if(endIndex==0) return "no answer";
        else{
            int firstSmallCharacter= charArray[endIndex-1], nextSmallCharacter=endIndex;

            // step-2 find the smallest charactero right side of endIndex-1 character that is greater than endIndex-1 th
            for(int startIndex=endIndex+1;startIndex<n;startIndex++){
                if(charArray[startIndex]>firstSmallCharacter && charArray[startIndex]<charArray[nextSmallCharacter]){
                    nextSmallCharacter=startIndex;
                }
            }

            // step-3 now swap the above found character with the smallest character i.e charArray[endIndex-1]
            char temp=charArray[endIndex-1];
            charArray[endIndex-1]=charArray[nextSmallCharacter];
            charArray[nextSmallCharacter]=temp;

            // step-4 now sort the charArray after endIndex-1 in ascending order
            Arrays.sort(charArray, endIndex,n);
        }
        return new String(charArray);
    }
}
