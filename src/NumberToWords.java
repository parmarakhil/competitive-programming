public class NumberToWords {
    public static void main(String[] args) {
        numberToWords(212245111);
    }
    public static String numberToWords(int num) {

        if(num==0){
            return "Zero";
        }

        StringBuffer words =new StringBuffer();

        String first = generateWord(num%1000);
        String second= generateWord((num/1000)%1000);
        String third= generateWord((num/1000/1000)%1000);
        String fourth= generateWord((num/1000/1000/1000)%1000);


        if(!(fourth.trim().isEmpty())){
            words.append(" "+fourth+" Billion ");
        }

        if(!(third.trim().isEmpty())){
            words.append(third.trim()+" Million ");
        }
        if(!(second.trim().isEmpty())){
            words.append(second.trim()+" Thousand ");
        }

        return words.append(first.trim()).toString().trim();
    }


    private static String generateWord(int num){
        String[] ones = new String[] {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens= new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] hunderds = new String[]{"","Ten","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuffer sbuf = new StringBuffer();

        if(num>99){
            sbuf.append(ones[num/100]).append(" Hundred");
            num = num%100;
        }
        if(num>=0 && num<10){

            sbuf.append(" ").append(ones[num]);
        }
        else if(num>=10 && num<20){
            sbuf.append(" ").append(tens[num-10]);
        }else{

            sbuf.append(" ").append(hunderds[num/10]);
            sbuf.append(" ");

            sbuf.append(ones[num%10]);

        }
        return sbuf.toString().trim();
    }
}
