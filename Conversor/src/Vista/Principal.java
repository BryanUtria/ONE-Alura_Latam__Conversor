package Vista;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Principal {	
	private JFrame frame;
    private JComboBox<String> comboBox;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    public Principal() {
    	//-------- Pantalla Inicial -----------------
		frame = new JFrame("Menu");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(300, 200);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    
	    //-------- Panel Principal -----------------
	    JPanel panel = new JPanel();
	    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
	    //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    
	    //-------- Descripcion -----------------
	    JLabel label = new JLabel("Seleccione una opcion de conversion");
	    panel.add(label);
	    
	    //-------- Selector de Conversor -----------------
	    String[] opciones = {"Conversor de Moneda", 
							"Conversor de Temperatura", 
							"Conversor de Unidades"};
	    comboBox = new JComboBox<>(opciones);
	    panel.add(comboBox);
	    
	    //-------- Botones -----------------
	    JPanel panelBtns = new JPanel();
	    btnAceptar = new JButton("Aceptar");
	    btnCancelar = new JButton("Cancelar");
	    panelBtns.add(btnAceptar);
	    panelBtns.add(btnCancelar);
	    panel.add(panelBtns);
	    
	    frame.add(panel);
	}
    
    public void mostrar() {
        frame.setVisible(true);
    }
    
    public void BtnAceptarListener(ActionListener listener) {
        btnAceptar.addActionListener(listener);
    }
    
    public void BtnCancelarListener(ActionListener listener) {
    	btnCancelar.addActionListener(listener);
    }
    
    public void CerrarVentana() {
        frame.dispose();
    }
    
    public String mostrarInputDialog(String mensaje) {
        return javax.swing.JOptionPane.showInputDialog(frame, mensaje);
    }
    
    public void mostrarMessageDialogError(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public String obtenerOpcionSeleccionada() {
        return (String) comboBox.getSelectedItem();
    }
}
