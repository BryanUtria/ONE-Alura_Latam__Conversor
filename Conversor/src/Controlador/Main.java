package Controlador;

public class Main {
	
	public static void main(String[] args) {	
        Modelos.ConversionMoneda modelo = new Modelos.ConversionMoneda();
        Vista.Principal vistaPrin = new Vista.Principal();
        Vista.ConversorMoneda vistaCM = new Vista.ConversorMoneda();
        Vista.ConversorUnidades vistaCU = new Vista.ConversorUnidades();
        Vista.ConversorTemperatura vistaCT= new Vista.ConversorTemperatura();
        Controlador controlador = new Controlador(modelo, vistaPrin, vistaCM, vistaCU, vistaCT);
        controlador.iniciar();
    }
}
