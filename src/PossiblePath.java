/**
 * Greatest common divisor problem
 * if m is any integer, the gcd(a+m*b,b)=gcd(a,b)
 * In this particular problemm m=1 or m=-1 in each steop
 * Therefore, the gcd of (a+b,b), (a,a+b),(a-b,b) will  be the same as the gcd of (a,b)
 * Therefore in order to move to the target point the gcd of the target point should be equal to the gcd of the starting point
 * */
public class PossiblePath {

    public void possiblePath(int a, int b, int x, int y){
        int i=gcd(a,b);
        int j=gcd(x,y);
        if(i==j){
            System.out.println("Yes");
        }else System.out.println("No");
    }

    private int gcd(int n1, int n2) {
        while(n2!=0){
            int r=n1%n2;
            n1=n2;
            n2=r;
        }
        return n1;

    }
}
