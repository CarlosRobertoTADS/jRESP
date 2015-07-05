

	import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.text.rtf.RTFEditorKit;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.Icon;

	public class SNEO extends JFrame implements ActionListener{
		//Declaração global
		public JLabel lTitulo, lHabilitar, lDesabilitar, lEmpregado, lSetor, lRegistro, lVisitante,lUnidade, lSair;
		public Acesso fAcesso;
		public JPanel contentPane;  
		public JTable table;  
	    public JScrollPane jScrollPane;  
	    public Consultar fConsultar;
		public ServidorTela fServidor;
		public UnidadeTela fUnidade;
		public RegistroTela fRegistro;
		public SetorTela fSetor;
	    public VisitanteTela fVisitante;
		public JButton bHabilitar, bEmpregado, bSetor, bVisitante, bRegistro, bUnidade,  bSair;
		public VisitanteTabela vTabela;
		public SetorTabela sTabela;
		public ServidorTabela ssTabela;
		public UnidadeTabela uTabela;
		public RegistroTabela rTabela;
		private JButton bConsultar;
		private JLabel lblConsultar;
	
	
	
		
		public SNEO(){
		  	setTitle("jRESP: Registro de Entrada e Saída de Pessoas JAVA");
	    	setExtendedState(MAXIMIZED_BOTH);
	    	
	       	//Cria o container (box, caixa) para a  
	    	//agrupamento dos objetos
	    	Container areaTrabalho = getContentPane();
			getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("20px"),
					ColumnSpec.decode("50px"),
					ColumnSpec.decode("30px"),
					ColumnSpec.decode("1920px:grow"),},
				new RowSpec[] {
					RowSpec.decode("20px"),
					RowSpec.decode("100px"),
					RowSpec.decode("80px:grow"),
					RowSpec.decode("50px"),
					RowSpec.decode("20px"),
					RowSpec.decode("50px"),
					RowSpec.decode("20px"),
					RowSpec.decode("50px"),
					RowSpec.decode("20px"),
					RowSpec.decode("50px"),
					RowSpec.decode("20px"),
					RowSpec.decode("50px"),
					RowSpec.decode("20px"),
					RowSpec.decode("50px"),
					RowSpec.decode("20px"),
					RowSpec.decode("50px"),}));
			
			lTitulo = new JLabel("jRESP: Registro de Entrada E Saída de Pessoas JAVA");
			
			lTitulo.setFont(new Font("TimesRoman", Font.BOLD, 30));
			//lHabilitar.addActionListener(this);    	
	    	areaTrabalho.add(lTitulo, "2, 2, 3, 1, fill, fill");
			
			
			
			ImageIcon iHabilitar = new ImageIcon("imagem/habilitar.png");
	    	bHabilitar = new JButton(iHabilitar);
	    	bHabilitar.addActionListener(this);
	    	areaTrabalho.add(bHabilitar, "2, 4, fill, fill");
	    	
	    	ImageIcon iConsultar = new ImageIcon("imagem/seach.png");
	    	bConsultar = new JButton(iConsultar);
	    	bConsultar.addActionListener(this);
	    	getContentPane().add(bConsultar, "2, 3");
	    	
	    	lblConsultar = new JLabel("Consultar");
	    	lblConsultar.setFont(new Font("Serif", Font.ITALIC, 30));
	    	getContentPane().add(lblConsultar, "4, 3");
	    	
	    	
			
			lHabilitar = new JLabel("Habilitar...");
			lHabilitar.setFont(new Font("TimesRoman", Font.ITALIC, 30));
	    	areaTrabalho.add(lHabilitar, "4, 4, left, fill");
	    	
	    	ImageIcon iServidor = new ImageIcon("imagem/cliente.png");
	    	bEmpregado = new JButton(iServidor);
	    	bEmpregado.addActionListener(this);    	   
	    	areaTrabalho.add(bEmpregado, "2, 6, fill, fill");
	    	bEmpregado.setEnabled(false);
			
			lEmpregado = new JLabel("Empregado");
			lEmpregado.setFont(new Font("TimesRoman", Font.ITALIC, 30));
	    	areaTrabalho.add(lEmpregado, "4, 6, left, fill");
	    	
	    	ImageIcon iSetor = new ImageIcon("imagem/setor.png");
	    	bSetor = new JButton(iSetor);
	    	bSetor.addActionListener(this);    	   
	    	areaTrabalho.add(bSetor, "2, 8, fill, fill");
	    	bSetor.setEnabled(false);
			
			lSetor = new JLabel("Setor");
			lSetor.setFont(new Font("TimesRoman", Font.ITALIC, 30));
	    	areaTrabalho.add(lSetor, "4, 8, left, fill");
	    	

	    	ImageIcon iObjeto = new ImageIcon("imagem/visitor.png");
	    	bVisitante = new JButton(iObjeto);
	    	bVisitante.addActionListener(this);    	   
	    	areaTrabalho.add(bVisitante, "2, 10, fill, fill");
	    	bVisitante.setEnabled(false);
			
			lVisitante = new JLabel("Visitante");
			lVisitante.setFont(new Font("TimesRoman", Font.ITALIC, 30));
	    	areaTrabalho.add(lVisitante, "4, 10, left, fill");
	    	
	    	ImageIcon iEmprestimos = new ImageIcon("imagem/inventory.png");
	    	bRegistro= new JButton(iEmprestimos);
	    	bRegistro.addActionListener(this);    	   
	    	areaTrabalho.add(bRegistro, "2, 12, fill, fill");
	    	bRegistro.setEnabled(false);
			
			lRegistro = new JLabel("Registros");
			lRegistro.setFont(new Font("TimesRoman", Font.ITALIC, 30));
	    	areaTrabalho.add(lRegistro, "4, 12, left, fill");
	    	
	    	ImageIcon iUnidade  = new ImageIcon("imagem/unidade.png");
	    	bUnidade = new JButton(iUnidade);
	    	bUnidade.addActionListener(this);    	   
	    	areaTrabalho.add(bUnidade, "2, 14, fill, fill");
	    	bUnidade.setEnabled(false);
			
			lUnidade = new JLabel("Unidade");
			lUnidade.setFont(new Font("TimesRoman", Font.ITALIC, 30));
	    	areaTrabalho.add(lUnidade, "4, 14, left, fill");
	    	
	    	ImageIcon iSair = new ImageIcon("imagem/sair.png");
	    	bSair = new JButton(iSair);
	    	bSair.addActionListener(this);    	   
	    	areaTrabalho.add(bSair, "2, 16, fill, fill");
	    	bSair.setEnabled(true);
			
			lSair = new JLabel("Sair do Sistema");
			lSair.setFont(new Font("TimesRoman", Font.ITALIC, 30));
	    	areaTrabalho.add(lSair, "4, 16, left, fill");
	    	
		   
	           
	         jScrollPane = new JScrollPane();  
	         jScrollPane.setBounds(new Rectangle(100, 24, 100, 75));  
	         jScrollPane.setViewportView(table);  
	         areaTrabalho.add(jScrollPane, "2, 2, 3, 1, fill, fill");  
	         jScrollPane.setEnabled (true);  
	           
	      
	    	//Criação das Tabelas com espaço para 20 registros
	    	sTabela = new SetorTabela(20);
	    	ssTabela = new ServidorTabela(20);
	        vTabela = new VisitanteTabela(20);
	    	uTabela = new UnidadeTabela (20);
	    	rTabela = new RegistroTabela (20);
			setVisible(true);
		}
		
		public void contectarADM(){
			 bUnidade.setEnabled(true);
			 bEmpregado.setEnabled(true);
			 bSetor.setEnabled(true);
			 bVisitante.setEnabled(true);
			 bSair.setEnabled(true);
			 fAcesso.setVisible(false);
			 bHabilitar.setEnabled(true);
			 bRegistro.setEnabled(true);
		}
		public void contectarUSU(){
			 bUnidade.setEnabled(false);
			 bEmpregado.setEnabled(false);
			 bSetor.setEnabled(false);
			 bVisitante.setEnabled(true);
			 bSair.setEnabled(true);
			 fAcesso.setVisible(false);
			 bHabilitar.setEnabled(true);
			 bRegistro.setEnabled(true);
		}
		public void actionPerformed(ActionEvent e){
	    	int temp = 0;
		    if (e.getSource()==bHabilitar){	
		    	
		    	fAcesso = new Acesso(null, "jRESP: Habilitação de usuário.", true, this );
		    	fAcesso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	fAcesso.setVisible(true);
		    	
		    }else if(e.getSource()==bSair)	
		    	System.exit(0);	
		    else if(e.getSource()==bEmpregado){	
		    	JOptionPane.showMessageDialog(null, "ANTES DE CADASTRAR UM EMPREGADO VERIFIQUE SE JÁ EXISTE SETORES CADASTRADOS!","Aviso", JOptionPane.INFORMATION_MESSAGE);
		    	fServidor = new ServidorTela (null, "jRESP: Empregado.", true, this, ssTabela,sTabela );
		    	fServidor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	fServidor.setVisible(true);
		    }else if (e.getSource()==bSetor){
		    	JOptionPane.showMessageDialog(null, "ANTES DE CADASTRAR UM SETOR VERIFIQUE SE JÁ EXISTE UNIDADES CADASTRADAS!","Aviso", JOptionPane.INFORMATION_MESSAGE);
		    	    fSetor = new SetorTela (null, "jRESP: Setor.", true, this, sTabela, uTabela);
		    		fSetor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    	fSetor.setVisible(true);
		    	}else if (e.getSource()==bVisitante){
		    		fVisitante = new VisitanteTela (null, "SNEO: Visitante.", true, this, vTabela, ssTabela);
		    		fVisitante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    	fVisitante.setVisible(true);
		    	}
		    else if (e.getSource ()== bRegistro){
		    	fRegistro = new RegistroTela (null, "jRESP: Registro.", true, this, rTabela, vTabela, ssTabela,sTabela,uTabela);
		    	fRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	fRegistro.setVisible(true);
		    }
		    	else if (e.getSource()== bUnidade){
		    		fUnidade = new UnidadeTela (null, "jRESP: UNIDADE.", true, this, uTabela);
		    		fUnidade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    		fUnidade.setVisible(true);
		    	
		    } else if (e.getSource()==bConsultar){
		    	fConsultar = new Consultar( this, rTabela);
		    	fConsultar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		    	fConsultar.setVisible(true);
		    	
		    }else
		    	temp = 0;		    
		}  
		
		public void msg(String usuario, String senha){
			
			if(usuario.equals("USU") && senha.equals("123")){
				  contectarUSU();
				  JOptionPane.showMessageDialog(null, "Acesso Autorizado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		      
				}
	
		   if(usuario.equals("ADM") && senha.equals("123")){
			  contectarADM();
			  JOptionPane.showMessageDialog(null, "Acesso Autorizado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		      
		   }
		  
		}
		public static void  main(String args[]){
	    	SNEO sneo = new SNEO();
	    	sneo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	}

