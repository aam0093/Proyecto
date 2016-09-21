package test;

import static org.junit.Assert.fail;

import org.junit.Test;

import problemas.Knapsack;
import problemas.SubsecuenciaComun;

public class KnapsackTest {
	Knapsack mochila = new Knapsack(15,5);


	@Test
	public void testExecute() {
		mochila.execute();
		assert mochila.getMatrix() != null;
	}

	@Test
	public void testGetCapacity() {
		assert mochila.getCapacity() == 15;
	}


	@Test
	public void testGetNumElements() {
		assert mochila.getNumElements() == 5;
	}


}
