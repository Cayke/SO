import java.util.concurrent.Semaphore;
 
public class GerenciaDeRecursos {
	
	Semaphore scanner = new Semaphore(1);
    Semaphore impressora1 = new Semaphore(1);
    Semaphore impressora2 = new Semaphore(1);
    Semaphore modem = new Semaphore(1);
    Semaphore sata1 = new Semaphore(1);
    Semaphore sata2 = new Semaphore(1);
    
    public void resquisitarScanner(){
    	try {
			scanner.acquire();
			System.out.println("scanner adquirido");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void resquisitarImpressora(int numero){
    	try {
    		if(numero == 1){
    			impressora1.acquire();
    			System.out.println("impressora1 adquirido");
    		}
    		if(numero == 2){
    			impressora2.acquire();
    			System.out.println("impressora2 adquirido");    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void resquisitarModem(){
    	try {
			modem.acquire();
			System.out.println("modem adquirido");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void resquisitarSata(int numero){
    	try {
			if(numero == 1){
				sata1.acquire();
				System.out.println("sata1 adquirido");
			}
			if(numero == 2){
				sata2.acquire();
				System.out.println("sata2 adquirido");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void liberarScanner(){
    	try {
			scanner.release();
			System.out.println("scanner liberado");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void liberarImpressora(int numero){
    	try {
			if(numero == 1){
				impressora1.release();
				System.out.println("impressora1 liberado");
			}
			if(numero == 2){
				impressora2.release();
				System.out.println("impressora2 liberado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void liberarModem(){
    	try {
			modem.release();
			System.out.println("modem liberado");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void liberarSata(int numero){
    	try {
    		if(numero == 1){
    			sata1.release();
    			System.out.println("sata1 liberado");
    		}
    		if(numero == 2){
    			sata2.release();
    			System.out.println("sata2 liberado");
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }    
}
