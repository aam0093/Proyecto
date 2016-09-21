package test;



import org.junit.Test;

import problemas.Problema;
import problemas.SubsecuenciaComun;

public class SubsecuenciaComunTest {

	SubsecuenciaComun lcs = new SubsecuenciaComun(7,10);


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
	public void testGetTipo() {
		assert lcs.getTipo() == "SUBSECUENCIA";
	}

	@Test
	public void testExecute() {
		String res = lcs.execute();
		int [][] testMatriz = lcs.getMatriz();
		assert res.length() == testMatriz[7][10];
	}

}
