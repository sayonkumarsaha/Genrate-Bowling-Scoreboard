/**
 * The class Rounds defines the attributes for the individual round in the
 * Bowling game.
 * 
 * @author Sayon Kumar Saha
 * @since 01.06.2017
 */

public class Rounds {

    private int firstToss;
    private int secondToss;
    private int score;
    private boolean isScoreFinal = false;
    private boolean isStrike = false;
    private boolean isSpare = false;

    public int getFirstToss() {
	return firstToss;
    }

    public void setFirstToss(int firstToss) {
	this.firstToss = firstToss;
    }

    public int getSecondToss() {
	return secondToss;
    }

    public void setSecondToss(int secondToss) {
	this.secondToss = secondToss;
    }

    public int getScore() {
	return score;
    }

    public void setScore(int score) {
	this.score = score;
    }

    public boolean getIsScoreFinal() {
	return isScoreFinal;
    }

    public void setIsScoreFinal(boolean isScoreFinal) {
	this.isScoreFinal = isScoreFinal;
    }

    public boolean getIsStrike() {
	return isStrike;
    }

    public void setIsStrike(boolean isStrike) {
	this.isStrike = isStrike;
    }

    public boolean getIsSpare() {
	return isSpare;
    }

    public void setIsSpare(boolean isSpare) {
	this.isSpare = isSpare;
    }

}
