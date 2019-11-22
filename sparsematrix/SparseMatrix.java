import java.util.ArrayList;

public class SparseMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0,2,0,0,0,0,4,0},{0,0,0,0,0,1},{0,6,0,0,0,0,0}};
        
        System.out.println("-----------------------------------------------");
        for(int i = 0; i < matrix.length; i++) {
            String t = "";
            for (int y = 0; y < matrix[i].length; y++){
                t += matrix[i][y] + " ";
            } 
            System.out.println(t);
        }
        System.out.println("-----------------------------------------------");
        ArrayList<int[]> sparse = sparse(matrix);
        for(int x = 0; x < sparse.size(); x++) {
            String m = "";
            for(int y = 0; y < sparse.get(x).length; y++) {
                m += sparse.get(x)[y] + " ";  
            }   
            System.out.println(m);
        }
        
        System.out.println("-----------------------------------------------");
    }
    static ArrayList<int[]> sparse(int[][] matrix){        
        ArrayList<int[]> sparse = new ArrayList<>();

        for(int y = 0; y < matrix.length; y++) {
            int[] nested = matrix[y];
            for(int x = 0; x < nested.length; x++) {
                if(nested[x] != 0) {
                    int[] value = {x, y, nested[x]};
                    sparse.add(value);
                }
            }
        }
        return sparse;
    }
}