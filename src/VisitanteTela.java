import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;



	public class VisitanteTela extends JDialog implements ActionListener {
		public SNEO sneo;
		public JLabel 	lCodigo, lNome, lcpf, lrg, lDataNasc, lSexo, lFoto;
		public JTextField tfCodigo, tfNome, tfrg, tfCpf;
		public int distBotoes = 20;
		public ToolBar toolBar;
		public char operacao; //[0]Nenhuma operação; [1]Incluir; [2]Atualizar; [3]Excluir;
		public String sSexo[] = {"", "Masculino", "Feminino"};
		public JComboBox cbSexo, cbEmpregado; 
		public JFormattedTextField ftfDataNasc;		
		public MaskFormatter mfDataNasc;
		private JLabel lblMatriculaDoEmpregado;
		public VisitanteTabela vTabela;
		public ServidorTabela ssTabela;
		int qtdefotos = 3;
		private JButton btnHabilitar;
		
		

	    public VisitanteTela(Frame owner, String title, boolean modal, SNEO sneo, VisitanteTabela vTabela, ServidorTabela ssTabela) {
	      	super(owner, title, modal);
	      	this.sneo = sneo;
	      	setResizable(false);
	      	setBounds(280, 300,789, 600);
	      	
	      	//Vinculando a referência com a Tabela de Clientes
	      	this.vTabela = vTabela;
	      	this.ssTabela = ssTabela;
	      
	      	
	    
			     
	    	//Cria o container (box, caixa) para a  
	    	//agrupamento dos objetos
	    	Container areaTrabalho = getContentPane();
	    	areaTrabalho.setLayout(null);
	    	
	    	
	    	lCodigo = new JLabel("C\u00F3digo:");
	    	lCodigo.setBounds(20, 110, 100, 40);
	    	lCodigo.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lCodigo);
	    	
	    	tfCodigo = new JTextField("");
	    	tfCodigo.setBounds(120, 110, 200, 40);
	    	tfCodigo.addActionListener(this); 
	    	tfCodigo.setHorizontalAlignment(JTextField.LEFT);
	    	tfCodigo.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	tfCodigo.setEditable(true);
	    	areaTrabalho.add(tfCodigo);
	    	
	    	lNome = new JLabel("Nome:");
	    	lNome.setBounds(20, 472, 88, 40);
	    	lNome.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lNome);
	    	
	    	tfNome = new JTextField("");
	    	tfNome.setBounds(120, 473, 400, 40);
	    	tfNome.setHorizontalAlignment(JTextField.LEFT);
	    	tfNome.addActionListener(this); 
	    	tfNome.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	tfNome.setEditable(true);
	    	areaTrabalho.add(tfNome);
	    	
	    	lrg = new JLabel("RG:");
	    	lrg.setBounds(20, 325, 200, 40);
	    	lrg.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lrg);
	    	
	    	tfrg = new JTextField("");
	    	tfrg.setBounds(120, 325, 264, 40);
	    	tfrg.setHorizontalAlignment(JTextField.LEFT);
	    	tfrg.addActionListener(this); 
	    	tfrg.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	tfrg.setEditable(true);
	    	areaTrabalho.add(tfrg);
	    	
	    	lcpf = new JLabel("CPF:");
	    	lcpf.setBounds(20, 249, 62, 49);
	    	lcpf.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lcpf);
	    	
	    	tfCpf = new JTextField("");
	    	tfCpf.setBounds(121, 254, 286, 40);
	    	tfCpf.setHorizontalAlignment(JTextField.LEFT);
	    	tfCpf.addActionListener(this); 
	    	tfCpf.setFont(new Font("TimesRoman",Font.ITALIC, 25));
	    	tfCpf.setEditable(true);
	    	areaTrabalho.add(tfCpf);
	    
	    	lSexo = new JLabel("Sexo:");
	    	lSexo.setBounds(560, 396, 100, 40);
	    	lSexo.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lSexo);
	    	
	    	cbSexo = new JComboBox(sSexo);
	    	cbSexo.setBounds(633, 402, 140, 28);
	    	cbSexo.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(cbSexo);

	    	
	    	toolBar = new ToolBar();
	    	toolBar.setBounds(1, 1, 700, 70); 	
	    	toolBar.bIncluir.addActionListener(this);    	  	
	    	toolBar.bAtualizar.addActionListener(this);
	    	toolBar.bExcluir.addActionListener(this);
	    	toolBar.bConfirmar.addActionListener(this);    	
	    	toolBar.bLimpar.addActionListener(this);    	
	    	toolBar.bPesquisar.addActionListener(this);
	    	
	    	areaTrabalho.add(toolBar);
	    	toolBar.desbloquearBotoes();
	    	toolBar.bIncluir.requestFocus();
	    	
	    	lFoto = new JLabel("");
	    	lFoto.setBounds(552, 91, 168, 218);
	    	getContentPane().add(lFoto);
	    	
	    	JButton btaddfoto = new JButton("Adicionar Foto");
	    	btaddfoto.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent arg0) {
	    			foto();
	    			}
	    	});
	    	btaddfoto.setBounds(578, 336, 123, 29);
	    	areaTrabalho.add(btaddfoto);
	    	
	    	JPanel panel = new JPanel();
	    	panel.setBorder(new LineBorder(new Color(0, 0, 0)));
	    	panel.setBounds(535, 82, 199, 234);
	    	getContentPane().add(panel);
	    	
	    	lDataNasc = new JLabel("Data de Nascimento:");
	    	lDataNasc.setBounds(20, 181, 227, 40);
	    	lDataNasc.setFont(new Font("TimesRoman", Font.ITALIC, 25)); 
	    	areaTrabalho.add(lDataNasc);
	    	try{
	    		mfDataNasc = new MaskFormatter("##/##/####");
	    		mfDataNasc.setPlaceholderCharacter('_');
	    	}
	    	catch(ParseException ex){
	    		//código para exceção
	    	}
	    	
	    	ftfDataNasc = new JFormattedTextField(mfDataNasc);
	        ftfDataNasc.setBounds(258, 182, 168, 40);
	        ftfDataNasc.addActionListener(this); 
	        ftfDataNasc.setFont(new Font("TimesRoman", Font.ITALIC, 25));
	    	areaTrabalho.add(ftfDataNasc);
	    	
	    	lblMatriculaDoEmpregado = new JLabel("Empregado:");
	    	lblMatriculaDoEmpregado.setFont(new Font("Serif", Font.ITALIC, 25));
	    	lblMatriculaDoEmpregado.setBounds(20, 401, 280, 29);
	    	getContentPane().add(lblMatriculaDoEmpregado);
	    	
	    	cbEmpregado = new JComboBox();
	    	cbEmpregado.setBounds(152, 408, 258, 28);
	    	areaTrabalho.add(cbEmpregado);
	    	
	    	JButton bADD = new JButton("ADD");
	    	bADD.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent arg0) {
	    			preencherDados();
	    			}
	    	});
	    	bADD.setBounds(420, 411, 75, 23);
	    	areaTrabalho.add(bADD);
	    	
	    	btnHabilitar = new JButton("Habilitar");
	    	JButton btnHabilitar = new JButton("Habilitar");
	    	btnHabilitar.addActionListener(new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    			tfCodigo.setEditable(true);
	    		
	    		}
	    	});
	    	btnHabilitar.setBounds(337, 113, 89, 23);
	    	getContentPane().add(btnHabilitar);
	    	operacao = '0';
	    	limpar();
	    	bloquearCampos();
	    }
	    
	    
	    public void actionPerformed(ActionEvent e){ 
	    	int temp = 0;
		      if (e.getSource()==toolBar.bIncluir)	
		    	incluir();
		      else if(e.getSource()==toolBar.bAtualizar)
		        atualizar();
		      else if(e.getSource()==toolBar.bExcluir)
		        excluir();
		      else if(e.getSource()==toolBar.bConfirmar)
		        confirmar();
		      else if(e.getSource()==toolBar.bLimpar)
		        limpar();
		      else if(e.getSource()==toolBar.bPesquisar)
		      	visualizar();
		      else if(e.getSource()==tfCodigo)
		        tfNome.requestFocus();
		      else if(e.getSource()==tfNome)
		      tfrg.requestFocus();
		      else if(e.getSource()==tfrg)
		    	tfCpf.requestFocus();
		    	  else if (e.getSource()== tfCpf)
		    		  
		 
		      	temp = 0;
		    
	  	}
	  	
	  	
	  	public void incluir(){
	  		
	  		tfCodigo.requestFocus();
			toolBar.metodoincluir();
			desbloquearCampos();
			
	  		SimpleDateFormat dataent = new SimpleDateFormat("yyyy"); 		
	  		int temp = 0;
	  		dataent.getCalendar();
	  		Random gerar = new Random();
	  	    int numero = gerar.nextInt(10001)+ 9999;
	  	    tfCodigo.setEnabled(true); 
	  	    tfCodigo.setText(dataent.format(new Date())+numero);
			operacao = '1';		 		 
		}
	  	
	  	public void atualizar(){
	  		confirmação();
	  		exclusao();
	  		tfCodigo.requestFocus();
			toolBar.metodoeditar();
			
			desbloquearCampos();
		    tfCodigo.setEditable(true);
			
			operacao = '2';		
			 limpar();
		}
	
		public void excluir(){
			int temp = vTabela.Remover(tfNome.getText());
			if (temp==1){
				JOptionPane.showMessageDialog(null, "Visitante removido com sucesso!","Aviso",
						JOptionPane.INFORMATION_MESSAGE);
				
			}else{
				JOptionPane.showMessageDialog(null, "Erro ao Excluir","Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			tfCodigo.requestFocus();
			toolBar.metodoExcluir();
			desbloquearCampos();
			operacao = '3';		 		 
		}
		public void confirmar(){
			
			 
		       if("".equals(tfCodigo.getText()) || ("".equals(ftfDataNasc.getText())|| ("".equals(tfCpf.getText())|| ("".equals(cbEmpregado.getSelectedItem()))|| ("".equals(cbSexo.getSelectedItem())|| ("".equals(tfNome.getText())) || ("".equals(tfrg.getText()))))))
		       { JOptionPane.showMessageDialog(null, "Erro campos vazios, Insira novamente os dados!");
		       tfCodigo.setText("");
		       tfCpf.setText("");
		       tfrg.setText("");
		       tfNome.setText("");
		       ftfDataNasc.setText("");
		       cbSexo.setSelectedItem("");
		       cbSexo.setSelectedItem("");
		       
		       
				tfNome.setEnabled(true);
				ftfDataNasc.setEnabled(false);
				cbSexo.setEnabled(false);	
				tfCpf.setEnabled(false);
				tfrg.setEnabled(false);
				cbSexo.setEnabled(true);
				cbEmpregado.setEnabled(true);
				toolBar.metodoconfirmar();
				 
				
		       } 
		       
		       else{
       toolBar.desbloquearBotoes();
			toolBar.metodoconfirmar();
			bloquearCampos();
			String textoData = ftfDataNasc.getText();
			int dia = Integer.parseInt(textoData.substring(0,2));
			int mes = Integer.parseInt(textoData.substring(3,5));
			
			int ano = Integer.parseInt(textoData.substring(6,10));
				
			if(operacao == '1'){
			char sexo;
				String textoSexo = ""+cbSexo.getItemAt(cbSexo.getSelectedIndex());
				if(textoSexo.equals("Masculino") )
				   sexo = 'M';	
				else if(textoSexo.equals("Feminino"))
					sexo = 'F';
				else 
					sexo = ' ';
					
				if(vTabela.add(Integer.parseInt(tfCodigo.getText()), tfCpf.getText(),tfrg.getText(),tfNome.getText(), dia, mes, ano, sexo, cbEmpregado.getSelectedItem().toString(),lFoto.getIcon())=='1')
					JOptionPane.showMessageDialog(null, "Visitante cadastrado com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);			
				else
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o visitante!","Aviso", JOptionPane.INFORMATION_MESSAGE);							
		
		
		}
			limpar ();
		}
		}
			
		 public void preencherDados(){
			 cbEmpregado.addItem("");	
			 if(ssTabela.getNumero()==0)
		  			JOptionPane.showMessageDialog(null, "Nenhum Empregado cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
		  		else{
		  		  for(int i=0; i<ssTabela.getNumero(); i++)
			    	cbEmpregado.addItem(ssTabela.getServidor(i));     
		  		}
		 }
		 public void  exclusao(){
		        int temp = vTabela.Remover(tfNome.getText());
					
				}
				
				public void confirmação(){
					toolBar.desbloquearBotoes();
					
					bloquearCampos();
					String textoData = ftfDataNasc.getText();
					int dia = Integer.parseInt(textoData.substring(0,2));
					int mes = Integer.parseInt(textoData.substring(3,5));
					
					int ano = Integer.parseInt(textoData.substring(6,10));
						
					if(operacao == '1'){
					char sexo;
						String textoSexo = ""+cbSexo.getItemAt(cbSexo.getSelectedIndex());
						if(textoSexo.equals("Masculino") )
						   sexo = 'M';	
						else if(textoSexo.equals("Feminino"))
							sexo = 'F';
						else 
							sexo = ' ';
							
						if(vTabela.add(Integer.parseInt(tfCodigo.getText()), tfCpf.getText(),tfrg.getText(),tfNome.getText(), dia, mes, ano, sexo, cbEmpregado.getSelectedItem().toString(),lFoto.getIcon())=='1');
					
					}
									
				}
		
	  	public void limpar(){
			 tfCodigo.setText("");
			 tfNome.setText("");
			 tfCpf.setText("");
			 tfrg.setText("");
			 ftfDataNasc.setText("");
			 cbSexo.setSelectedItem("");
			 cbEmpregado.setSelectedItem("");
			 lFoto.setIcon(null);
			
			 		 		 
		}
	  	
	  	public void bloquearCampos(){
	  	 	tfCodigo.setEnabled(true);
			tfCpf.setEnabled(false);
			tfrg.setEnabled(false);
			ftfDataNasc.setEnabled(false);
			cbSexo.setEnabled(false);	
			cbEmpregado.setEnabled(true);
			
		
	  	}
	  	
	  	public void desbloquearCampos(){
	  	 	tfCodigo.setEnabled(true);
			tfNome.setEnabled(true);
			tfCpf.setEnabled(true);
			tfrg.setEnabled(true);
			cbEmpregado.setEnabled(true);
			ftfDataNasc.setEnabled(true);
			cbSexo.setEnabled(true);
			
				
	  	}
	  	
	  	public void foto() {
			
			 JFileChooser fileChooser = new JFileChooser();   //Cria o objeto do tipo Janela JFileChooser    
		       if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		                try {
		                    File arquivo = fileChooser.getSelectedFile();//arquivo  
		                    
		                    BufferedImage bi = ImageIO.read(arquivo); //carrega a imagem real num buffer  
		                    BufferedImage aux = new BufferedImage(150, 200, bi.getType());//cria um buffer auxiliar com o tamanho desejado    
		                    Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao    
		                    AffineTransform at = AffineTransform.getScaleInstance((double) 150 / bi.getWidth(), (double) 200 / bi.getHeight());//cria a transformacao    
		                    g.drawRenderedImage(bi, at);//pinta e transforma a imagem real no auxiliar    
		                    lFoto.setIcon(new ImageIcon(aux));//seta no jlabel   
		                    lFoto.setText(null);
		                 
		                } catch (IOException ex) {
		                	
		                }
		                }
			
		
	        
	        
	      
	        
	    else {
	        JOptionPane.showMessageDialog(null, "Voce n\u00e3o selecionou nenhum diretorio.");
	    }

		}
	  	
	  	
	  	
	  	public void visualizar(){

	  		int temp= vTabela.pesquisar(Integer.parseInt(tfCodigo.getText()));
	  		
	  		if(temp ==-1){
	  			JOptionPane.showMessageDialog(null, "Nenhum visitante cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);		 
	  		}
	  			
	  		else{
	  			
	  		 tfNome.setText(vTabela.visitante[temp].getNome());
	  		 ftfDataNasc.setText(vTabela.visitante[temp].getData());
	  		 cbSexo.selectWithKeyChar(vTabela.visitante[temp].getSexo());
	  		 tfrg.setText(vTabela.visitante[temp].getRg());
	  		 tfCpf.setText(vTabela.visitante[temp].getCpf());
	  		 cbEmpregado.setSelectedItem(vTabela.visitante[temp].getEmpregado());	
	  	     lFoto.setIcon(vTabela.visitante[temp].getFoto());
            
	  	
		
		}
	}
	}
