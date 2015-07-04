import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GerenciadorDeProcessos {
	Fila filaGlobal = new Fila();
	Fila filaKernel = new Fila();
	Fila filaUsuario1 = new Fila();
	Fila filaUsuario2 = new Fila();
	Fila filaUsuario3 = new Fila();

	public void loopPrincipal() {
		boolean temProcessos = true;
		int cicloAtual = 0;
		Processo processoExecutando = null;
		while (temProcessos) {
			
			globalParaLocal(cicloAtual);
			
			if (processoExecutando != null) {
				if(!processoExecutando.executaInstrucoes()){
					processoExecutando = null;
				}
				else if(preempcao(processoExecutando.getPrioridade())){
					aumentaPrioridade(processoExecutando);
					processoExecutando = null;
				}
				
			} else {
				processoExecutando = achaProcessoPraExecutar();
				if (processoExecutando == null && filaGlobal.tamanho() == 0) {
					temProcessos = false;
				} else {
					if (processoExecutando != null) {
						System.out.println(processoExecutando.toString());
						System.out.println("P" + Integer.toString(processoExecutando.getPID()) + " STARTED");
					}
				}
			}
			
			cicloAtual++;
		}
	}

	boolean preempcao(int prioridade){
		switch(prioridade){
			
			case 0:
				return false;
			case 1:
				return(filaKernel.tamanho() > 0);
			
			case 2:
				return(filaKernel.tamanho() > 0 || filaUsuario1.tamanho() > 0);
				
			case 3:
				return(filaKernel.tamanho() > 0 || filaUsuario1.tamanho() > 0 || filaUsuario2.tamanho() > 0);
				
			default:
				return false;
		}
		
	}
	
	void globalParaLocal(int cicloAtual){
		while (filaGlobal.tamanho() > 0
				&& filaGlobal.olhaProximo().getTempoInicializacao() == cicloAtual) 
		{
			Processo proximoProcesso = filaGlobal.remover();
			alocaProcessoAFila(proximoProcesso);
		}
		
	}
	
	void aumentaPrioridade(Processo p){
		if(p.getPrioridade()>0){
			p.sobePrioridade();
			alocaProcessoAFila(p);
		}
	}
	
	Processo achaProcessoPraExecutar() {
		Processo p;
		p = filaKernel.remover();
		if (p != null)
			return p;
		p = filaUsuario1.remover();
		if (p != null)
			return p;
		p = filaUsuario2.remover();
		if (p != null)
			return p;
		p = filaUsuario3.remover();
		if (p != null)
			return p;

		return null;
	}

	void alocaProcessoAFila(Processo p) {
		switch (p.getPrioridade()) {

		case 0:
			filaKernel.inserir(p);
			break;
		case 1:
			filaUsuario1.inserir(p);
			break;
		case 2:
			filaUsuario2.inserir(p);
			break;
		case 3:
			filaUsuario3.inserir(p);
			break;

		}
	}

	public void leArquivoComProcessos() {
		try {
			InputStream is = new FileInputStream("arquivotesteSO.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String linha = br.readLine();

			while (linha != null) {
				// System.out.println(linha);
				Processo p = new Processo(linha.replaceAll(" ", ""));
				filaGlobal.inserir(p);
				linha = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo ruim");
		} catch (IOException e) {
			System.out.println("Deu ruim");
		}
	}

	public void imprimeProcessos() {
		filaGlobal.imprime();
	}
}
