package Vista;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConversorMoneda {
    
    private JFrame frame;
    private JComboBox<String> comboBox;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    public ConversorMoneda() {
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
	    JLabel label = new JLabel("Elija la moneda a la que desea convertir su dinero:");
	    panel.add(label);
	    
	    //-------- Selector de Conversor -----------------
	    String[] opciones = {"De Pesos Colombianos a Dolar", 
							"De Pesos Colombianos a Euro", 
							"De Pesos Colombianos a Libras",
							"De Pesos Colombianos a Yen",
							"De Pesos Colombianos a Won Coreano",
							"De Dolar a Pesos Colombianos",
							"De Euro a Pesos Colombianos",
							"De Libras a Pesos Colombianos",
							"De Yen a Pesos Colombianos",
							"De Won Coreano a Pesos Colombianos"};
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
