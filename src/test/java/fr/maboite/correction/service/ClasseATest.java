package fr.maboite.correction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.maboite.correction.MaClasseDeConfiguration;
import fr.maboite.mesclasses.ClasseA;
import fr.maboite.mesclasses.ClasseB;

@SpringJUnitConfig(MaClasseDeConfiguration.class)
public class ClasseATest {

	@Autowired
	private ClasseA classeA;
	
	@Test
	public void testSayHello() {
		classeA.sayHello();
		ClasseB classeB = classeA.getClasseB();
		Assertions.assertNotNull(classeB);
	}
	
}
