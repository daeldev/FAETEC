programa
{
	
	funcao inicio()
	{	caracter no
		inteiro qu
	     real pu, ve, co, t
	     
		escreva ("Digite o seu nome: ")
	     	leia (no)
	    
		escreva ("Digite a quantidade de peças que foram vendidas: ")
			leia (qu)
			escreva ("\n")

		pu = 4.50
		
		ve = qu * pu
		     escreva ("Olá, ", no, "!\n")
		     
			escreva ("Foram vendidas ", qu, " peças\n")
			escreva ("\n")
			
			escreva ("A sua venda gerou: ", ve, " reais\n")
			escreva ("\n")
			
		co = 0.05 * ve
			escreva ("A sua comissão foi de: ", co, " reais\n")
			escreva ("\n")

		t = co + ve
			escreva ("O total ganho foi de: ", t)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 558; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */