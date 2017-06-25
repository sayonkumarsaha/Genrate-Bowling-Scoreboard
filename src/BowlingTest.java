import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BowlingTest {

    @Test
    public void testValidStrikeStatus() {
	int pinsFirstToss = 10;
	boolean output = Bowling.getStrikeStatus(pinsFirstToss);
	assertTrue(output);
    }

    @Test
    public void testInvalidStrikeStatus() {
	int pinsFirstToss = 9;
	boolean output = Bowling.getStrikeStatus(pinsFirstToss);
	assertFalse(output);
    }

    @Test
    public void testValidSpareStatus() {
	int pinsFirstToss = 4;
	int pinsSecondToss = 6;
	boolean output = Bowling.getSpareStatus(pinsFirstToss, pinsSecondToss);
	assertTrue(output);
    }

    @Test
    public void testInvalidSpareStatus() {
	int pinsFirstToss = 3;
	int pinsSecondToss = 6;
	boolean output = Bowling.getSpareStatus(pinsFirstToss, pinsSecondToss);
	assertFalse(output);
    }

    @Test
    public void testBowlScoringOne() {

	// Test Case for the following sequence: "X9/5/72XXX9-8/9/X"
	
	List<Rounds> roundListTest = new ArrayList<Rounds>(10);

	Rounds round1 = new Rounds();
	round1.setFirstToss(10);
	round1.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round1);

	Rounds round2 = new Rounds();
	round2.setFirstToss(9);
	round2.setSecondToss(1);
	roundListTest.add(round2);

	Rounds round3 = new Rounds();
	round3.setFirstToss(5);
	round3.setSecondToss(5);
	roundListTest.add(round3);

	Rounds round4 = new Rounds();
	round4.setFirstToss(7);
	round4.setSecondToss(2);
	roundListTest.add(round4);

	Rounds round5 = new Rounds();
	round5.setFirstToss(10);
	round5.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round5);

	Rounds round6 = new Rounds();
	round6.setFirstToss(10);
	round6.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round6);

	Rounds round7 = new Rounds();
	round7.setFirstToss(10);
	round7.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round7);

	Rounds round8 = new Rounds();
	round8.setFirstToss(9);
	round8.setSecondToss(0);
	roundListTest.add(round8);

	Rounds round9 = new Rounds();
	round9.setFirstToss(8);
	round9.setSecondToss(2);
	roundListTest.add(round9);

	Rounds round10 = new Rounds();
	round10.setFirstToss(9);
	round10.setSecondToss(1);
	roundListTest.add(round10);

	int pinsLastRound_One = 10;
	int pinsLastRound_Two = Integer.MIN_VALUE;

	List<Rounds> output = Bowling.sourceMethodForTest(roundListTest,
		pinsLastRound_One, pinsLastRound_Two);

	assertEquals(output.get(0).getIsStrike(), true);
	assertEquals(output.get(0).getIsSpare(), false);
	assertEquals(output.get(0).getIsScoreFinal(), true);
	assertEquals(output.get(0).getScore(), 20);

	assertEquals(output.get(1).getIsStrike(), false);
	assertEquals(output.get(1).getIsSpare(), true);
	assertEquals(output.get(1).getIsScoreFinal(), true);
	assertEquals(output.get(1).getScore(), 35);

	assertEquals(output.get(2).getIsStrike(), false);
	assertEquals(output.get(2).getIsSpare(), true);
	assertEquals(output.get(2).getIsScoreFinal(), true);
	assertEquals(output.get(2).getScore(), 52);

	assertEquals(output.get(3).getIsStrike(), false);
	assertEquals(output.get(3).getIsSpare(), false);
	assertEquals(output.get(3).getIsScoreFinal(), true);
	assertEquals(output.get(3).getScore(), 61);

	assertEquals(output.get(4).getIsStrike(), true);
	assertEquals(output.get(4).getIsSpare(), false);
	assertEquals(output.get(4).getIsScoreFinal(), true);
	assertEquals(output.get(4).getScore(), 91);

	assertEquals(output.get(5).getIsStrike(), true);
	assertEquals(output.get(5).getIsSpare(), false);
	assertEquals(output.get(5).getIsScoreFinal(), true);
	assertEquals(output.get(5).getScore(), 120);

	assertEquals(output.get(6).getIsStrike(), true);
	assertEquals(output.get(6).getIsSpare(), false);
	assertEquals(output.get(6).getIsScoreFinal(), true);
	assertEquals(output.get(6).getScore(), 139);

	assertEquals(output.get(7).getIsStrike(), false);
	assertEquals(output.get(7).getIsSpare(), false);
	assertEquals(output.get(7).getIsScoreFinal(), true);
	assertEquals(output.get(7).getScore(), 148);

	assertEquals(output.get(8).getIsStrike(), false);
	assertEquals(output.get(8).getIsSpare(), true);
	assertEquals(output.get(8).getIsScoreFinal(), true);
	assertEquals(output.get(8).getScore(), 167);

	assertEquals(output.get(9).getIsStrike(), false);
	assertEquals(output.get(9).getIsSpare(), true);
	assertEquals(output.get(9).getIsScoreFinal(), true);
	assertEquals(output.get(9).getScore(), 187);

	roundListTest.clear();
	output.clear();
    }

    @Test
    public void testBowlScoringTwo() {

	// Test Case for the following sequence: "238143XX5/--189/XXX"
	
	List<Rounds> roundListTest = new ArrayList<Rounds>(10);

	Rounds round1 = new Rounds();
	round1.setFirstToss(2);
	round1.setSecondToss(3);
	roundListTest.add(round1);

	Rounds round2 = new Rounds();
	round2.setFirstToss(8);
	round2.setSecondToss(1);
	roundListTest.add(round2);

	Rounds round3 = new Rounds();
	round3.setFirstToss(4);
	round3.setSecondToss(3);
	roundListTest.add(round3);

	Rounds round4 = new Rounds();
	round4.setFirstToss(10);
	round4.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round4);

	Rounds round5 = new Rounds();
	round5.setFirstToss(10);
	round5.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round5);

	Rounds round6 = new Rounds();
	round6.setFirstToss(5);
	round6.setSecondToss(5);
	roundListTest.add(round6);

	Rounds round7 = new Rounds();
	round7.setFirstToss(0);
	round7.setSecondToss(0);
	roundListTest.add(round7);

	Rounds round8 = new Rounds();
	round8.setFirstToss(1);
	round8.setSecondToss(8);
	roundListTest.add(round8);

	Rounds round9 = new Rounds();
	round9.setFirstToss(9);
	round9.setSecondToss(1);
	roundListTest.add(round9);

	Rounds round10 = new Rounds();
	round10.setFirstToss(10);
	round10.setSecondToss(10);
	roundListTest.add(round10);

	int pinsLastRound_One = 10;
	int pinsLastRound_Two = 10;

	List<Rounds> output = Bowling.sourceMethodForTest(roundListTest,
		pinsLastRound_One, pinsLastRound_Two);

	assertEquals(output.get(0).getIsStrike(), false);
	assertEquals(output.get(0).getIsSpare(), false);
	assertEquals(output.get(0).getIsScoreFinal(), true);
	assertEquals(output.get(0).getScore(), 5);

	assertEquals(output.get(1).getIsStrike(), false);
	assertEquals(output.get(1).getIsSpare(), false);
	assertEquals(output.get(1).getIsScoreFinal(), true);
	assertEquals(output.get(1).getScore(), 14);

	assertEquals(output.get(2).getIsStrike(), false);
	assertEquals(output.get(2).getIsSpare(), false);
	assertEquals(output.get(2).getIsScoreFinal(), true);
	assertEquals(output.get(2).getScore(), 21);

	assertEquals(output.get(3).getIsStrike(), true);
	assertEquals(output.get(3).getIsSpare(), false);
	assertEquals(output.get(3).getIsScoreFinal(), true);
	assertEquals(output.get(3).getScore(), 46);

	assertEquals(output.get(4).getIsStrike(), true);
	assertEquals(output.get(4).getIsSpare(), false);
	assertEquals(output.get(4).getIsScoreFinal(), true);
	assertEquals(output.get(4).getScore(), 66);

	assertEquals(output.get(5).getIsStrike(), false);
	assertEquals(output.get(5).getIsSpare(), true);
	assertEquals(output.get(5).getIsScoreFinal(), true);
	assertEquals(output.get(5).getScore(), 76);

	assertEquals(output.get(6).getIsStrike(), false);
	assertEquals(output.get(6).getIsSpare(), false);
	assertEquals(output.get(6).getIsScoreFinal(), true);
	assertEquals(output.get(6).getScore(), 76);

	assertEquals(output.get(7).getIsStrike(), false);
	assertEquals(output.get(7).getIsSpare(), false);
	assertEquals(output.get(7).getIsScoreFinal(), true);
	assertEquals(output.get(7).getScore(), 85);

	assertEquals(output.get(8).getIsStrike(), false);
	assertEquals(output.get(8).getIsSpare(), true);
	assertEquals(output.get(8).getIsScoreFinal(), true);
	assertEquals(output.get(8).getScore(), 105);

	assertEquals(output.get(9).getIsStrike(), true);
	assertEquals(output.get(9).getIsSpare(), false);
	assertEquals(output.get(9).getIsScoreFinal(), true);
	assertEquals(output.get(9).getScore(), 135);

	roundListTest.clear();
	output.clear();

    }

    @Test
    public void testBowlScoringThree() {

	// Test Case for the following sequence: "XXXXXXXXXXXX"
	
	List<Rounds> roundListTest = new ArrayList<Rounds>(10);

	Rounds round1 = new Rounds();
	round1.setFirstToss(10);
	round1.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round1);

	Rounds round2 = new Rounds();
	round2.setFirstToss(10);
	round2.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round2);

	Rounds round3 = new Rounds();
	round3.setFirstToss(10);
	round3.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round3);

	Rounds round4 = new Rounds();
	round4.setFirstToss(10);
	round4.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round4);

	Rounds round5 = new Rounds();
	round5.setFirstToss(10);
	round5.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round5);

	Rounds round6 = new Rounds();
	round6.setFirstToss(10);
	round6.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round6);

	Rounds round7 = new Rounds();
	round7.setFirstToss(10);
	round7.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round7);

	Rounds round8 = new Rounds();
	round8.setFirstToss(10);
	round8.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round8);

	Rounds round9 = new Rounds();
	round9.setFirstToss(10);
	round9.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round9);

	Rounds round10 = new Rounds();
	round10.setFirstToss(10);
	round10.setSecondToss(Integer.MIN_VALUE);
	roundListTest.add(round10);

	int pinsLastRound_One = 10;
	int pinsLastRound_Two = 10;

	List<Rounds> output = Bowling.sourceMethodForTest(roundListTest,
		pinsLastRound_One, pinsLastRound_Two);

	assertEquals(output.get(0).getIsStrike(), true);
	assertEquals(output.get(0).getIsSpare(), false);
	assertEquals(output.get(0).getIsScoreFinal(), true);
	assertEquals(output.get(0).getScore(), 30);

	assertEquals(output.get(1).getIsStrike(), true);
	assertEquals(output.get(1).getIsSpare(), false);
	assertEquals(output.get(1).getIsScoreFinal(), true);
	assertEquals(output.get(1).getScore(), 60);

	assertEquals(output.get(2).getIsStrike(), true);
	assertEquals(output.get(2).getIsSpare(), false);
	assertEquals(output.get(2).getIsScoreFinal(), true);
	assertEquals(output.get(2).getScore(), 90);

	assertEquals(output.get(3).getIsStrike(), true);
	assertEquals(output.get(3).getIsSpare(), false);
	assertEquals(output.get(3).getIsScoreFinal(), true);
	assertEquals(output.get(3).getScore(), 120);

	assertEquals(output.get(4).getIsStrike(), true);
	assertEquals(output.get(4).getIsSpare(), false);
	assertEquals(output.get(4).getIsScoreFinal(), true);
	assertEquals(output.get(4).getScore(), 150);

	assertEquals(output.get(5).getIsStrike(), true);
	assertEquals(output.get(5).getIsSpare(), false);
	assertEquals(output.get(5).getIsScoreFinal(), true);
	assertEquals(output.get(5).getScore(), 180);

	assertEquals(output.get(6).getIsStrike(), true);
	assertEquals(output.get(6).getIsSpare(), false);
	assertEquals(output.get(6).getIsScoreFinal(), true);
	assertEquals(output.get(6).getScore(), 210);

	assertEquals(output.get(7).getIsStrike(), true);
	assertEquals(output.get(7).getIsSpare(), false);
	assertEquals(output.get(7).getIsScoreFinal(), true);
	assertEquals(output.get(7).getScore(), 240);

	assertEquals(output.get(8).getIsStrike(), true);
	assertEquals(output.get(8).getIsSpare(), false);
	assertEquals(output.get(8).getIsScoreFinal(), true);
	assertEquals(output.get(8).getScore(), 270);

	assertEquals(output.get(9).getIsStrike(), true);
	assertEquals(output.get(9).getIsSpare(), false);
	assertEquals(output.get(9).getIsScoreFinal(), true);
	assertEquals(output.get(9).getScore(), 300);

	roundListTest.clear();
	output.clear();

    }
}
