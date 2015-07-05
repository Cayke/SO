
public class Main {
	static GerenciadorDeProcessos gerenciadorProcessos = new GerenciadorDeProcessos();
	
	public static void main(String[] args) throws Exception {
		//gerenciadorProcessos.leArquivoComProcessos();
		////gerenciadorProcessos.imprimeProcessos();
		//gerenciadorProcessos.loopPrincipal();
		
		
		//teste		
		GerenciadorMemoria.getInstance().searchForSpaceInMemory(10);
		GerenciadorMemoria.getInstance().deallocMemoryWithBaseRegisterAndSize(0, 1);
		GerenciadorMemoria.getInstance().deallocMemoryWithBaseRegisterAndSize(5, 3);
		GerenciadorMemoria.getInstance().searchForSpaceInMemory(2);
	}
}
