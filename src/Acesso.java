import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Acesso extends JDialog implements ActionListener{
	//Declaração global dos objetos
	public JTextField tfUsuario;
	public JPasswordField tfSenha;
	public JButton 	bEntrar, bCancelar;
	public JLabel 	lUsuario, lSenha;
	public SNEO sneo;
	
    public Acesso(Frame owner, String title, boolean modal, SNEO sneo){    	
    	super(owner, title, modal);
    	this.sneo = sneo;
    	setResizable(false);
    	setBounds(300, 250, 550, 250);
    	
    	//Cria o container (box, caixa) para a  
    	//agrupamento dos objetos
    	Container areaTrabalho = getContentPane();
    	areaTrabalho.setLayout(null);
    	
    	lUsuario = new JLabel("Usuário");
    	lUsuario.setBounds(30, 30, 150, 40);
    	lUsuario.setFont(new Font("TimesRoman", Font.ITALIC, 25));
    	
    	tfUsuario = new JTextField("");
    	tfUsuario.setBounds(30, 70, 200, 40);
    	tfUsuario.addActionListener(this); 
    	tfUsuario.setHorizontalAlignment(JTextField.LEFT);
    	tfUsuario.setFont(new Font("TimesRoman", Font.ITALIC, 25));
    	tfUsuario.setEditable(true);
    	tfUsuario.setBackground(Color.white);
    	
    	lSenha = new JLabel("Senha");
    	lSenha.setBounds(250, 30, 150, 40);
    	lSenha.setFont(new Font("TimesRoman", Font.ITALIC, 25));
    	
    	tfSenha = new JPasswordField("");
    	tfSenha.setBounds(250, 70, 180, 40);
    	tfSenha.addActionListener(this);
    	tfSenha.setFont(new Font("TimesRoman", Font.ITALIC, 25));
    	tfSenha.setHorizontalAlignment(JPasswordField.LEFT);
    
    	//Definições dos botões    	   	
    	bEntrar = new JButton("Entrar");
    	bEntrar.addActionListener(this); 
    	bEntrar.setBounds(80, 150, 150, 50); 	
    	areaTrabalho.add(bEntrar);
    	   	
    	bCancelar = new JButton("Cancelar");
    	bCancelar.addActionListener(this); 
    	bCancelar.setBounds(280, 150, 150, 50); 	
    	areaTrabalho.add(bCancelar);
    	
    	//Painel para agrupar objetos    	 
	    //Painel com bordas para agrupar configurações de abertura de arquivo de vídeo
    	String titleBorda = "Digita o nome e a senha de acesso";
    	Border border = BorderFactory.createEtchedBorder();
    	Border borderTitle = BorderFactory.createTitledBorder(border, titleBorda, 
    			TitledBorder.DEFAULT_JUSTIFICATION , TitledBorder.DEFAULT_POSITION , new Font("TimesRoman", Font.PLAIN, 30));
    	
    	JPanel pBorderTitle = new JPanel();
    	pBorderTitle.setBounds(30, 10, 450, 130);
    	pBorderTitle.setLayout(null);
    	pBorderTitle.setBorder(borderTitle);
   	    pBorderTitle.add(lUsuario);
   	    pBorderTitle.add(tfUsuario);
   	    pBorderTitle.add(lSenha);
   	    pBorderTitle.add(tfSenha);
    	
    	areaTrabalho.add(pBorderTitle);
    	    	   	
    	tfUsuario.requestFocus();
    }
    
    
        
    public void actionPerformed(ActionEvent e){ 
    	int temp = 0;    	
	    if (e.getSource()==bEntrar || e.getSource()==tfSenha)
	      sneo.msg(tfUsuario.getText(), tfSenha.getText());	    
	    else if (e.getSource()==bCancelar)
	      setVisible(false);	      
	    else if (e.getSource()==tfUsuario)
	      tfSenha.requestFocus();
	    else
	      temp = 0;	 
	    
  	}
    
   
    
    
}