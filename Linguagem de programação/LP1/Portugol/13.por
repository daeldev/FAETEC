programa
{
	
	funcao inicio()
	{
	
		inteiro ht, he
		real tr, ex, sb, sl
		
		escreva ("Quantas horas foram trabalhadas: ")
		leia (tr)
		
          escreva ("Quantas horas extras foram trabalhadas: ")
		leia (ex)
		
		ht = 10
		he = 15

		sb = (ht*tr)+(he*ex)
		sl = sb-(0.01*sb)

		limpa ()
		
		escreva ("O seu salário bruto foi de: ", sb," reais\n")
		escreva ("O seu salário líquido foi de: ", sl," reais")
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 259; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */