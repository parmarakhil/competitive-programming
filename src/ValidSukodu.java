import java.util.ArrayList;
import java.util.List;

public class ValidSukodu {
    List<Character> l=new ArrayList();
    public boolean isValidSudoku(char[][] board) {
        //checks for vertical condition
        boolean a=checkverti(board);
        l.clear();
        if(a==false){
            return false;
        }

        //checks for horizontal condition
        boolean b=checkhori(board);
        if(b==false){
            return false;
        }  l.clear();

        // any of the methods checkbox or checkbox1 can be used for checking of 3*3        submatrices


        boolean c=checkbox(board);

        if(c==false){
            return false;
        }
        return a ;


    }
    public boolean checkhori(char[][] board){
        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                if(l.contains(board[i][j]))  {
                    return false;
                }  else{


                    l.add(board[i][j]);
                }
            }
            l.clear();
        }
        return true;
    }
    public boolean checkverti(char[][] board){
        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++){
                if(board[j][i]=='.')continue;
                if(l.contains(board[j][i]))  {
                    return false;
                }  else{
                    l.add(board[j][i]);
                }
            }
            l.clear();
        }
        return true;
    }
    public boolean checkbox(char[][] board){
        for(int i=1;i<8;i=i+3){
            for(int j=1;j<8;j=j+3){
                l=new ArrayList();
                for(int m=-1;m<=1;m++){
                    for(int n=-1;n<=1;n++){

                        if(board[i+m][j+n]=='.')continue;

                        if(l.contains(board[i+m][j+n]))  {
                            return false;
                        }
                        else{
                            l.add(board[i+m][j+n]);
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean checkbox1(char[][] board){
        int k=9;
        int i=0;int j=0;
        while(i<k){
            while(j<k){
                l=new ArrayList();
                for(int m=i;m<i+3;m++){
                    for(int n=j;n<j+3;n++){

                        if(board[m][n]=='.')continue;

                        if(l.contains(board[m][n]))  {
                            return false;
                        }
                        else{
                            l.add(board[m][n]);
                        }
                    }
                }


                j=j+3;
            }
            j=0;
            i=i+3;
        }

        return true;


    }
}
