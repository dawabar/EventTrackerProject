package com.skilldistillery.chores.entities;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.chores.entities.Chore;

class ChoreTest {

	private static EntityManagerFactory emf;

	private EntityManager em;

	private Chore chore;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		emf = Persistence.createEntityManagerFactory("ChoresJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		chore = em.find(Chore.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		chore = null;
	}

	@Test
	void test_Chore_entity_mapping() {
		assertNotNull(chore);
		assertEquals("Take out the trash", chore.getName());
	}

}