import java.util.LinkedList;
import java.util.List;


public class Fila {
	private List<Processo> processos = new LinkedList<Processo>();
	
	public Fila(){
		
	}
	
	public void inserir(Processo p){
		processos.add(p);
	}
	
	public Processo remover(){
		try{
		return processos.remove(0);
		}
		catch(IndexOutOfBoundsException e){
			return null;
		}
	}
	
	public Processo olhaProximo(){
		return processos.get(0);
	}
	
	public void imprime(){
		for(int i = 0; i<processos.size(); i++){
			Processo p = processos.get(i);
			System.out.println(p.toString());
		}
	}
	
	public int tamanho(){
		return processos.size();
	}

}
