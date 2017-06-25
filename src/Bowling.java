import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The Bowling class builds a single-player bowling simulation game scorer using
 * Java. For every round the number of pins struck needs to be entered. After
 * every round the scores are updated as per the bowling rules and displayed as
 * text output on the terminal.
 * 
 * Assumption for the Last Round: (1) If there is neither Spare nor Strike:-
 * Normal 2 tosses and no special toss. (2) If there is a Spare:- There are 2
 * normal tosses followed by a special 3rd toss. 2. If there is a Strike:- There
 * is 1 normal toss first. As per the rules of Strike the 2nd toss should be
 * omitted. But for last round, the 2nd toss still happens. If this 2nd toss
 * does not hit all the pins, then there is a third toss to finish off the
 * remaining pin. Even if the 2nd toss hits all the pins and creates a Strike,
 * there is still a 3rd toss with fresh set of pins.
 * 
 * @author Sayon Kumar Saha
 * @since 01.06.2017
 */

public class Bowling {

    private final static int MAX_ROUNDS = 10;
    private final static int TOTAL_PINS = 10;
    private static List<Rounds> roundList = new ArrayList<Rounds>(MAX_ROUNDS);

    public static void main(String[] args) throws NumberFormatException,
	    IOException {

	// The last two pins in special scenarios of last round strike/spare are
	// set to a constant value in case they are not set.

	int pinsLastRound_One = Integer.MIN_VALUE;
	int pinsLastRound_Two = Integer.MIN_VALUE;

	for (int r = 0; r < MAX_ROUNDS; r++) {

	    int pinsFirstToss;

	    // The second toss pin is set to a constant value in case it is not
	    // used for the rounds with Strike.
	    int pinsSecondToss = Integer.MIN_VALUE;

	    Rounds round = new Rounds();

	    System.out.println("Round " + (r + 1) + ":");

	    pinsFirstToss = getPins(0, TOTAL_PINS);
	    round.setFirstToss(pinsFirstToss);

	    if (!getStrikeStatus(pinsFirstToss)) {
		pinsSecondToss = getPins(0, (TOTAL_PINS - pinsFirstToss));
		round.setSecondToss(pinsSecondToss);
	    }

	    round.setIsStrike(getStrikeStatus(pinsFirstToss));
	    round.setIsSpare(getSpareStatus(pinsFirstToss, pinsSecondToss));

	    roundList.add(round);
	    generateScores(round, r);
	    displayScore();

	    // The special scenario of last round is handled separately.
	    if ((r == MAX_ROUNDS - 1)) {

		if (round.getIsSpare())
		    pinsLastRound_One = getPins(0, TOTAL_PINS);
		else if (round.getIsStrike()) {
		    pinsLastRound_One = getPins(0, TOTAL_PINS);
		    int upperLimit = (pinsLastRound_One == TOTAL_PINS) ? TOTAL_PINS
			    : (TOTAL_PINS - pinsLastRound_One);
		    pinsLastRound_Two = getPins(0, upperLimit);
		} else
		    break;
	    }
	}
	
	updateLastTwoRounds(pinsLastRound_One, pinsLastRound_Two);
	displayScore();
    }

    /**
     * This method is used for accepting input from the terminal. The number of
     * pins struck on every roll is the input.
     * 
     * @param int lowerLimit: This is used to validate the input based on the
     *        the lowest number of pins that can be struck for the particular
     *        roll.
     * @param int lowerLimit: This is used to validate the input based on the
     *        the lowest number of pins that can be struck for the particular
     *        roll.
     * 
     * @return int i: The number of pins struck as an input from the user.
     */

    public static int getPins(int lowerLimit, int upperLimit)
	    throws IOException {
	Scanner scanner = new Scanner(System.in);
	int i = 0;
	while (true) {
	    System.out.print("Bowling Roll.. Enter the Pins Struck: ");
	    try {
		i = scanner.nextInt();
	    } catch (InputMismatchException e) {
		System.out.println("Invalid Input: Input Mismatch Exception!");
		getPins(lowerLimit, upperLimit);
	    }
	    if ((i > upperLimit) || (i < lowerLimit))
		System.out
			.println("Invalid Input: Pins struck must be between "
				+ lowerLimit + " and " + upperLimit + ".");
	    else
		break;
	}
	return i;
    }

    /**
     * This method is used to update and adjust the bonus scores of the last two
     * rounds based on strikes, spares, and special tosses.
     * 
     * @param int lastPin_One: This is the number of pins struck on the special
     *        toss in the last round.
     * @param int lastPin_Two: This is the number of pins struck on the special
     *        toss in the last round.
     * 
     */

    public static void updateLastTwoRounds(int lastPin_One, int lastPin_Two) {

	Rounds lastRound = roundList.get(MAX_ROUNDS - 1);
	Rounds secondLastRound = roundList.get(MAX_ROUNDS - 2);
	int bonus = 0;

	// handling the scenario for the second last round.
	if (!secondLastRound.getIsScoreFinal()) {

	    // the scenario when second last round is a spare.
	    if (secondLastRound.getIsSpare())
		bonus = lastRound.getFirstToss();

	    // the scenario when second last round is a strike.
	    else if (secondLastRound.getIsStrike())
		bonus = (lastRound.getIsStrike()) ? (lastRound.getFirstToss() + lastPin_One)
			: (lastRound.getFirstToss() + lastRound.getSecondToss());

	    updateBonusAdditions(MAX_ROUNDS - 2, bonus);
	    secondLastRound.setIsScoreFinal(true);
	}

	// handling the scenario for the last round.
	if (!lastRound.getIsScoreFinal()) {

	    // the scenario when last round is a spare.
	    if (lastRound.getIsSpare())
		lastRound.setScore(lastRound.getScore() + lastPin_One);

	    // the scenario when last round is a strike.
	    else if (lastRound.getIsStrike())
		lastRound.setScore(lastRound.getScore() + lastPin_One
			+ lastPin_Two);

	    lastRound.setIsScoreFinal(true);
	}
    }

    /**
     * This method is used to check if a round is Strike.
     * 
     * @param int pinsFirstToss The first toss of a round.
     * 
     * @return boolean: Returns true if it is a Strike, else false.
     */

    public static boolean getStrikeStatus(int pinsFirstToss) {
	return (pinsFirstToss == TOTAL_PINS);
    }

    /**
     * This method is used to check if a round is Spare.
     * 
     * @param int pinsFirstToss The first toss of a round.
     * @param int pinsSecondToss The second toss of a round.
     * 
     * @return boolean: Returns true if it is a Spare, else false.
     */

    public static boolean getSpareStatus(int pinsFirstToss, int pinsSecondToss) {
	return (pinsFirstToss + pinsSecondToss == TOTAL_PINS);
    }

    /**
     * This method is used update the score of a round based on the number of
     * pins struck. It does not take into account any strike or spare bonus.
     * 
     * @param Rounds
     *            recentRound: The round object whose score is to be updated
     *            based on the pins struck.
     * @param int recentRoundNum: The round number whose score is to be updated
     *        based on the pins struck.
     * 
     */

    public static void updateRecentScore(Rounds recentRound, int recentRoundNum) {

	int pins = ((recentRound.getIsStrike()) || (recentRound.getIsSpare())) ? TOTAL_PINS
		: (recentRound.getFirstToss() + recentRound.getSecondToss());
	// takes into account the score accumulated from the previous rounds
	int oldScore = (recentRoundNum > 0) ? roundList.get(recentRoundNum - 1)
		.getScore() : 0;
	recentRound.setScore(oldScore + pins);

	// checks that if it is neither a strike nor a spare, then no bonus
	// needs to added and this is the final score
	if ((!recentRound.getIsStrike()) && (!recentRound.getIsSpare()))
	    recentRound.setIsScoreFinal(true);
    }

    /**
     * This method is used update all the rounds with bonus found due to strike
     * or spare in a particular round.
     * 
     * @param int i The round number that caused the bonus.
     * @param int bonus The computed bonus score
     */

    public static void updateBonusAdditions(int i, int bonus) {

	while (i < roundList.size()) {
	    Rounds round = roundList.get(i);
	    round.setScore(round.getScore() + bonus);
	    i++;
	}
    }

    /**
     * This method handles the case when there is a Spare. The bonus is computed
     * and updated in the other rounds accordingly.
     * 
     * @param Rounds
     *            round: The round object which has a Spare.
     * @param int currIndex: The round number which has a Spare.
     * @param int nextIndex: THe next round number which has a Spare.
     */

    public static void caseSpare(Rounds round, int currIndex, int nextIndex) {

	if (nextIndex < (roundList.size())) {

	    Rounds nextRound = roundList.get(nextIndex);
	    updateBonusAdditions(currIndex, nextRound.getFirstToss());
	    round.setIsScoreFinal(true);
	}
    }

    /**
     * This method handles the case when there is a Strike. It checks if the
     * next round is also a strike and handles accordingly. The bonus is
     * computed and updated in the other rounds.
     * 
     * @param Rounds
     *            round: The round object which has a Strike.
     * @param int currIndex: The round number which has a Strike.
     * @param int nextIndex: THe next round number which has a Strike.
     */

    public static void caseStrike(Rounds round, int currIndex, int nextIndex,
	    int nextNextIndex) {

	if ((nextIndex) < (roundList.size())) {
	    Rounds nextRound = roundList.get(nextIndex);

	    if (nextRound.getIsStrike()) {

		if (nextNextIndex < (roundList.size())) {
		    Rounds nextNextRound = roundList.get(nextNextIndex);
		    updateBonusAdditions(currIndex, nextRound.getFirstToss()
			    + nextNextRound.getFirstToss());
		    round.setIsScoreFinal(true);
		}
	    }

	    else {
		updateBonusAdditions(currIndex, nextRound.getFirstToss()
			+ nextRound.getSecondToss());
		round.setIsScoreFinal(true);
	    }
	}
    }

    /**
     * This is the method used to generate the overall scores as and when there
     * are new inputs every round..
     * 
     * @param Rounds
     *            thisRound: The current round object that received input.
     * @param int roundNum: The current round number that received input.
     * 
     */

    public static void generateScores(Rounds thisRound, int roundNum) {

	updateRecentScore(thisRound, roundNum);

	for (int r = 0; r < roundList.size(); r++) {
	    Rounds round = roundList.get(r);

	    if (round.getIsScoreFinal())
		continue;

	    if (round.getIsSpare())
		caseSpare(round, r, r + 1);

	    if (round.getIsStrike())
		caseStrike(round, r, r + 1, r + 2);
	}
    }

    /**
     * This method is used to display the score in an customized manner as per
     * the bowling rules, after every round.
     * 
     */

    public static void displayScore() {

	System.out.println();
	System.out.println("SCOREBOARD");

	String strike = "X";
	String spare = "/";
	String none = "-";

	String roundState = "";
	int count = 1;

	for (Rounds round : roundList) {

	    if (round.getIsStrike())
		roundState = "[   " + strike + "]";
	    else if (round.getIsSpare())
		roundState = "[" + round.getFirstToss() + "  " + spare + "]";
	    else {
		if (round.getSecondToss() > 0)
		    roundState = "[" + round.getFirstToss() + "  "
			    + round.getSecondToss() + "]";
		else
		    roundState = "[" + round.getFirstToss() + "  " + none + "]";
	    }
	    System.out.println("Round " + (count++) + ": " + roundState + "  "
		    + "(Score: " + round.getScore() + ")" + "\t");
	}
	System.out.println();
    }

    /**
     * This is the method created similar to the main method without the input.
     * It is used for the purpose of testing the code with pre-defined values
     * sent by the test cases.
     * 
     * 
     * @param List
     *            <Rounds> roundListTest: The list of round with the individual
     *            tosses already pre-defined by the test cases.
     * @param int pinsLastRound_One: This is the number of pins struck on the
     *        special toss in the last round. It is pre-defined by the test
     *        cases.
     * @param int pinsLastRound_Two: This is the number of pins struck on the
     *        special toss in the last round. It is pre-defined by the test
     *        cases.
     * 
     * @return List <Rounds> roundList: Returns the list of rounds with computed
     *         scores for validation in the test cases.
     */

    public static List<Rounds> sourceMethodForTest(List<Rounds> roundListTest,
	    int pinsLastRound_One, int pinsLastRound_Two) {
	for (int r = 0; r < MAX_ROUNDS; r++) {

	    Rounds roundTest = roundListTest.get(r);
	    int pinsFirstToss = roundTest.getFirstToss();
	    int pinsSecondToss = roundTest.getSecondToss();

	    roundTest.setIsStrike(getStrikeStatus(pinsFirstToss));
	    roundTest.setIsSpare(getSpareStatus(pinsFirstToss, pinsSecondToss));
	    roundList.add(roundTest);
	    generateScores(roundTest, r);

	}
	updateLastTwoRounds(pinsLastRound_One, pinsLastRound_Two);
	return roundList;
    }
}
