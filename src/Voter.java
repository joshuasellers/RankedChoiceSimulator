import java.util.ArrayList;

public class Voter {
    private int id;
    private ArrayList<Candidate> rank;

    public Voter(int id, ArrayList<Candidate> rank){
        this.id = id;
        this.rank = rank;
    }

    @Override
    public String toString(){
        return "Voter #" + this.id;
    }
}
