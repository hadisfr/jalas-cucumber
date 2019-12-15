package ir.ac.ut.ece.jalas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poll {
    Map<String, Integer> votes;

    public Poll(String question, List<String> options) {
        votes = new HashMap<String, Integer>();
        for (String option : options)
            votes.put(option, 0);
    }

    public void setVotes(String option, int votes) {
        this.votes.put(option, votes);
    }

    public int getVotes(String option) {
        return votes.get(option);
    }

    public void vote(String option) {
        votes.put(option, votes.get(option) + 1);
    }
}
