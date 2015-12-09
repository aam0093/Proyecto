package test;

import static org.junit.Assert.*;

import org.junit.Test;

import problemas.SubsecuenciaComun;

public class SubsecuenciaComunTest {

	SubsecuenciaComun lcs = new SubsecuenciaComun(7,10);
	@Test
	public void testSubsecuenciaComun() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValid() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCadena1() {
		assert lcs.getCadena1().length() == 7;
	}

	@Test
	public void testGetCadena2() {
		assert lcs.getCadena1().length() == 10;
	}

	@Test
	public void testGetMaxLenght() {
		int [][] testMatriz = lcs.getMatriz();
		assert testMatriz[7][10] == lcs.getMaxLenght();
	}

	@Test
	public void testGetResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatriz() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTipo() {
		assert lcs.getTipo() == "SUBSECUENCIA";
	}

	@Test
	public void testExecute() {
		fail("Not yet implemented");
	}

}
