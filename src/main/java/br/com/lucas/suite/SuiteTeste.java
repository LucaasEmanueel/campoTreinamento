package br.com.lucas.suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.lucas.core.DriverFactory;
import br.com.lucas.test.TestCadastrarUsuario;
import br.com.lucas.test.TestesRegrasCadastro;

@RunWith(Suite.class)

@SuiteClasses({
	TestCadastrarUsuario.class,
	TestesRegrasCadastro.class
})
public class SuiteTeste {
	
	public static void finalizaTudo() {
			DriverFactory.killDriver();
	}

}
