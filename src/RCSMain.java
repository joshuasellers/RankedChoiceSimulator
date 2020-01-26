import java.util.ArrayList;

public class RCSMain {
    /**
     * run ranked choice simulation
     * @param args - given as ` "Candidate_Name Candidate_Party" "Candidate_Name Candidate_Party" ... Number_Voters
     */
    public static void main(String[] args) {
        int voters;
        ArrayList<Candidate> candidates = new ArrayList<>();
        for (String arg : args){
            try {
                voters = Integer.parseInt(arg);

                if (voters < 1) System.exit(0);

            } catch(NumberFormatException e){
                String[] candidate_fields = arg.split(" ");
                if (candidate_fields.length != 2) System.exit(0);

                candidates.add(new Candidate(candidate_fields[0],candidate_fields[1]));
            }
        }
    }
}
