public class Candidate {
    private String name;
    private String party;

    public Candidate(String name, String party){
        this.name = name;
        this.party = party;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.party;
    }

}
