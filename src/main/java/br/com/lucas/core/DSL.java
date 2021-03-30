package br.com.lucas.core;
import static br.com.lucas.core.DriverFactory.*;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
		
	public void escrever(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).clear();
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorDoCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String id_radio) {
		clicarRadio(By.id(id_radio));
	}
		
	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarNoChekBox( String id_checkbox) {
		getDriver().findElement(By.id(id_checkbox)).click();
	}
	
	public boolean isCheckboxMarcado(String id_checkbox) {
		return getDriver().findElement(By.id(id_checkbox)).isSelected();
	}
	
	public void selecionaOCombo(String id, String nomedoCampo) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(nomedoCampo);
	}
	
	public void selecionaOValorDoCombo(String id, String nomedoCampo) {
		WebElement elemento = getDriver().findElement(By.id(id));
		Select combo = new Select(elemento);
		combo.selectByValue(nomedoCampo);
	}
	
	public String valorDoCombo(String id_combo) {
		WebElement elemento = getDriver().findElement(By.id(id_combo));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void obterComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='"+radical+"_input']//..//..//span"));
		clicarRadio(By.xpath("//*[@id='"+radical+"_items']/li[.='"+valor+"']"));
	}
	
	public void clicarNoButao(String id_button) {
		getDriver().findElement(By.id(id_button)).click();
	}
	
	public String valorDoButton(String id_button) {
		return getDriver().findElement(By.id(id_button)).getAttribute("Value");
	}
	
	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}
	
	public String resultadoDoLink(String id) {
		return getDriver().findElement(By.id(id)).getText();
	}
	
	public boolean verificaOnome(By by) {
		return getDriver().findElement(by)
		.getText().contains("Campo de Treinamento");
	}
		
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
		
	public String alertaObterTextoEAceita(){
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;	
	}
	

	public String testaButaFrame(String butao, String frame) {
		
		getDriver().switchTo().frame("frame2");
		getDriver().findElement(By.id("frameButton")).click();
		String msg = getDriver().findElement(By.id("frameButton")).getText();
		getDriver().switchTo().alert().accept();
		return msg;

	}
	
	/**************************JS******************************/
	
	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	/***************************TABELA**************************/
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+ idTabela +"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botão
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botão da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]//td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}
	
	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idcoluna = -1;
		
		for(int i=0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idcoluna= ++i;
				break;
			}
		}
		return idcoluna;
	}
	
	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idlinha = -1;
		
		for(int i=0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idlinha= ++i;
				break;
			}
		}
		return idlinha;
	}
	
	

}
