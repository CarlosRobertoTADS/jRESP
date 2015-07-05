/**
 * @(#)DataNasc.java
 *
 *
 * @author Sergio A C Bezerra
 * @version 1.00 2014/9/2
 */


public class DataNasc{
	public int dia, mes, ano;
	
	public DataNasc(int d, int m, int a){
		dia = d;
		mes = m;
		ano = a;
	}
	//recuperando atributos
	public int getDia(){ return dia; }
	public int getAno(){ return ano; }
	public int getMes(){ return mes; }
	public String getData(){ return ""+ dia+ "/"+mes+"/"+ano; }
	
	//atualizando atributos
	public void setDia(int d){ dia = d; }
	public void setMes(int m){ mes = m; }
	public void setAno(int a){ ano = a; }	
	public void setDataNasc(int d, int m, int a){
		setDia(d);
		setMes(m);
		setAno(a);
	}
}	