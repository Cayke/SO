import java.util.concurrent.Semaphore;
 
public class GerenciaDeRerusos {
	
	static Semaphore scanner = new Semaphore(1);
    static Semaphore impressora = new Semaphore(2);
    static Semaphore modem = new Semaphore(1);
    static Semaphore sata = new Semaphore(2);
    
    public static void resquisitarScanner(){
    	try {
			scanner.acquire();
			System.out.println("scanner adquirido");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void resquisitarImpressora(){
    	try {
			impressora.acquire();
			System.out.println("impressora adquirido");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void resquisitarModem(){
    	try {
			modem.acquire();
			System.out.println("modem adquirido");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void resquisitarSata(){
    	try {
			sata.acquire();
			System.out.println("sata adquirido");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void liberarScanner(){
    	try {
			scanner.release();
			System.out.println("scanner liberado");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void liberarImpressora(){
    	try {
			impressora.release();
			System.out.println("impressora liberado");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void liberarModem(){
    	try {
			modem.release();
			System.out.println("modem liberado");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void liberarSata(){
    	try {
			sata.release();
			System.out.println("sata liberado");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
    	
    	resquisitarScanner();
    	liberarScanner();
    	resquisitarScanner();
    	liberarScanner();
    	resquisitarImpressora();
    	resquisitarImpressora();
    	liberarImpressora();
    	liberarImpressora();
    }
    
}
