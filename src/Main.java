
public class Main {
	static GerenciadorDeProcessos gerenciadorProcessos = new GerenciadorDeProcessos();
	
	public static void main(String[] args) throws Exception {
		gerenciadorProcessos.leArquivoComProcessos();
		//gerenciadorProcessos.imprimeProcessos();
		gerenciadorProcessos.loopPrincipal();
		
	}
}
