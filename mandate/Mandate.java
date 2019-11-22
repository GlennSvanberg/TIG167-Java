import static javax.swing.JOptionPane.*;
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
        String partiesString = scanner.nextLine();
        ArrayList<String> parties = new ArrayList<>();
        String[] partiesArray = partiesString.split(" ");
        for(String party : partiesArray) {
            parties.add(party);
         }

        System.out.println("Ange antalet röster för respektive parti:");
        String votesString = scanner.nextLine();
        String[] votesArray = votesString.split(" ");
        ArrayList<Integer> votes = new ArrayList<>();
        for(String vote : votesArray) {
            votes.add(Integer.valueOf(vote));
        }
        scanner.close();
        ArrayList<Integer> mandatesArray = calculateMandate(mandate, limit, votes);
        
        for(int i = 0; i < parties.size(); i++) {
            System.out.println(parties.get(i) + " mandat: " + mandatesArray.get(i));
        }
        System.exit(0); 
    }

    static ArrayList<Integer> calculateMandate(int mandate, int limit, ArrayList<Integer> votes) {

        // limit
        int totalVotes = 0;
        for (int vote : votes) {
            totalVotes += vote;
        }
        int minVotes = (int) Math.round(Double.valueOf(totalVotes) * (Double.valueOf(limit) / 100.0));

        for(int i = 0; i < votes.size(); i++) {
            if(votes.get(i) <= minVotes) {
                votes.set(i, 0);           
            }
        }
        ArrayList<Integer> mandates = new ArrayList<>();

        // initiate arrays
        ArrayList<Double> jfrtal = new ArrayList<>();
        for(int i = 0; i < votes.size(); i++) {
            jfrtal.add(votes.get(i) / 1.2);
            mandates.add(0);
            //System.out.println("jfrtal: " + jfrtal.get(i));
        }
        
        // Loopa igenom alla tillgängliga mandat
        for(int i = 0; i < mandate; i++) {
            // hand out mandates
            int winner = highestJfrtal(jfrtal);
            int nrOfMandates = mandates.get(winner) + 1;
            mandates.set(winner, nrOfMandates);

            // calculate new jfrtal
            double winnerVotes = Double.valueOf(votes.get(winner));
            double m = Double.valueOf(mandates.get(winner));
            double newJfrtal = winnerVotes/((2 * m) + 1.0);
            jfrtal.set(winner, newJfrtal);
            System.out.println("calc: " + winnerVotes + "/ (2 * " + m +") + 1.0");
            System.out.println("position: " + winner + " jfr: " + newJfrtal);
            
        }
        return mandates;
    }
    
    static int highestJfrtal(ArrayList<Double> jfrtal) {
        int position = 0;
        double max = 0;
        for (int i = 0; i < jfrtal.size(); i++) {
            if(jfrtal.get(i) > max) {
                max = jfrtal.get(i);
                position = i;
            }
        }
        return position;
    } 
    static void test() {
        /*
            M C L KD S V Mp SD Fi Övr1284698 557500 355546 409478 1830386 518454 285899 1135627 29665 69472
        */
        int mandate = 349;
        int limit = 4;
        
        ArrayList<String> parties = new ArrayList<>();
        parties.add("M");
        parties.add("C");
        parties.add("L");
        parties.add("KD");
        parties.add("S");
        parties.add("V");
        parties.add("Mp");
        parties.add("SD");
        parties.add("Fi");
        parties.add("Övr");

        ArrayList<Integer> votes = new ArrayList<>();
        votes.add(1284698);
        votes.add(557500);
        votes.add(355546);
        votes.add(409478);
        votes.add(1830386);
        votes.add(518454);
        votes.add(285899);
        votes.add(1135627);
        votes.add(29665);
        votes.add(69472);

        ArrayList<Integer> mandates = calculateMandate(mandate, limit, votes);
        int total  = 0;
        for(int i = 0; i < parties.size(); i++) {
            System.out.println(parties.get(i) + " mandat: " + mandates.get(i));
            total += mandates.get(i);
        }
        
        System.exit(0);
    }

}