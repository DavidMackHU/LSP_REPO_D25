package org.howard.edu.lsp.midterm.question3;

/**
 * simple voting system
 * allows adding candidates, casting votes, and determining the winner
 * 
 * 
 * @author David Mack
 */
public class VotingMachine {
    private String[] candidates;
    private int[] votes;
    private int candidateCount;

    /**
     * Constructs a VotingMachine with support for up to 10 candidates.
     */
    public VotingMachine() {
        this.candidates = new String[10]; // Fixed-size array for simplicity
        this.votes = new int[10];
        this.candidateCount = 0;
    }

    /**
     * Adds a candidate to the election.
     * 
     * @param candidateName The name of the candidate.
     */
    public void addCandidate(String candidateName) {
        if (candidateCount < candidates.length) {
            candidates[candidateCount] = candidateName;
            votes[candidateCount] = 0;
            candidateCount++;
        }
    }

    /**
     * Casts a vote for a candidate.
     * 
     * @param candidateName The name of the candidate to vote for.
     * @return true if the vote was cast successfully, false if the candidate does not exist.
     */
    public boolean castVote(String candidateName) {
        for (int i = 0; i < candidateCount; i++) {
            if (candidates[i].equals(candidateName)) {
                votes[i]++;
                return true;
            }
        }
        return false; // Candidate not found
    }

    /**
     * Determines the winner of the election.
     * 
     * @return A string announcing the winner with their vote count.
     */
    public String getWinner() {
        if (candidateCount == 0) {
            return "No candidates available.";
        }

        int maxVotes = -1;
        String winner = null;

        for (int i = 0; i < candidateCount; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winner = candidates[i];
            }
        }

        return (winner != null) ? winner + " WINS with " + maxVotes + " votes!!" : "No votes cast.";
    }
}
