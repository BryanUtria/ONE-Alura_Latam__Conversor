package Controlador;

import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;

import Modelos.ApiConversionMoneda;
import Modelos.ApiWolframAlpha;

public class Controlador {
	
	private Modelos.ConversionMoneda modelo;
    private Vista.Principal vistaPrin;
    private Vista.ConversorMoneda vistaCM;
    private Vista.ConversorUnidades vistaCU;
    private Vista.ConversorTemperatura vistaCT;
    
    public String tasaDeCambioMoneda;
    boolean BanCM = false;
    String cantidad;
    DecimalFormat formatoDecimal = new DecimalFormat("#.##");

    public Controlador(Modelos.ConversionMoneda modelo, Vista.Principal vistaPrin, Vista.ConversorMoneda vistaCM, Vista.ConversorUnidades vistaCU, Vista.ConversorTemperatura vistaCT) {
        this.modelo = modelo;
        this.vistaPrin = vistaPrin;
        this.vistaCM = vistaCM;
        this.vistaCU = vistaCU;
        this.vistaCT = vistaCT;        
        
        vistaPrin.BtnAceptarListener(new VistaPrinBtnAceptarListener());
        vistaPrin.BtnCancelarListener(new VistaPrinBtnCancelarListener());
        vistaCM.BtnAceptarListener(new VistaCMBtnAceptarListener());
        vistaCM.BtnCancelarListener(new VistaCMBtnCancelarListener());
        vistaCT.BtnAceptarListener(new VistaCTBtnAceptarListener());
        vistaCT.BtnCancelarListener(new VistaCTBtnCancelarListener());
        vistaCU.BtnAceptarListener(new VistaCUBtnAceptarListener());
        vistaCU.BtnCancelarListener(new VistaCUBtnCancelarListener());
    }

    public void iniciar() {
    	vistaPrin.mostrar();
    }
    
    private class VistaPrinBtnAceptarListener implements ActionListener {
    	
        public void actionPerformed(ActionEvent e) {
        	String conversion = vistaPrin.obtenerOpcionSeleccionada();
        	ApiConversionMoneda ApiCM = new ApiConversionMoneda();
        	
        	if(conversion == "Conversor de Moneda") {
        		String mensaje = "Ingrese la cantidad de dinero que desear convertir:";
        		cantidad = vistaPrin.mostrarInputDialog(mensaje);
                if(BanCM == false) {
                	tasaDeCambioMoneda = ApiCM.obtenerTasaDeCambioMoneda();
                	BanCM = true;
                }
                
                try {
                	if (cantidad == null) {
                    	
                	} else if (Float.parseFloat(cantidad) > 0) {
                    	vistaCM.mostrar();
                    	vistaPrin.CerrarVentana();
                	} else if (Float.parseFloat(cantidad) == 0) {
                		mensaje = "Ingrese un valor mayor a cero.";
                    	vistaPrin.mostrarMessageDialogError(mensaje);
                	}
                }  catch (NumberFormatException exe) {
                	mensaje = "Ingrese un valor válido.";
                	vistaPrin.mostrarMessageDialogError(mensaje);
                }
        	} else if(conversion == "Conversor de Temperatura") {
        		String mensaje = "Ingrese la cantidad que desear convertir:";
                cantidad = vistaPrin.mostrarInputDialog(mensaje);
                
                try {
                	if (cantidad == null) {
                    	
                	} else {
                    	vistaCT.mostrar();
                    	vistaPrin.CerrarVentana();
                	}
                }  catch (NumberFormatException exe) {
                	mensaje = "Ingrese un valor válido.";
                	vistaPrin.mostrarMessageDialogError(mensaje);
                }
        	} else if(conversion == "Conversor de Unidades") {
        		String mensaje = "Ingrese la cantidad que desear convertir:";
                cantidad = vistaPrin.mostrarInputDialog(mensaje);
                
                try {
                	if (cantidad == null) {
                    	
                	} else if (Float.parseFloat(cantidad) > 0) {
                    	vistaCU.mostrar();
                    	vistaPrin.CerrarVentana();
                	} else if (Float.parseFloat(cantidad) == 0) {
                		mensaje = "Ingrese un valor mayor a cero.";
                    	vistaPrin.mostrarMessageDialogError(mensaje);
                	}
                }  catch (NumberFormatException exe) {
                	mensaje = "Ingrese un valor válido.";
                	vistaPrin.mostrarMessageDialogError(mensaje);
                }
        	}
        }
    }
    
    private class VistaPrinBtnCancelarListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		vistaPrin.CerrarVentana();
        }
    }
    
    private class VistaCMBtnAceptarListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
        	String opcionSeleccionada = vistaCM.obtenerOpcionSeleccionada();
        	
        	if(opcionSeleccionada == "De Pesos Colombianos a Dolar") {
        		float resultado = modelo.PesosColombianos_Dolar(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("dolares", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Pesos Colombianos a Euro") {
        		float resultado = modelo.PesosColombianos_Euro(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("euros", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Pesos Colombianos a Libras") {
        		float resultado = modelo.PesosColombianos_Libras(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("libras", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Pesos Colombianos a Yen") {
        		float resultado = modelo.PesosColombianos_Yen(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("yenes japoneses", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Pesos Colombianos a Won Coreano") {
        		float resultado = modelo.PesosColombianos_Won(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("won surcoreanos", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Dolar a Pesos Colombianos") {
        		float resultado = modelo.Dolar_PesosColombianos(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("pesos Colombianos", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Euro a Pesos Colombianos") {
        		float resultado = modelo.Euro_PesosColombianos(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("pesos Colombianos", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Libras a Pesos Colombianos") {
        		float resultado = modelo.Libras_PesosColombianos(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("pesos Colombianos", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Yen a Pesos Colombianos") {
        		float resultado = modelo.Yen_PesosColombianos(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("pesos Colombianos", resultado);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Won Coreano a Pesos Colombianos") {
        		float resultado = modelo.Won_PesosColombianos(tasaDeCambioMoneda, cantidad);
        		mostrarResultado("pesos Colombianos", resultado);
        		mostrarConfirmacion();
        	}
    	}
    	
    	private void mostrarResultado(String moneda, float resultado) {
            vistaCM.mostrarMessageDialogInfo("Tienes $" + formatoDecimal.format(resultado) + " " + moneda + ".");
        }
    	
    	private void mostrarConfirmacion() {
            int respuesta = vistaCM.mostrarQuestionMessage("¿Desea continuar?");

            if (respuesta == JOptionPane.YES_OPTION) {
                vistaCM.CerrarVentana();
                vistaPrin.mostrar();
            } else if (respuesta == JOptionPane.NO_OPTION) {
                vistaCM.CerrarVentana();
                vistaPrin.CerrarVentana();
                vistaCM.mostrarMessageDialogInfo("Programa terminado.");
            }
        }
    }
    
    private class VistaCMBtnCancelarListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		vistaCM.CerrarVentana();
    		vistaPrin.mostrar();
        }
    }
    
    private class VistaCTBtnAceptarListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
        	String opcionSeleccionada = vistaCT.obtenerOpcionSeleccionada();
        	ApiWolframAlpha ApiCT = new ApiWolframAlpha();
        	
        	if(opcionSeleccionada == "De Celsius a Fahrenheit") {
        		String respuesta = ApiCT.obtenerInformacion(cantidad+"+Celsius+to+Fahrenheit");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Celsius a Kelvin") {
        		String respuesta = ApiCT.obtenerInformacion(cantidad+"+Celsius+to+Kelvin");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Fahrenheit a Celsius") {
        		String respuesta = ApiCT.obtenerInformacion(cantidad+"+Fahrenheit+to+Celsius");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Fahrenheit a Kelvin") {
        		String respuesta = ApiCT.obtenerInformacion(cantidad+"+Fahrenheit+to+Kelvin");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Kelvin a Celsius") {
        		String respuesta = ApiCT.obtenerInformacion(cantidad+"+Kelvin+to+Celsius");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Kelvin a Fahrenheit") {
        		String respuesta = ApiCT.obtenerInformacion(cantidad+"+Kelvin+to+Fahrenheit");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	}
    	}
    	
    	private void mostrarResultado(String resultado) {
            vistaCT.mostrarMessageDialogInfo("Resultado: "+resultado);
        }
    	
    	private void mostrarConfirmacion() {
            int respuesta = vistaCT.mostrarQuestionMessage("¿Desea continuar?");

            if (respuesta == JOptionPane.YES_OPTION) {
                vistaCT.CerrarVentana();
                vistaPrin.mostrar();
            } else if (respuesta == JOptionPane.NO_OPTION) {
                vistaCT.CerrarVentana();
                vistaPrin.CerrarVentana();
                vistaCT.mostrarMessageDialogInfo("Programa terminado.");
            }
        }
    }
    
    private class VistaCTBtnCancelarListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		vistaCT.CerrarVentana();
    		vistaPrin.mostrar();
        }
    }
    
    private class VistaCUBtnAceptarListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
        	String opcionSeleccionada = vistaCU.obtenerOpcionSeleccionada();
        	ApiWolframAlpha ApiCU = new ApiWolframAlpha();
        	
        	if(opcionSeleccionada == "De kilometros a metros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+km+to+m");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Kilometros a centimetros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+km+to+cm");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De Kilometros a milimetros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+km+to+mm");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De metros a Kilometros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+m+to+km");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De metros a centimetros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+m+to+cm");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De metros a milimetros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+m+to+mmm");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De centimetros a kilometros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+cm+to+km");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De centimetros a metros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+cm+to+m");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De centimetros a milimetros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+cm+to+mm");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De milimetro a kilometros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+mm+to+km");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De milimetro a metros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+mm+to+m");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	} else if(opcionSeleccionada == "De milimetro a centimetros") {
        		String respuesta = ApiCU.obtenerInformacion(cantidad+"+mm+to+cm");
        		mostrarResultado(respuesta);
        		mostrarConfirmacion();
        	}
    	}
    	
    	private void mostrarResultado(String resultado) {
            vistaCU.mostrarMessageDialogInfo("Resultado: "+resultado);
        }
    	
    	private void mostrarConfirmacion() {
            int respuesta = vistaCU.mostrarQuestionMessage("¿Desea continuar?");

            if (respuesta == JOptionPane.YES_OPTION) {
                vistaCU.CerrarVentana();
                vistaPrin.mostrar();
            } else if (respuesta == JOptionPane.NO_OPTION) {
                vistaCU.CerrarVentana();
                vistaPrin.CerrarVentana();
                vistaCU.mostrarMessageDialogInfo("Programa terminado.");
            }
        }
    }
    
    private class VistaCUBtnCancelarListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		vistaCU.CerrarVentana();
    		vistaPrin.mostrar();
        }
    }
}
