package br.com.brunop.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

public class MusicoTest {
	public static Musico musico = new Musico("Bruno", 21,"Baixo", 6);

	@After
	public void verificaNull() {
		System.out.println("Verificando se não foi inserido um null");
		assertNotEquals(null, musico.getNome());
		assertNotEquals(null, musico.getIdade());
		assertNotEquals(null, musico.getInstrumento());
		assertNotEquals(null, musico.getNota());
	}
	
	@Test
	public void getInstrumento() {
		System.out.println("Pegendo Instrumento");
		assertEquals("Baixo", musico.getInstrumento());
	}
	
	@Test 
	public void setNota4(){
		System.out.println("Setando nota normal");
		musico.setNota(4);
		assertEquals(4, musico.getNota());
	}
	
	@Test
	public void setNotaNegativo1() {
		System.out.println("Setando nota Negativa");
		musico.setNota(-1);
		assertNotEquals(-1, musico.getNota());
	}
	
	@Test
	public void setNota11() {
		System.out.println("Setando nota fora do padrão");
		musico.setNota(11);
		assertNotEquals(11, musico.getNota());
	}
	
	@Test
	public void getDescricaoNull() {
		System.out.println("Pegando descrição null");
		assertNull(musico.getDescricao());
	}
	
	@Test
	public void GroupMarcar() {
		System.out.println("Executando sequencia");
		boolean[] esperado = {true, true, false, false, false};
		boolean[] executado = {
				musico.getNome() == "Bruno",
				musico.getIdade() == 21,
				musico.getNota() > 11,
				musico.getNota() < 0,
				musico.getInstrumento() == "Bateria"
				
		};
		assertArrayEquals(esperado, executado);
	}
	
	@Ignore
	@Test
	public void setandoNull() {
		musico.setNome(null);
	}
	
}








