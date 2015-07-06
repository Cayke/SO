
public final class  GerenciadorMemoria {	//classe singleton
	//instancia que representa a classe
	private static GerenciadorMemoria instance = null;

	//define size bits map
	private static final int sizeOfMap = 1024;
	private static final int sizeOfRealTime = 64;

	//mapa de bits
	private boolean[] bitsMap;

	private GerenciadorMemoria() {
		//criar mapa de bits X posicoes
		bitsMap = new boolean[sizeOfMap];

	}

	public static GerenciadorMemoria getInstance()
	{
		if (instance == null)
		{
			instance = new GerenciadorMemoria();
		}
		return instance;
	}

	//printa valores do mapa de bits
	public void printMap ()
	{
		int i;
		for (i = 0; i < sizeOfMap; i++)
		{
			System.out.println ("pos[" + i + "] = " + bitsMap[i]);
		}
	}

	//procura um espaco de valor X de bits na memoria, caso nao haja espaco retorna -1, caso haja retorna o endereco base e aloca
	// uso do algoritmo First Fit
	public int searchForSpaceRealTimeMemory(int sizeNeeded)
	{
		int baseRegister = -1;
		int freeSpaces = 0;

		for (int i = 0; i < sizeOfRealTime; i++)
		{
			if (bitsMap[i] == false) // posicao vazia
			{
				freeSpaces++;

				if (freeSpaces < sizeNeeded && baseRegister == -1) //achou primeiro espaco livre nessa busca e tamanho ainda nao cabe, seta base register e continua
				{
					baseRegister = i;
				}
				else if (freeSpaces < sizeNeeded && baseRegister != -1) //ja setou baseRegister e ainda nao cabe
				{
					//nao faz nada, so continua procurando
				}
				else if (freeSpaces == sizeNeeded && baseRegister == -1) //achou primeiro espaco livre nessa busca e processo so precisa de 1 espaco
				{
					baseRegister = i;

					//aloca e retorna baseRegister
					return this.allocMemoryWithBaseRegisterAndSize(baseRegister, sizeNeeded);
				}

				else if (freeSpaces == sizeNeeded && baseRegister != -1) //espacos continuos >= tamanho necessario para alocao
				{
					//aloca e retorna baseRegister
					return this.allocMemoryWithBaseRegisterAndSize(baseRegister, sizeNeeded);
				}
				else 
				{
					//freeEspaces < sizeNeeded  
					//nao faz nada
				}
			}

			else //posicao preenchida 
			{
				//reseta os valores e continua a procurar
				baseRegister = -1;
				freeSpaces = 0;
			}
		}


		//apagar
		//System.out.println("Falha ao alocar memoria. Nao ha espaco.");

		//nao achou espaco
		return -1;
	}

	//procura um espaco de valor X de bits na memoria, caso nao haja espaco retorna -1, caso haja retorna o endereco base e aloca
	// uso do algoritmo First Fit
	public int searchForSpaceInUserMemory(int sizeNeeded)
	{
		int baseRegister = -1;
		int freeSpaces = 0;

		for (int i = sizeOfRealTime; i < sizeOfMap; i++)
		{
			if (bitsMap[i] == false) // posicao vazia
			{
				freeSpaces++;

				if (freeSpaces < sizeNeeded && baseRegister == -1) //achou primeiro espaco livre nessa busca e tamanho ainda nao cabe, seta base register e continua
				{
					baseRegister = i;
				}
				else if (freeSpaces < sizeNeeded && baseRegister != -1) //ja setou baseRegister e ainda nao cabe
				{
					//nao faz nada, so continua procurando
				}
				else if (freeSpaces == sizeNeeded && baseRegister == -1) //achou primeiro espaco livre nessa busca e processo so precisa de 1 espaco
				{
					baseRegister = i;

					//aloca e retorna baseRegister
					return this.allocMemoryWithBaseRegisterAndSize(baseRegister, sizeNeeded);
				}

				else if (freeSpaces == sizeNeeded && baseRegister != -1) //espacos continuos >= tamanho necessario para alocao
				{
					//aloca e retorna baseRegister
					return this.allocMemoryWithBaseRegisterAndSize(baseRegister, sizeNeeded);
				}
				else 
				{
					//freeEspaces < sizeNeeded  
					//nao faz nada
				}
			}

			else //posicao preenchida 
			{
				//reseta os valores e continua a procurar
				baseRegister = -1;
				freeSpaces = 0;
			}
		}


		//apagar
		//System.out.println("Falha ao alocar memoria. Nao ha espaco.");

		//nao achou espaco
		return -1;
	}

	private int allocMemoryWithBaseRegisterAndSize(int baseRegister, int size)
	{
		//apenas para aumentar robustez do sistema confere se realmente esta vazio esse espaco pedido
		for (int i = baseRegister; i < baseRegister+size; i++)
		{
			if (bitsMap[i] == true)
			{
				return -1;
			}
		}

		//alocar o espaco
		for (int i = baseRegister; i < baseRegister + size; i++)
		{
			bitsMap[i] = true;
		}

		//apagar
		//System.out.println("Alocou memoria com sucesso. Registrador base = " + baseRegister + " , tamanho = " + size);
		//GerenciadorMemoria.getInstance().printMap();

		return baseRegister;
	}

	public void deallocMemoryWithBaseRegisterAndSize(int baseRegister, int size)
	{
		//desalocar o espaco
		for (int i = baseRegister; i < baseRegister + size; i++)
		{
			bitsMap[i] = false;
		}

		//apagar
		//System.out.println("Desalocou memoria com sucesso. Registrador base = " + baseRegister + " , tamanho = " + size);
		//GerenciadorMemoria.getInstance().printMap();
	}


}