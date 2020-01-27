import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RCSMain {
    /**
     * get random list of candidates
     * @param c - list of candidates
     * @return random list of candidates
     */
    public static ArrayList<Candidate> getCandidates(ArrayList<Candidate> c){
        ArrayList<Candidate> candidates = new ArrayList<>();
        ArrayList<Integer> shuffle = new ArrayList<>();
        for (int i = 0; i < c.size(); i++){
            shuffle.add(i);
        }
        Collections.shuffle(shuffle);
        for (Integer i : shuffle){
            candidates.add(c.get(i));
        }
        return candidates;
    }

    /**
     * create a list of voters from the specified number
     * @param v - number of voters
     * @param candidates - list of candidates
     * @return list of voters
     */
    public static ArrayList<Voter> getVoters(int v, ArrayList<Candidate> candidates){
        ArrayList<Voter> voters = new ArrayList<>();
        for (int i = 0; i < v; i++){
            Voter voter = new Voter(i,getCandidates(candidates));
            voters.add(voter);
        }
        return voters;
    }

    /**
     * run ranked choice and all the helper functions
     * @param voters - list of voters
     * @param candidates - list of candidates
     * @param v - count of voters
     */
    public static void runSimulation(ArrayList<Voter> voters, ArrayList<Candidate> candidates, int v){
        System.out.println("WELCOME TO THE ELECTION");
        System.out.println("***********************");
        System.out.println("HERE ARE THE CANDIDATES:");
        for (Candidate c : candidates){
            System.out.println(c.toString());
            System.out.println("");
        }
        System.out.println("***********************");
        System.out.println("THERE ARE " + v + " TOTAL VOTERS");
        System.out.println("***********************");
    }

    /**
     * run ranked choice simulation
     * @param args - given as ` "Candidate_Name Candidate_Party" "Candidate_Name Candidate_Party" ... Number_Voters
     */
    public static void main(String[] args) {
        if (args.length < 2) System.exit(0);
        int v = 0;
        int total_candidates = 0;
        ArrayList<Candidate> candidates = new ArrayList<>();
        ArrayList<Voter> voters;
        for (String arg : args){
            try {
                v = Integer.parseInt(arg);

                if (v < 1) System.exit(0);

            } catch(NumberFormatException e){
                String[] candidate_fields = arg.split(" ");
                if (candidate_fields.length != 2) System.exit(0);
                total_candidates++;
                candidates.add(new Candidate(candidate_fields[0],candidate_fields[1]));
            }
        }
        if (total_candidates == 0) System.exit(0);
        voters = getVoters(v, candidates);
        runSimulation(voters,candidates, v);
    }
}
