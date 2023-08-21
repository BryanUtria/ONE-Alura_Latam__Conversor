package Vista;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConversorUnidades {
	private JFrame frame;
    private JComboBox<String> comboBox;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    public ConversorUnidades() {
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
	    JLabel label = new JLabel("Elija la unidades de medida a la que desea convertir:");
	    panel.add(label);
	    
	    //-------- Selector de Conversor -----------------
	    String[] opciones = {"De kilometros a metros", 
							"De Kilometros a centimetros", 
							"De Kilometros a milimetros",
							"De metros a Kilometros",
							"De metros a centimetros",
							"De metros a milimetros",
							"De centimetros a kilometros",
							"De centimetros a metros",
							"De centimetros a milimetros",
							"De milimetro a kilometros",
							"De milimetro a metros",
							"De milimetro a centimetros"};
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
