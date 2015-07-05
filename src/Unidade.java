
public class Unidade {
	public int cnpj;
	public String nome;
	public String rua;
	public String bairro;
	

	
    public Unidade(int c, String n, String r, String b) {
       cnpj = c;
       nome = n;
       rua = r; 
       bairro = b;

    }
    
    public void setCnpj(int c){ cnpj = c; }
    public void setNome(String n){ nome = n; }
    public void setRua (String r) {rua = r;}
    public void setBairro (String b){bairro= b;}
    public void setUnidade(int c, String n, String r, String b) {
       setCnpj(c);
       setNome(n);
       setRua (r);
       setBairro(b);
       	
    }
   
    public int getCnpj(){ return cnpj; }
    public String getNome(){ return nome; }	     
    public String getRua(){ return rua; }	    
    public String getBairro(){ return bairro; }	 
	
	
	
	
	
}
