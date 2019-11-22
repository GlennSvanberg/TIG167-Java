import java.util.ArrayList;
import java.util.Scanner;

public class Mandate {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hur många mandat finns det?");
        int mandate = scanner.nextInt();
        
        System.out.println("Gräns för småpartier?");
        int limit = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Ange partiernas förkortningar:");
        String[] parties = scanner.nextLine().split(" ");
        
        System.out.println("Ange antalet röster för respektive parti:");
        String[] votesStrings = scanner.nextLine().split(" ");
        int[] votes = new int[votesStrings.length];
        for(int i = 0; i < votesStrings.length; i++) {
            votes[i] = Integer.valueOf(votesStrings[i]);
        }
        scanner.close();

        int[] mandates = mandates(mandate, limit, votes);
        for(int i = 0; i < parties.length; i++) {
            System.out.println(parties[i] + " mandat: " + mandates[i]);
        } 
    }

    static int[] mandates(int mandate, int limit, int[] votes) {

        votes = removeUnderLimit(votes, limit);

        int[] mandates = new int[votes.length];
        double[] ratio = new double[votes.length];
        for(int i = 0; i < votes.length; i++) {
            ratio[i] = votes[i] / 1.2;
            mandates[i] = 0;
        }
        
        for(int i = 0; i < mandate; i++) {
            int pos = highestRatio(ratio);
            mandates[pos] = mandates[pos] + 1;
            ratio[pos] = votes[pos]/((2 * mandates[pos]) + 1.0);
        }
        return mandates;
    }

    static int[] removeUnderLimit(int[] votes, int limit) {
        double totalVotes = 0;
        for (int vote : votes) {
            totalVotes += vote;
        }
        int minVotes = (int) Math.round(Double.valueOf(totalVotes * (Double.valueOf(limit) / 100.0)));
        for(int i = 0; i < votes.length; i++) {
            if(votes[i] <= minVotes) {
                votes[i] = 0;           
            }
        }
        return votes;
    }
    
    static int highestRatio(double[] ratio) {
        int pos = 0;
        double max = 0;
        for (int i = 0; i < ratio.length; i++) {
            if(ratio[i] > max) {
                max = ratio[i];
                pos = i;
            }
        }
        return pos;
    } 
}