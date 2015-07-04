
public class Processo {
	static int globalPID = 1;
	private int PID;
	private int tempoInicializacao;
	private int prioridade;
	private int offsetMemoria;
	private int blocos;
	private int tempoProcessador;
	
	private int contadorDeInstrucoes = 1;
	
	private boolean impressora;
	private boolean scanner;
	private boolean modem;
	private boolean drivers;
	
	public Processo(){
		PID = globalPID;
		globalPID++;
	}
	
	public Processo(int _tempoInicializacao, int _prioridade, int _offsetMemoria, int _blocos, int _tempoProcessador){
		this();
		tempoInicializacao = _tempoInicializacao;
		prioridade = _prioridade;
		offsetMemoria = _offsetMemoria;
		blocos = _blocos;
		tempoProcessador = _tempoProcessador;
	}
	
	public Processo(String s){
		this();
		String[] sp = s.split(",");
		tempoInicializacao = Integer.parseInt(sp[0]);
		prioridade = Integer.parseInt(sp[1]);
		tempoProcessador = Integer.parseInt(sp[2]);
		blocos = Integer.parseInt(sp[3]);
		impressora = (Integer.parseInt(sp[4]) != 0);
		scanner = (Integer.parseInt(sp[5]) != 0);
		modem = (Integer.parseInt(sp[6]) != 0);
		drivers = (Integer.parseInt(sp[7]) != 0);
	}
	
	public String toString(){
		String s;
		s = Integer.toString(PID) + ", "
			+ Integer.toString(tempoInicializacao) + ", "
			+ Integer.toString(prioridade) + ", "
			+ Integer.toString(tempoProcessador) + ", "
			+ Integer.toString(blocos);
		return s;
		
	}
	
	public boolean executaInstrucoes(){
		if (contadorDeInstrucoes <= tempoProcessador) {
			System.out.println("P"+ Integer.toString(PID)+ " instruction "+ Integer.toString(contadorDeInstrucoes));
			contadorDeInstrucoes++;
			return true;
		} else {
			System.out.println("P"+ Integer.toString(PID)+ " return SIGINT");
			return false;
		}
		
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void sobePrioridade(){
		if(prioridade < 3){
			this.prioridade++;
		}
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public static int getGlobalPID() {
		return globalPID;
	}

	public int getPID() {
		return PID;
	}

	public int getTempoInicializacao() {
		return tempoInicializacao;
	}

	public int getOffsetMemoria() {
		return offsetMemoria;
	}

	public int getBlocos() {
		return blocos;
	}

	public int getTempoProcessador() {
		return tempoProcessador;
	}

	public int getContadorDeInstrucoes() {
		return contadorDeInstrucoes;
	}

	public boolean isImpressora() {
		return impressora;
	}

	public boolean isScanner() {
		return scanner;
	}

	public boolean isModem() {
		return modem;
	}

	public boolean isDrivers() {
		return drivers;
	}
	
	
	
	
	

	
	
	
	

}
