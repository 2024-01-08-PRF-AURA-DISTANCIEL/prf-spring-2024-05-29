package fr.maboite.mesclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClasseA {

	@Autowired
	private ClasseB classeB;

	public ClasseB getClasseB() {
		return classeB;
	}

	public void setClasseB(ClasseB classeB) {
		this.classeB = classeB;
	}

	public void sayHello() {
		System.out.println("Salut de la classe A");
	}
	
	public void traitementAvecClasseB() {
		System.out.println("Je commence le traitement");
		this.classeB.sayHello();
	}
	
}
