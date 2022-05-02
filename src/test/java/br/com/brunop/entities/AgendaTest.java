package br.com.brunop.entities;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class AgendaTest {
	private static Agenda agen1 = new Agenda();
	
	@BeforeClass
	public static void antesDeTodos() {
		agen1.marcarShow("01-01", "RHCP");
		agen1.marcarShow("01-02", "Queen");
		agen1.marcarShow("01-03", "Metallica");
		agen1.marcarShow("02-05", "Eminem");
		agen1.marcarShow("01-11", "Alice in Chains");
	}
	
	//Verifica em cada caso se a agenda está ativa
	@Before
	public void listaAtiva() {
		assumeFalse(agen1.isAtivo()==false);
	}

	//Agrupamento de assertions
	@Test
	public void GroupDesmarcar() {
		assertEquals(true, agen1.desmarcarShow("01-01", "RHCP"));
		assertEquals(true, agen1.desmarcarShow("01-02", "Queen"));
		assertEquals(true, agen1.desmarcarShow("01-03", "Metallica"));
		assertEquals(true, agen1.desmarcarShow("02-05", "Eminem"));
		assertEquals(false, agen1.desmarcarShow("11-11", "Alice in Chains"));
	}
	
	//Implementando Timeout
	@Test(timeout=15)
	public void GroupMarcar() {
		boolean[] esperado = {false, true, false, true, true, false, false};
		boolean[] executado = {
				agen1.marcarShow("02-022", "Nirvana"),
				agen1.marcarShow("07-02", "Nirvana"),
				agen1.marcarShow("01-11", "Foo Fighters"),
				agen1.marcarShow("30-06", "Rage Agains the Machine"),
				agen1.marcarShow("26-07", "Red Hot Chili Peppers"),
				agen1.marcarShow("26--07", "Black Sabbath"),
				agen1.marcarShow("30-7", "Pink Floyd"),
		};
		assertArrayEquals(esperado, executado);
	}
	
	@AfterClass
	public static void contarShows() {
		//Após executar todos os testes apenas 4 shows ficaram marcados
		assertEquals(4, agen1.contarShows());
	}
}
