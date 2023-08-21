package Modelos;

public class ConversionMoneda {

	public float PesosColombianos_Dolar(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int moneda = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        float resultado = Float.parseFloat(cantidadDinero) / Float.parseFloat(valorMoneda);
		return resultado;
	}
	
	public float PesosColombianos_Euro(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int monedaCOP = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMonedaCOP = tasaDeCambioMoneda.indexOf("value", monedaCOP);
        int posFinalMonedaCOP = tasaDeCambioMoneda.indexOf("}", posInicialMonedaCOP);
        String valorPesoCOP = tasaDeCambioMoneda.substring(posInicialMonedaCOP+7, posFinalMonedaCOP);
        
        int moneda = tasaDeCambioMoneda.indexOf("\"EUR\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        
        float resultado = (Float.parseFloat(cantidadDinero)*Float.parseFloat(valorMoneda)) / Float.parseFloat(valorPesoCOP);
		return resultado;
	}
	
	public float PesosColombianos_Libras(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int monedaCOP = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMonedaCOP = tasaDeCambioMoneda.indexOf("value", monedaCOP);
        int posFinalMonedaCOP = tasaDeCambioMoneda.indexOf("}", posInicialMonedaCOP);
        String valorPesoCOP = tasaDeCambioMoneda.substring(posInicialMonedaCOP+7, posFinalMonedaCOP);
        
        int moneda = tasaDeCambioMoneda.indexOf("\"GBP\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        
        float resultado = (Float.parseFloat(cantidadDinero)*Float.parseFloat(valorMoneda)) / Float.parseFloat(valorPesoCOP);
		return resultado;
	}
	
	public float PesosColombianos_Yen(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int monedaCOP = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMonedaCOP = tasaDeCambioMoneda.indexOf("value", monedaCOP);
        int posFinalMonedaCOP = tasaDeCambioMoneda.indexOf("}", posInicialMonedaCOP);
        String valorPesoCOP = tasaDeCambioMoneda.substring(posInicialMonedaCOP+7, posFinalMonedaCOP);
        
        int moneda = tasaDeCambioMoneda.indexOf("\"JPY\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        
        float resultado = (Float.parseFloat(cantidadDinero)*Float.parseFloat(valorMoneda)) / Float.parseFloat(valorPesoCOP);
		return resultado;
	}
	
	public float PesosColombianos_Won(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int monedaCOP = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMonedaCOP = tasaDeCambioMoneda.indexOf("value", monedaCOP);
        int posFinalMonedaCOP = tasaDeCambioMoneda.indexOf("}", posInicialMonedaCOP);
        String valorPesoCOP = tasaDeCambioMoneda.substring(posInicialMonedaCOP+7, posFinalMonedaCOP);
        
        int moneda = tasaDeCambioMoneda.indexOf("\"KRW\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        
        float resultado = (Float.parseFloat(cantidadDinero)*Float.parseFloat(valorMoneda)) / Float.parseFloat(valorPesoCOP);
		return resultado;
	}
	
	public float Dolar_PesosColombianos(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int moneda = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        float resultado = Float.parseFloat(cantidadDinero) * Float.parseFloat(valorMoneda);
		return resultado;
	}
	
	public float Euro_PesosColombianos(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int monedaCOP = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMonedaCOP = tasaDeCambioMoneda.indexOf("value", monedaCOP);
        int posFinalMonedaCOP = tasaDeCambioMoneda.indexOf("}", posInicialMonedaCOP);
        String valorPesoCOP = tasaDeCambioMoneda.substring(posInicialMonedaCOP+7, posFinalMonedaCOP);
        
        int moneda = tasaDeCambioMoneda.indexOf("\"EUR\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        
        float resultado = (Float.parseFloat(cantidadDinero)*Float.parseFloat(valorPesoCOP)) / Float.parseFloat(valorMoneda);
		return resultado;
	}
	
	public float Libras_PesosColombianos(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int monedaCOP = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMonedaCOP = tasaDeCambioMoneda.indexOf("value", monedaCOP);
        int posFinalMonedaCOP = tasaDeCambioMoneda.indexOf("}", posInicialMonedaCOP);
        String valorPesoCOP = tasaDeCambioMoneda.substring(posInicialMonedaCOP+7, posFinalMonedaCOP);
        
        int moneda = tasaDeCambioMoneda.indexOf("\"GBP\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        
        float resultado = (Float.parseFloat(cantidadDinero)*Float.parseFloat(valorPesoCOP)) / Float.parseFloat(valorMoneda);
		return resultado;
	}
	
	public float Yen_PesosColombianos(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int monedaCOP = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMonedaCOP = tasaDeCambioMoneda.indexOf("value", monedaCOP);
        int posFinalMonedaCOP = tasaDeCambioMoneda.indexOf("}", posInicialMonedaCOP);
        String valorPesoCOP = tasaDeCambioMoneda.substring(posInicialMonedaCOP+7, posFinalMonedaCOP);
        
        int moneda = tasaDeCambioMoneda.indexOf("\"JPY\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        
        float resultado = (Float.parseFloat(cantidadDinero)*Float.parseFloat(valorPesoCOP)) / Float.parseFloat(valorMoneda);
		return resultado;
	}
	
	public float Won_PesosColombianos(String tasaDeCambioMoneda, String cantidadDinero) {
		
		int monedaCOP = tasaDeCambioMoneda.indexOf("\"COP\":");
        int posInicialMonedaCOP = tasaDeCambioMoneda.indexOf("value", monedaCOP);
        int posFinalMonedaCOP = tasaDeCambioMoneda.indexOf("}", posInicialMonedaCOP);
        String valorPesoCOP = tasaDeCambioMoneda.substring(posInicialMonedaCOP+7, posFinalMonedaCOP);
        
        int moneda = tasaDeCambioMoneda.indexOf("\"KRW\":");
        int posInicialMoneda = tasaDeCambioMoneda.indexOf("value", moneda);
        int posFinalMoneda = tasaDeCambioMoneda.indexOf("}", posInicialMoneda);
        String valorMoneda = tasaDeCambioMoneda.substring(posInicialMoneda+7, posFinalMoneda);
        
        float resultado = (Float.parseFloat(cantidadDinero)*Float.parseFloat(valorPesoCOP)) / Float.parseFloat(valorMoneda);
		return resultado;
	}
}
