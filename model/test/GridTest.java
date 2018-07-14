package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import model.Position;

public class GridTest {
	Grid grid;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		grid = new Grid(new WallEnum.GROUND new Position(1,1));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void MinWidthPositionRangeTest(){
		try{
			new Floor(new Sprite('F'), Permeability.BLOCKING, new Position(0,1));
			fail("Should not throw exception when width < 0");
		} catch (final Exception e) {
			final String expected = "Position out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	@Test
	public void MinHeightPositionRangeTest(){
		try{
			new Floor(new Sprite('F'), Permeability.BLOCKING, new Position(1,0));
			fail("Should not throw exception when height < 0");
		} catch (final Exception e) {
			final String expected = "Position out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	@Test
	public void MaxWidthPositionRangeTest(){
		try{
			new Floor(new WallEnum.GROUND, new Position(600,1));
			fail("Should not throw exception when width > 600");
		} catch (final Exception e) {
			final String expected = "Position out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	@Test
	public void MaxHeightPositionRangeTest(){
		try{
			new Floor(new WallEnum.GROUND, new Position(1,400));
			fail("Should not throw exception when heiht > 400");
		} catch (final Exception e) {
			final String expected = "Position out of range";
			assertEquals(expected, e.getMessage());
		}
	}
}
