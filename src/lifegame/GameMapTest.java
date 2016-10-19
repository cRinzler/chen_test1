package lifegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameMapTest {
    private static GameMap gamemap=new GameMap();
	@Before
	public void setUp() throws Exception {
		gamemap.initalMap();
	}

	@Test
	public void testGetAroundCellNum(){	
	//fail("Not yet implemented");
		gamemap.setCellStatus(0, 0, 1);
		gamemap.setCellStatus(0, 1, 1);
		gamemap.setCellStatus(1, 0, 1);
		
		assertEquals(3,gamemap.getAroundCellNum(1,1));
	}

	@Test
	public void testChangeCellStatus(){
		gamemap.setCellStatus(0, 0, 1);
		gamemap.setCellStatus(0, 1, 1);
		gamemap.setCellStatus(1, 0, 1);
		gamemap.setCellStatus(1, 1, 0);
		gamemap.changeCellStatus();
		assertEquals(1,gamemap.getCellStatus(1,1));
		assertEquals(1,gamemap.getCellStatus(0,1));
		assertEquals(1,gamemap.getCellStatus(1,0));
		assertEquals(1,gamemap.getCellStatus(0,0));
		//int testMap[][]= new int[gamemap.MAX_ROW][gamemap.MAX_LINE];
		//testMap[0][0]=1;
	  //  testMap[0][1]=1;
	   // testMap[1][0]=1;
	  //  testMap[1][1]=1;
	    
	   // assertEquals(testMap,gamemap.getCellMap());
		
	//fail("Not yet implemented");
	}

}
