package Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class UnitTest {
	
	@Test
	void shouldSave() {
		File file =  new File("shouldSave.dat");
		POOgger poogger = POOgger.getPoogger();
		poogger.setMapType("Night");
		poogger.save(file);
	}
	
	
	@Test
	void shouldOpen() {
		File file =  new File("shouldSave.dat");
		POOgger poogger = POOgger.getPoogger();
		poogger.open(file);
	}
	
	@Test
	void shouldMoveFrogAtNorth() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		int[] posA = frog.getPosition();
		frog.jump('U');
		posA[1] -= 50;
		int[] posB = frog.getPosition();
		assertEquals(posA[0] + "," + posA[1], posB[0] + "," + posB[1]);
	}
	
	@Test
	void shouldMoveFrogAtSouth() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		frog.jump('U');
		int[] posA = frog.getPosition();		
		frog.jump('D');
		posA[1] += 50;
		int[] posB = frog.getPosition();
		assertEquals(posA[0] + "," + posA[1], posB[0] + "," + posB[1]);
	}
	
	@Test
	void shouldMoveFrogAtLeft() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		int[] posA = frog.getPosition();
		frog.jump('L');
		posA[0] -= 50;
		int[] posB = frog.getPosition();
		assertEquals(posA[0] + "," + posA[1], posB[0] + "," + posB[1]);
	}
	
	@Test
	void shouldMoveFrogAtRight() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		int[] posA = frog.getPosition();
		frog.jump('R');
		posA[0] += 50;
		int[] posB = frog.getPosition();
		assertArrayEquals(posA, posB);
	}
	
	@Test
	void shouldFinishGameWhenTimeIsZero() {
		POOgger poogger = POOgger.getPoogger();
		poogger.setTime(1);
		int time = poogger.getTime();
		while (poogger.isRunning) {
			poogger.update();
		}
		assertEquals(poogger.isRunning, false);
	}
	
	@Test
	void shouldFinishGameWhenLifesIsZero() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		while (poogger.isRunning) {
			poogger.update();
			frog.restart();
		}
		poogger.update();
		assertEquals(poogger.isRunning && frog.getLifes()==0, false);
	}
	
	/*
	@Test
	void shouldIntersects() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		ArrayList<Movable> m = poogger.getMovables();
		Movable c = m.get(m.size()-1);
		c.setPosition(347, c.yPosition);
		frog.jump('U');
		System.out.println(frog.getPosition()[0] + "" + frog.getPosition()[0]);
		poogger.update();
		boolean initPos = frog.getPosition().equals(new int[]{347, 617});
		assertEquals(initPos && frog.getLifes()==lifes-1, true);	
	}*/
	
	@Test
	void shouldDeadInWater() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		frog.setLifes(1);
		int lanes = 5;
		while (lanes > 0) {
			frog.jump('U');
			lanes--;
		}
		poogger.update();
		assertEquals(poogger.isRunning && frog.getLifes()==0, false);
	}
	
	@Test
	void shouldBeInScreenRange() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		
		int lanes = 7;
		while (lanes > 0) {
			frog.jump('D');
			frog.jump('L');
			lanes--;
		}
		poogger.update();
		assertEquals(frog.stillInRange(), true);
	}
	
	@Test
	void shouldMoveOnlyOneCharacter() {
		POOgger poogger = POOgger.getPoogger();
		poogger.setMode("Player vs Player");
		
		Frog frog1 = poogger.getCharacters()[0];		
		Frog frog2 = poogger.getCharacters()[1];
		
		int[] frog1Init = frog1.getPosition();
		frog2.jump('U');
		
		assertArrayEquals(frog1Init, frog1.getPosition());
	}
	
	@Test
	void shouldSetMode() {
		POOgger poogger = POOgger.getPoogger();
		poogger.setMode("Player vs Player");
		assertEquals(poogger.getMode(), "Player vs Player");
	}
	
	@Test
	void shouldSetMap() {
		POOgger poogger = POOgger.getPoogger();
		poogger.setMapType("Night");
		assertEquals(poogger.getMapType(), "Night");
	}
	
	@Test
	void shouldSetTime() {
		POOgger poogger = POOgger.getPoogger();
		poogger.setTime(60);
		assertEquals(poogger.getTime(), 60);
	}
	
	@Test
	void shouldSetFrogLifes() {
		POOgger poogger = POOgger.getPoogger();
		Frog frog = poogger.getCharacters()[0];
		frog.setLifes(1);
		assertEquals(frog.getLifes(), 1);
	}
	
}
