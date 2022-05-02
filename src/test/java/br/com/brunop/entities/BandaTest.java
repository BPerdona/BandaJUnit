package br.com.brunop.entities;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BandaTest {
	private static Musico musico1;
	private static Musico musico2;
	private static Musico musico3;
	private static Musico musico4;
	private static Musico musico5;
	private static Banda banda;
	
	@BeforeClass
	public static void inicializando() {
		musico1 = new Musico("Bruno", 21, "Baixo", 4);
		musico2 = new Musico("Willian", 22, "Vocal", 4);
		musico3 = new Musico("Daniel", 21, "Guitarra", 6);
		musico4 = new Musico("Larissa", 20, "Bateria", 4);
		musico5 = new Musico("Elian", 20, "Guitarra", 7);
		banda = new Banda("PepperHaus", "Rock", 4);
	}
	
	//Adicionando musico null
	@Test
	public void adicionandoMusicoNull() {
		assertEquals(false, banda.adicionarMembro(null));
	}
	
	//Removendo musico passando parametro null
	@Test
	public void removendoMusico() {
		assertThrows(NullPointerException.class, () -> {
			banda.removerMembro(null);
		});
	}
	
	//Nessa versão não tem Disabled então usei Ignore
	@Test
	@Ignore
	public void calculandoMediaSemMusicos() {
		assertEquals(0, banda.notaMedia(), 0);
	}
	
	//Adicionando os musicos
	@Test
	public void adicionandoMusicosNormais() {
		assertEquals(true, banda.adicionarMembro(musico1));
		assertEquals(true, banda.adicionarMembro(musico2));
		assertEquals(true, banda.adicionarMembro(musico3));
		assertEquals(true, banda.adicionarMembro(musico4));
		assertEquals(true, banda.adicionarMembro(musico5));
	}
	
	//Calculando media
	@Test
	public void calculandoMediaComMusicos() {
		assertEquals(5.0, banda.notaMedia(), 0);
	}
	
	//contando show
	@Test
	public void contandoShowVazio() {
		assertEquals(0, banda.contarShow());
	}
	
	//Adicionando shows
	@Test
	public void adicionandoShows() {
		assertEquals(true, banda.marcarShow("01-01"));
		assertEquals(false, banda.marcarShow("01-01"));
		assertEquals(false, banda.marcarShow("01-222"));
		assertEquals(true, banda.marcarShow("05-08"));
		assertEquals(true, banda.marcarShow("11-11"));
		assertEquals(true, banda.marcarShow("12-12"));
	}
	
	//contando show normais
	@Test
	public void contandoShows() {
		assertEquals(4, banda.contarShow());
	}
}
