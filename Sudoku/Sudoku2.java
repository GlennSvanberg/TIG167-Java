import java.util.Arrays;

public class Sudoku2 {
    public static void main(String[] args) {
        int[][] board = {
            {1,2,3,4,5,6,7,8,9},
            {7,8,9,1,2,3,4,5,6},
            {4,5,6,7,8,9,1,2,3},
            {9,1,2,3,4,5,6,7,8},
            {6,7,8,9,1,2,3,4,5},
            {3,4,5,6,7,8,9,1,2},
            {8,9,1,2,3,4,5,6,7},
            {5,6,7,8,9,1,2,3,4},
            {2,3,4,5,6,7,8,9,1},
        };
        int[]s = {1,3,2,6,5,4,9,7,8};
        System.out.println(isSequence(s, 1, 9));
        String a = "";
        for(int i = 0; i < board.length; i++) {
            a = "";
            for(int j = 0; j < board.length; j++){
                a += board[i][j] + " ";
            }
        System.out.println(a);    
    }
    System.out.println("---------------------");
    System.out.println("isSolved: " + isSolved(board));
    }

    public static boolean isSolved(int[][] board){
        
        int[] temp = new int[9];
        
        for(int i = 0; i < board.length; i++) {
            
            if(!isSequence(board[i], 1, 9)) {  
                return false;
            }
            for (int j = 0; j < board.length; j++) {
                temp[j] = board[j][i];
            }
            if(!isSequence(temp, 1, 9)) {
                return false;
            }
        }
        int[] jump = {0,3,6};
        int[] b = new int[9];
        int nr = 0;
        
        for (int i = 0; i < 3; i++) {     
            for(int j = 0; j < 3; j++) {        
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        int x = jump[i]+k;
                        int y = jump[j]+l;
                        b[nr] = board[x][y];
                        nr++;
                        if(nr == 9) {
                            nr = 0;
                            if(!isSequence(b, 1, 9)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isSequence(int[] sequence, int first, int last) {
        if(sequence == null) {
            return false;
        }
        int [] s = new int[9];
        for(int i = 0; i < sequence.length; i++) {
            s[i] = sequence[i];
        }
        Arrays.sort(s);
        for(int i = 0; i < last-first+1; i++) {
            if(s[i] != first + i) {
                return false;
            }
        }
        return true;
    }
}