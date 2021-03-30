package br.com.lucas.test;
import static br.com.lucas.core.DriverFactory.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.lucas.core.BaseTest;
import br.com.lucas.core.DSL;
import br.com.lucas.page.CampoTreinamentoPage;


public class TestCadastrarUsuario extends BaseTest {
	
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void setUp() {
			
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
	}
	

	@Test
	public void nomeObrigatorioTest() {
		page.setNome("");
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
	}
	
	@Test
	public void sobreNomeObrigatorioTest() {
		page.setNome("Lucas");
		page.setSobreNome("");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void sexoObrigatorioTest() {
		page.setNome("Lucas");
		page.setSobreNome("Emanuel");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());

	}
	
	@Test
	public void validarComidaFavoritaDoVegetariano() {
		page.setNome("Lucas");
		page.setSobreNome("Emanuel");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());

	}
	
	@Test
	public void validarSeOTipoDeEsporteEMarcadoEPerguntado() {
		page.setNome("Lucas");
		page.setSobreNome("Emanuel");
		page.setSexoMasculino();
		page.setComidaCarne();
		
		page.setEsporte("Futebol", "O que eh esporte?");
		page.cadastrar();
				
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
		
	}
	
	@Test
	public void cadastroDeSucesso() {
		page.setNome("Lucas");
		page.setSobreNome("Emanuel");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.cadastrar();
		
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Lucas",page.obterNomeCadastro());
		Assert.assertEquals("Emanuel", page.obterSobreNomeCadastro());
		Assert.assertEquals("Masculino",page.obterSexoDoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaDoCadastro());
		Assert.assertEquals("superior", page.obterEscolaridadeDoCadastro());
		Assert.assertEquals("Futebol", page.obterEsportesDoCadastro());
		Assert.assertEquals("Sugestoes:", page.obterSugestoesDoCadastro());
	}
	
	//@Test
	public void testandoBotaoFrame() {
		page.botaoFrame();
	}

	
}
