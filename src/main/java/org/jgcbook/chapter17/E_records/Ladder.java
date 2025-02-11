package org.jgcbook.chapter17.E_records;
// 19e1
import java.util.List;
import java.util.ArrayList;

record Person(String name, int age) {}
public class Ladder {
    final private List<Person> players;
    final private List<Integer> rankings;
    public Ladder(List<Person> players, List<Integer> rankings) {
        this.players = players;
        this.rankings = rankings;
    }
    public List<Integer> getRankings() {
        return rankings;
    }
    public void exchange(Person winner, Person loser) {
        int winnerLocation = players.indexOf(winner);
        int loserLocation = players.indexOf(loser);
        int winnerRanking = rankings.get(loserLocation);
        rankings.set(winnerLocation, winnerRanking);
        rankings.set(loserLocation, winnerRanking + 1);
    }
    public static void main(String[] args) {
        final Person george = new Person("george", 33);
        final Person john = new Person("john", 31);
        final Person paul = new Person("paul", 30);
        Ladder ladder = new Ladder(new ArrayList<>(List.of(george, john, paul)),
                                   new ArrayList<>(List.of(2, 3, 1)));
        ladder.exchange(john, george);
        assert ladder.getRankings().equals(List.of(3, 2, 1));
    }

}