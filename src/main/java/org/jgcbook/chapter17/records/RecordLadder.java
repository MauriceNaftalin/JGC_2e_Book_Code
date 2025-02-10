package org.jgcbook.chapter17.records;
// 19e2
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

record PlayerRanking(Person player, int ranking) {}
public class RecordLadder {
    final private List<PlayerRanking> ladder = new ArrayList<>();
    public RecordLadder(List<Person> players, List<Integer> rankings) {
        for (int i = 0; i < players.size(); i++) {
            ladder.add(new PlayerRanking(players.get(i), rankings.get(i)));
        }
    }
    public List<PlayerRanking> getLadder() {
        return ladder;
    }
    // ...

	private int locate(Person p) {
	    for (int i = 0; i < ladder.size(); i++) {
	        if (ladder.get(i).player().equals(p)) return i;
	    }
	    return -1;
	}
	public void exchange(Person winner, Person loser) {
	    int winnerLocation = locate(winner);
	    int loserLocation = locate(loser);
	    int winnerRanking = ladder.get(loserLocation).ranking();
	    ladder.set(winnerLocation, new PlayerRanking(winner, winnerRanking));
	    ladder.set(loserLocation, new PlayerRanking(loser, winnerRanking + 1));
	}
	public static void main(String[] args) {
	    final Person peter = new Person("peter", 33);
	    final Person paul = new Person("paul", 31);
	    final Person mary = new Person("mary", 30);
	    RecordLadder ladder = new RecordLadder(new ArrayList<>(List.of(peter, paul, mary)),
	            new ArrayList<>(List.of(2, 3, 1)));
	    ladder.exchange(paul, peter);
	    assert ladder.getLadder().get(ladder.locate(paul)).ranking() == 2 &&
	            ladder.getLadder().get(ladder.locate(peter)).ranking() == 3;
	    ladder.getLadder().sort(Comparator.comparing(pp -> pp.player().age()));
	    assert ladder.getLadder().stream().map(PlayerRanking::player).toList().equals(
	            List.of(mary, paul, peter));
	}
}