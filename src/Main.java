
public class Main {
	static GerenciadorDeProcessos gerenciadorProcessos = new GerenciadorDeProcessos();
	
	public static void main(String[] args) {
		gerenciadorProcessos.leArquivoComProcessos();
		//gerenciadorProcessos.imprimeProcessos();
		gerenciadorProcessos.loopPrincipal();
		
	}
}
