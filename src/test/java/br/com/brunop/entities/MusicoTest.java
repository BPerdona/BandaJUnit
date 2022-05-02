package br.com.brunop.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

public class MusicoTest {
	
	public static Musico musico = new Musico("Bruno", 21,"Baixo", 6);
	
	@After
	public void after() {
		musico.receberDinheiro(15.0);
	}
	
	@AfterClass
	public static void afterAll() {
		System.out.println(musico.getNome());
	}
	
	// AssertEquals
	@Test
	public void getInstrumento() {
		assertEquals("Baixo", musico.getInstrumento());
	}
	
	@Test 
	public void setNota4(){
		musico.setNota(4);
		assertEquals(4, musico.getNota());
	}
	
	// AssertNotEquals
	@Test
	public void setNotaNegativo1() {
		musico.setNota(-1);
		assertNotEquals(-1, musico.getNota());
	}
	
	@Test
	public void setNota11() {
		musico.setNota(11);
		assertNotEquals(11, musico.getNota());
	}
	
}








