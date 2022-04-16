package frgp.utn.edu.ar.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
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
	
	@Test
	public void eliminarElementoTest() {
		// Agregamos los elementos que no tengan simetricos para probar el metodo
		mAdyacencia.agregarElemento(0, 0);
		mAdyacencia.agregarElemento(0, 1);
		mAdyacencia.agregarElemento(0, 2);
		mAdyacencia.agregarElemento(1, 1);
		mAdyacencia.agregarElemento(2, 2);
		// Eliminamos los elementos que no tengan simetricos
		mAdyacencia.eliminarElemento(0, 0);
		mAdyacencia.eliminarElemento(0, 1);
		mAdyacencia.eliminarElemento(0, 2);
		mAdyacencia.eliminarElemento(1, 1);
		mAdyacencia.eliminarElemento(2, 2);
		assertAll(
				"Metodo eliminarElementoTest()",
			() -> assertFalse(mAdyacencia.existeElemento(0,0)),
			() -> assertFalse(mAdyacencia.existeElemento(0,1)),
			() -> assertFalse(mAdyacencia.existeElemento(0,2)),
			() -> assertFalse(mAdyacencia.existeElemento(1,1)),
			() -> assertFalse(mAdyacencia.existeElemento(2,2))
		);
	}
	
	@Test
	public void eliminarElementoSimetricoTest() {
		mAdyacencia.agregarElemento(1, 0);
		mAdyacencia.agregarElemento(1, 2);
		mAdyacencia.agregarElemento(2, 0);
		mAdyacencia.agregarElemento(2, 1);
		
		mAdyacencia.eliminarElemento(1, 0);
		mAdyacencia.eliminarElemento(1, 2);
		mAdyacencia.eliminarElemento(2, 0);
		mAdyacencia.eliminarElemento(2, 1);
		
		assertAll(
				"Metodo eliminarElementoSimetricoTest()",
			() -> assertFalse(mAdyacencia.existeElemento(1,0)),
			() -> assertFalse(mAdyacencia.existeElemento(1,2)),
			() -> assertFalse(mAdyacencia.existeElemento(2,0)),
			() -> assertFalse(mAdyacencia.existeElemento(2,1))
		);
	}

	@Test
	public void contarRelacionesTest() {
		mAdyacencia.agregarElemento(0, 3);
		mAdyacencia.agregarElemento(1, 2);
		mAdyacencia.agregarElemento(2, 3);
		assertEquals(3, mAdyacencia.getCantidadElementos());
	}
	
	@Test
	public void existenTodosLosElementosTest() {
		mAdyacencia.agregarElemento(0, 1);
		mAdyacencia.agregarElemento(0, 2);
		mAdyacencia.agregarElemento(0, 3);
		mAdyacencia.agregarElemento(1, 2);
		mAdyacencia.agregarElemento(1, 3);
		mAdyacencia.agregarElemento(2, 3);
		
		if (mAdyacencia.getCantidadElementos()==6)
		{
			assertFalse(mAdyacencia.existeElemento(0,0));
			assertFalse(mAdyacencia.existeElemento(1,1));
			assertFalse(mAdyacencia.existeElemento(2,2));
			assertFalse(mAdyacencia.existeElemento(3,3));
		}
	}
	
	
	
	
	
}