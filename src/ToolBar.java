import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

 public class ToolBar extends JPanel implements ActionListener{
     	
     	int qtdeBotoes = 6;
     	public JScrollPane pCad;
     	public JButton bIncluir, bAtualizar, bExcluir, bConfirmar, bLimpar, bPesquisar;		//bInitialization, bVisualization, bConfiguration, bSegmentation;
     	private Dimension dimension = new Dimension(20, 0);
     	public Random random;
     	
		public ToolBar(){
			
			BorderLayout blBarra = new BorderLayout();
			setLayout(blBarra);
			
			Color color = new Color(30, 130, 200, 230);			
			
		    //Configurações para a barra de ferramenta
		    ImageIcon[] vectorImageToolBar = new ImageIcon[qtdeBotoes];	//vetor de imagens da barra de ferramenta de cadastro
		    String iconesToolBar[] = {"imagem/add.png", "imagem/update.png", "imagem/exclusao.png",
		    						  "imagem/Accept.png", "imagem/clear.png", "imagem/seach.png"};
		    for(int i=0; i<iconesToolBar.length; i++){
		    	vectorImageToolBar[i] = new ImageIcon(iconesToolBar[i]);	
		    }		 
	    
	    	JPanel pBotoes = new JPanel();
	    	pBotoes.setLayout(new FlowLayout(FlowLayout.LEFT));
	    
		    bIncluir 	= new JButton(vectorImageToolBar[0]);
		    bIncluir.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		    bIncluir.addActionListener(this);		    
		    bIncluir.setToolTipText("Inclui um novo registro");
		    bIncluir.setVerticalTextPosition(SwingConstants.BOTTOM);
		    bIncluir.setHorizontalTextPosition(SwingConstants.CENTER);		    
		    bIncluir.setOpaque(false);
		   
		   
		    
		    bAtualizar 	= new JButton(vectorImageToolBar[1]);
		    bAtualizar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		    bAtualizar.addActionListener(this);
		    bAtualizar.setToolTipText("Atualiza registro");
		    bAtualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		    bAtualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		    bAtualizar.setOpaque(false);
		    bAtualizar.setBackground(color);
			
		    	
		    bExcluir 	= new JButton(vectorImageToolBar[2]);
		    bExcluir.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		    bExcluir.addActionListener(this);
		    bExcluir.setToolTipText("Exclui registro");
		    bExcluir.setVerticalTextPosition(SwingConstants.BOTTOM);
		    bExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
		    bExcluir.setOpaque(false);	
		    bExcluir.setEnabled(false);
		    bExcluir.setBackground(color); 
		    
		    	 
		    bConfirmar 	= new JButton(vectorImageToolBar[3]);
		    bConfirmar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		    bConfirmar.addActionListener(this);
		    bConfirmar.setToolTipText("Confirma operação");
		    bConfirmar.setVerticalTextPosition(SwingConstants.BOTTOM);
		    bConfirmar.setHorizontalTextPosition(SwingConstants.CENTER);
		    bConfirmar.setOpaque(false);
		    bConfirmar.setEnabled(false);
		    bConfirmar.setBackground(color);
		    	    
		    bLimpar 	= new JButton(vectorImageToolBar[4]);
		    bLimpar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		    bLimpar.addActionListener(this);
		    bLimpar.setToolTipText("Limpa os campos");
		    bLimpar.setVerticalTextPosition(SwingConstants.BOTTOM);
		    bLimpar.setHorizontalTextPosition(SwingConstants.CENTER);
		    bLimpar.setOpaque(false);
		    bLimpar.setEnabled(false);
		    bLimpar.setBackground(color); 
	
		    bPesquisar 	= new JButton(vectorImageToolBar[5]);
		    bPesquisar.setFont(new Font("TimesRoman", Font.PLAIN, 18));
		    bPesquisar.addActionListener(this);
		    bPesquisar.setToolTipText("Pesquisa de registros");
		    bPesquisar.setVerticalTextPosition(SwingConstants.BOTTOM);
		    bPesquisar.setHorizontalTextPosition(SwingConstants.CENTER);
		    bPesquisar.setOpaque(false);
		    bPesquisar.setEnabled(false);
		    bPesquisar.setBackground(color);
		    
		    setOpaque(false);
		    setBackground(null);
		    	    
		    
		    JToolBar BarraFer = new JToolBar(0);		    
		    BarraFer.setFloatable(false);
		    BarraFer.setRollover(true);		
		    BarraFer.add(bIncluir);
		    BarraFer.addSeparator(dimension);	
		    BarraFer.add(bAtualizar);	
		    BarraFer.addSeparator(dimension);
		    BarraFer.add(bExcluir);	
		    BarraFer.addSeparator(dimension);
		    BarraFer.add(bConfirmar);
		    BarraFer.addSeparator(dimension);
		    BarraFer.addSeparator(dimension);
		    BarraFer.addSeparator(dimension);
		    BarraFer.addSeparator(dimension);
		    BarraFer.addSeparator(dimension);
		    BarraFer.addSeparator(dimension);
		    BarraFer.addSeparator(dimension);
		    BarraFer.add(bLimpar);
		    BarraFer.addSeparator(dimension);
		    BarraFer.add(bPesquisar);
		    BarraFer.setOpaque(false); 
		    BarraFer.setBackground(null);
		    add(BarraFer);	
		    	
    }     	
    
    public void actionPerformed(ActionEvent e){ 
    	int temp = 0;
	      /*if (e.getSource()==bIncluir)	
	    	incluir();
	      else if(e.getSource()==bAtualizar)
	        atualizar();
	      else if(e.getSource()==bExcluir)
	        excluir();
	      else if(e.getSource()==bConfirmar)
	        confirmar();
	      else if(e.getSource()==bPesquisar)
	      	pesquisar();
	      else 
	      	temp = 0;*/
	    
  	}
  	
  	
  	public void bloquearBotoes(){
  		bIncluir.setEnabled(false);
  		bAtualizar.setEnabled(false);
  		bExcluir.setEnabled(false);
  		bConfirmar.setEnabled(true);
  		bLimpar.setEnabled(true);
  		bPesquisar.setEnabled(true);
  		
  		
  	}
  	
  	public void desbloquearBotoes(){
  		bIncluir.setEnabled(true);
  		bAtualizar.setEnabled(true);
  		bExcluir.setEnabled(true);
  		bConfirmar.setEnabled(false);
  		bLimpar.setEnabled(false);
  		bPesquisar.setEnabled(false);
  		
  	}
  	public void metodoconfirmar(){
  		bIncluir.setEnabled(true);
  		bAtualizar.setEnabled(false);
  		bExcluir.setEnabled(false);
  		bConfirmar.setEnabled(false);
  		bLimpar.setEnabled(true);
  		bPesquisar.setEnabled(true);
  	}
  	
  	public void metodopesquisar(){
  		bIncluir.setEnabled(true);
  		bAtualizar.setEnabled(true);
  		bExcluir.setEnabled(true);
  		bConfirmar.setEnabled(false);
  		bLimpar.setEnabled(true);
  		bPesquisar.setEnabled(true);
  	}
    
  	public void metodoincluir(){
  		bIncluir.setEnabled(false);
  		bAtualizar.setEnabled(false);
  		bExcluir.setEnabled(false);
  		bConfirmar.setEnabled(true);
  		bLimpar.setEnabled(false);
  		bPesquisar.setEnabled(true);
  	}
  	
  	public void metodoeditar(){
  		bIncluir.setEnabled(true);
  		bAtualizar.setEnabled(false);
  		bExcluir.setEnabled(false);
  		bConfirmar.setEnabled(false);
  		bLimpar.setEnabled(true);
  		bPesquisar.setEnabled(true);
  	}
  	public void metodoExcluir(){
  		bIncluir.setEnabled(true);
  		bAtualizar.setEnabled(false);
  		bExcluir.setEnabled(false);
  		bConfirmar.setEnabled(false);
  		bLimpar.setEnabled(true);
  		bPesquisar.setEnabled(true);
  	}
   /* public void incluir(){  		
		 bloquearBotoes();
		 operacao = '1';		 		 
	}
  	
  	public void atualizar(){
		 bloquearBotoes();
		 operacao = '2';
		 		 
	}
	public void excluir(){
		 bloquearBotoes();
		 operacao = '3';
		 		 
	}
	public void confirmar(){
		 desbloquearBotoes();		 		 
	}
    
	
    public void pesquisar(){
		 desbloquearBotoes();		 		 
	}
    */
   	public void paint(Graphics g){
    	super.paint(g);
    	//Graphics2D g2d = (Graphics2D) g;
    
    
    }
    	

     }