package br.com.lucas.page;
import org.openqa.selenium.By;

import br.com.lucas.core.BasePage;

public class CampoTreinamentoPage extends BasePage {
	
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}
	
	public void setSobreNome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setComidaPizza() {
		dsl.clicarNoChekBox("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegetariano() {
		dsl.clicarNoChekBox("elementosForm:comidaFavorita:3");
	}
	
	public void setComidaCarne() {
		dsl.clicarNoChekBox("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaFrango() {
		dsl.clicarNoChekBox("elementosForm:comidaFavorita:1");
	}
	
	public void setEscolaridade(String grauDeEscolaridade) {
		dsl.selecionaOCombo("elementosForm:escolaridade", grauDeEscolaridade);
	}
	
	public void setEsporte(String... esportes) {
		for(String valor: esportes) {
			dsl.selecionaOCombo("elementosForm:esportes", valor);
		}	
	}
	
	public void cadastrar() {
		dsl.clicarNoButao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro(){
		return dsl.obterTexto(By.xpath(".//*[@id='resultado']/span"));
	}
	
	public String obterNomeCadastro(){
		return dsl.obterTexto(By.xpath(".//*[@id='descNome']/span"));
	}
	
	public String obterSobreNomeCadastro(){
		return dsl.obterTexto(By.xpath(".//*[@id='descSobrenome']/span"));
	}
	
	public String obterSexoDoCadastro() {
		return dsl.obterTexto(By.xpath(".//*[@id='descSexo']/span"));
	}
	
	public String obterComidaDoCadastro() {
		return dsl.obterTexto(By.xpath(".//*[@id='descComida']/span"));
	}
	
	public String obterEscolaridadeDoCadastro() {
		return dsl.obterTexto(By.xpath(".//*[@id='descEscolaridade']/span"));
	}
	
	public String obterEsportesDoCadastro() {
		return dsl.obterTexto(By.xpath(".//*[@id='descEsportes']/span"));
	}
	
	public String obterSugestoesDoCadastro() {
		return dsl.obterTexto(By.xpath(".//*[@id='descSugestoes']"));
	}
	
	public String  botaoFrame() {
		return dsl.testaButaFrame("frame2", "frameButton");
	}
}
