/*
 * Instituto Federal de Educação, Ciência e Tecnologia da Paraíba
 * Campus Campina Grande
 * Componente Curricular: Desenvolvimento Web
 * 
 * Sistema de Locadora WEB
 * 
 * @author Hallyson Gustavo, Vinicius Fernandes
 * 
 * 
 */

package locadora.logica;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Emprestimo {

	private int idLocacao;
	private int idCliente;
	private Date data;
	private int idProduto1;
	private int idProduto2;
	private int idProduto3;
	private double total;
	
	

	/**
	 * 
	 * @return id da locação
	 */
	public int getIdLocacao() {
		return idLocacao;
	}

	/**
	 * Set id da locação
	 * @param idLocacao
	 */
	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
	}

	/**
	 * 
	 * @return id do cliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * Set id do cliente
	 * @param idCliente
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * 
	 * @return data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Set a data atual
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * 
	 * @return id do produto 1
	 */
	public int getIdProduto1() {
		return idProduto1;
	}

	/**
	 * Set id do produto 1 
	 * @param idProduto1
	 */
	public void setIdProduto1(int idProduto1) {
		this.idProduto1 = idProduto1;
	}

	/**
	 * 
	 * @return id do produto 2
	 */
	public int getIdProduto2() {
		return idProduto2;
	}

	/**
	 * Set id do produto 2 
	 * @param idProduto2
	 */
	public void setIdProduto2(int idProduto2) {
		this.idProduto2 = idProduto2;
	}
	

	/**
	 * 
	 * @return id do produto 3
	 */
	public int getIdProduto3() {
		return idProduto3;
	}

	/**
	 * Set id do produto 3 
	 * @param idProduto3
	 */
	public void setIdProduto3(int idProduto3) {
		this.idProduto3 = idProduto3;
	}

	/**
	 * 
	 * @return total do valor das locações
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Set valor total das locações
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	public void realizaEmprestimo(){
		
	}
	
	public void devolveEmprestimo() {
		
	}
	
	public void pesquisaEmprestimo() {
		
	}
	
	public int dataDiff(java.util.Date dataLow, java.util.Date dataHigh){  
		  
	     GregorianCalendar startTime = new GregorianCalendar();  
	     GregorianCalendar endTime = new GregorianCalendar();  
	       
	     GregorianCalendar curTime = new GregorianCalendar();  
	     GregorianCalendar baseTime = new GregorianCalendar();  
	  
	     startTime.setTime(dataLow);  
	     endTime.setTime(dataHigh);  
	       
	     int dif_multiplier = 1;  
	       
	     // Verifica a ordem de inicio das datas  
	     if( dataLow.compareTo( dataHigh ) < 0 ){  
	         baseTime.setTime(dataHigh);  
	         curTime.setTime(dataLow);  
	         dif_multiplier = 1;  
	     }else{  
	         baseTime.setTime(dataLow);  
	         curTime.setTime(dataHigh);  
	         dif_multiplier = -1;  
	     }  
	       
	     int result_years = 0;  
	     int result_months = 0;  
	     int result_days = 0;  
	  
	     // Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import acumulando  
	     // no total de dias. Ja leva em consideracao ano bissesto  
	     while( curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR) ||  
	            curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)  )  
	     {  
	           
	         int max_day = curTime.getActualMaximum( GregorianCalendar.DAY_OF_MONTH );  
	         result_months += max_day;  
	         curTime.add(GregorianCalendar.MONTH, 1);  
	           
	     }  
	       
	    
	     // Marca que é um saldo negativo ou positivo  
	     result_months = result_months*dif_multiplier;  
	       
	       
	     // Retirna a diferenca de dias do total dos meses  
	     result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));  
	       
	     return result_years+result_months+result_days;  
	} 
}
