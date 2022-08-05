import java.util.ArrayList;
import java.util.List;

public class StepNumbers {

    public static void main(String[] args) {
        int step =1;
        int currentSlab =0;
        for(int i=1;i<15;i++){
            if(currentSlab<step){
                System.out.print(i);
                currentSlab++;
            }else{
                System.out.println();
                System.out.print(i);
                currentSlab = 1;
                step++;
            }
        }
    }
}
