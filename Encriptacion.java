import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

public class Encriptacion extends JFrame implements ActionListener 
{
    private JLabel lblTitulo;
    private JTextField txtPalabra;
    private JButton btnEncriptar;
    private JTextArea txtEncriptacion;
    private int bandera = 0;
        
    public Encriptacion() {
       super();                   
       configurar();
       componentes();
    }
    
    private void configurar() {
        this.setTitle("E N C R I P T A C I O N");                   
        this.setSize(450, 300);                                 
        this.setLocationRelativeTo(null);                       
        this.setLayout(null);                                   
        this.setResizable(true); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void componentes() {
        lblTitulo = new JLabel();
        txtPalabra = new JTextField();
        btnEncriptar = new JButton();
        txtEncriptacion = new JTextArea();
        
        lblTitulo.setText("Introduce una palabra: ");
        lblTitulo.setBounds(30,20,300,25);
        
        txtPalabra.setBounds(180,20,150,25);
        txtPalabra.setBackground(Color.orange);
        
        btnEncriptar.setText("Encriptar: ");
        btnEncriptar.setBounds(90,60,100,25);
        btnEncriptar.addActionListener(this);
        
        txtEncriptacion.setBounds(40,100,300,60);
        
        this.add(lblTitulo);
        this.add(txtPalabra);
        this.add(btnEncriptar);
        this.add(txtEncriptacion);
    }
    
    public void actionPerformed(ActionEvent e) {
                
           if(bandera == 1) {
               btnEncriptar.setText("Desencriptar");
               String palabra = txtEncriptacion.getText();
               
               byte[] se = Base64.getDecoder().decode(palabra);
               txtEncriptacion.setText(se.toString());
               String h = new String (se);
                    txtEncriptacion.setText(h);
               bandera = 0;
           }
           else {
               btnEncriptar.setText("Encriptar");
               byte[] palabra = txtPalabra.getText().getBytes();
        
               String secure = Base64.getEncoder().encodeToString(palabra);
               txtEncriptacion.setText(secure);
               
               bandera = 1;
           }
           
        this.add(btnEncriptar);
    }
    
    public static void main(String[] args) {
        Encriptacion E = new Encriptacion();
        E.setVisible(true);
    }
}
   