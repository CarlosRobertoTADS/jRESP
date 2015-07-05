import javax.swing.Icon;

public class Visitante {
	
		
	public int codigo;
	public String cpf;
	public String rg;
	public String nome;
	public DataNasc dataNasc; // = new DataNasc();
	public char sexo;  //M: masculino; F: feminino
	public String empregado;
	public Icon foto;
		

		
	    public Visitante(int c, String r, String f,  String n,  DataNasc d, char s, String e, Icon fo) {
	       codigo = c;
	       rg = r;
	       cpf = f; 
	       nome = n;
	       dataNasc = new DataNasc(d.getDia(), d.getMes(), d.getAno());
	       sexo = s;
	       empregado = e;
	       foto = fo;
	       
	     
	
	    }
	    
	    public void setCodigo(int c){ codigo = c; }
	    public void setRg (String r){rg=r;}
	    public void setCpf (String f){cpf=f;}
	    public void setNome(String n){ nome = n; }
	    public void setDataNasc(DataNasc d){ dataNasc = d; }
	    public void setEmpregado(String e){empregado = e;}
	    public void setFoto (Icon fo){foto = fo;}
	    public void setVisitante(int c, String r, String f,  String n,  DataNasc d, char s, String e, Icon fo) {
	       setCodigo(c);
	       setRg(r);
	       setCpf (f);	      
	       setNome(n);
	       setDataNasc(d);
	       setSexo(s);	
	       setEmpregado(e);
	       setFoto(fo);
	    }
	       public void setSexo(char s){ sexo = s; }
	       public int getCodigo(){ return codigo; }
	       public String getCpf () {return cpf;}
	       public String getRg(){return rg;}
	       public String getNome(){ return nome; }
	       public DataNasc getDataNasc(){ return dataNasc; }
	       public String getData(){ return dataNasc.getData(); }
	       public String getEmpregado(){return empregado;}
	       public Icon getFoto(){return foto;}
	       public char getSexo(){ return sexo; }
	           
	   }