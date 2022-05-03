package br.com.brunop.entities;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.AfterClass;
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
		System.out.println("Iniciando classes");
		musico1 = new Musico("Bruno", 21, "Baixo", 4);
		musico2 = new Musico("Willian", 22, "Vocal", 4);
		musico3 = new Musico("Daniel", 21, "Guitarra", 6);
		musico4 = new Musico("Larissa", 20, "Bateria", 4);
		musico5 = new Musico("Elian", 20, "Guitarra", 7);
		banda = new Banda("PepperHaus", "Rock", 4);
	}
	
	@Test
	public void adicionandoMusicoNull() {
		System.out.println("Adicionando musico Null");
		assertEquals(false, banda.adicionarMembro(null));
	}
	
	@Test
	public void removendoMusicoNull() {
		System.out.println("Removendo musico Null");
		assertThrows(NullPointerException.class, () -> {
			banda.removerMembro(null);
		});
	}
	
	@Ignore
	@Test
	public void calculandoMediaSemMusicos() {
		System.out.println("Calculando media da banda sem musicos");
		assertEquals(0, banda.notaMedia(), 0);
	}
	
	@Test
	public void adicionandoMusicosNormais() {
		System.out.println("Adicionando musicos normais");
		assertEquals(true, banda.adicionarMembro(musico1));
		assertEquals(true, banda.adicionarMembro(musico2));
		assertEquals(true, banda.adicionarMembro(musico3));
		assertEquals(true, banda.adicionarMembro(musico4));
		assertEquals(true, banda.adicionarMembro(musico5));
	}

	@Test
	public void calculandoMediaComMusicos() {
		System.out.println("Calculando nota media com musicos");
		assertEquals(5.0, banda.notaMedia(), 0);
	}

	@Test
	public void contandoShowVazio() {
		System.out.println("Contando shows sem ter show");
		assertEquals(0, banda.contarShow());
	}
	
	@Test
	public void adicionandoShows() {
		System.out.println("Marcando shows");
		assertEquals(true, banda.marcarShow("01-01"));
		assertEquals(false, banda.marcarShow("01-01"));
		assertEquals(false, banda.marcarShow("01-222"));
		assertEquals(true, banda.marcarShow("05-08"));
		assertEquals(true, banda.marcarShow("11-11"));
		assertEquals(true, banda.marcarShow("12-12"));
	}
	
	@Test
	public void contandoShows() {
		System.out.println("Contando Shows");
		assertEquals(4, banda.contarShow());
	}
	
	@AfterClass
	public static void removendoMusicos() {
		assumeTrue(banda.getMusicos().size() > 0);
		System.out.println("Removendo todos os membros");
		for(int i=0; i<banda.getMusicos().size(); i++) {
			banda.removerMembro(banda.getMusicos().get(i).getNome());
		}
		System.out.println("Limpando lista por garantia");
		banda.getMusicos().clear();
	}
}
