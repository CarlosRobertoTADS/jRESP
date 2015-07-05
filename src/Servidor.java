public class Servidor {

	public int matricula;
	public String cpf;
	public String rg;
	public String nome;
	public DataNasc dataNasc; // = new DataNasc();
	public char sexo;  //M: masculino; F: feminino
	public String endereco;
	public String setor;
	
    public Servidor( int m, String c, String r, String n, DataNasc d, char s, String se, String e) {
       matricula = m;
       rg= r;
       cpf = c;
       nome = n;
       dataNasc = new DataNasc(d.getDia(), d.getMes(), d.getAno());
       sexo = s;
       setor = se;
       endereco = e;
    }
    
    public void setMatricula(int m){ matricula = m; }
    public void setCpf (String c) {cpf = c;}
    public void setRg (String r) {rg= r;}
    public void setNome(String n){ nome = n; }
    public void setDataNasc(DataNasc d){ dataNasc = d; }
    public void setSetor(String se){setor = se;}
    public void setEndereco (String e){endereco = e;}
    public void setServidor(String c,int m, String r, String n, DataNasc d, char s, String se, String e) {
       setMatricula(m);
       setCpf (c);
       setRg (r);
       setNome(n);
       setDataNasc(d);
       setSexo(s);	
       setSetor (se);
       setEndereco (e);
    }
    public void setSexo(char s){ sexo = s; }
    public int getMatricula(){ return matricula; }
    public String getCpf () {return cpf;}
    public String getRg(){return rg;}
    public String getNome(){ return nome; }
    public DataNasc getDataNasc(){ return dataNasc; }
    public String getData(){ return dataNasc.getData(); }
    public char getSexo(){ return sexo; }
    public String getSetor(){return setor;}
    public String getEndereco(){return endereco;}
        
}

