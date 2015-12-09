package test;

import static org.junit.Assert.*;
import org.junit.After;  
import org.junit.Before;  
import org.junit.Test;

import problemas.Knapsack;

public class KnapsackTest {

	public Knapsack mochila;
	
	@Test
	public void testKnapsack() {
		mochila = new Knapsack (10,5);
		assert mochila.getCapacity() == 10;
		assert mochila.getNumElements() == 5;
		assert mochila.getTipo() == "MOCHILA";
	}

}
