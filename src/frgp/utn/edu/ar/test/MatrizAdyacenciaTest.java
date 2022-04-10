package frgp.utn.edu.ar.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import frgp.utn.edu.ar.main.MatrizAdyacencia;


public class MatrizAdyacenciaTest {
	
	MatrizAdyacencia mAdyacencia = new MatrizAdyacencia(4);
	
	@Test
	public void agregarElementoTest() {
		mAdyacencia.agregarElemento(3, 0);
		assertTrue(mAdyacencia.existeElemento(3,0));
	}
	
	@Test
	public void agregarElementoSimetriaTest() {
		mAdyacencia.agregarElemento(3, 0);
		assertTrue(mAdyacencia.existeElemento(0,3));
	}
}