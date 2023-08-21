package Vista;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConversorTemperatura {
	private JFrame frame;
    private JComboBox<String> comboBox;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    public ConversorTemperatura() {
    	//-------- Pantalla Inicial -----------------
		frame = new JFrame("Menu");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(350, 200);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    
	    //-------- Panel Principal -----------------
	    JPanel panel = new JPanel();
	    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
	    //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    
	    //-------- Descripcion -----------------
	    JLabel label = new JLabel("Elija la temperatura a la que desea convertir:");
	    panel.add(label);
	    
	    //-------- Selector de Conversor -----------------
	    String[] opciones = {"De Celsius a Fahrenheit", 
							"De Celsius a Kelvin", 
							"De Fahrenheit a Celsius",
							"De Fahrenheit a Kelvin",
							"De Kelvin a Celsius",
							"De Kelvin a Fahrenheit"};
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
    
    public void mostrarMessageDialogInfo(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String obtenerOpcionSeleccionada() {
        return (String) comboBox.getSelectedItem();
    }
    
    public int mostrarQuestionMessage(String mensaje) {
        return javax.swing.JOptionPane.showConfirmDialog(null, mensaje, "Selecciona una Opcion", JOptionPane.YES_NO_OPTION);
    }
}
