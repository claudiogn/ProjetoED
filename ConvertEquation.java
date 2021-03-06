/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class ConvertEquation {
	
	String equation; //A’BC+AB+B’C’D
	int qtdLinhas = 1;
	boolean[] colunas = new boolean[4];
	int qtdColunas = 0;
	
	public ConvertEquation(String equation) {
		
		
                this.equation= equation + ' ';// isso aqui é pq quando tinha "A+C", ele setava x no C
		
		for (int i = 0; i < colunas.length; i++) {
			colunas[i] = false;
		}
		
		linhas(this.equation);
		colunas(this.equation);
	}

	private void linhas(String equation) {
		
		for (int i = 0; i < equation.length(); i++) {
			if(equation.charAt(i) == '+'){
				qtdLinhas++;
			}
		}
	}
	
	private void colunas(String equation){
		for (int i = 0; i < equation.length(); i++) {
			
                    
            		if(equation.charAt(i) == 'A')
				colunas[0] = true;
            		if(equation.charAt(i) == 'B'){                            
				colunas[0]=true;
                		colunas[1] = true;
        		 }
        		 if(equation.charAt(i) == 'C'){
/* se eu nao botasse esses outros true, se eu tivesse "C" por exemplo, a matriz so ia ter
uma coluna, mas na hora de setar no metodo analise, ele setaria na coluna 3, logo daria erro
Tendo em vista que, se o usuário quiser por uma equaçao de duas variaveis, não faz sentido
por A e D, mas sim A e B. Todavia como, a priori, não é necessário economizar espaço
deixaremos desse jeito
*/
				colunas[0]=true;
                		colunas[1] = true;
                		colunas[2] = true;
			 }
            		if(equation.charAt(i) == 'D'){
				colunas[0]=true;
                		colunas[1] = true;
                		colunas[2] = true;
                		colunas[3] = true;
        		}
		}
		for (int i = 0; i < colunas.length; i++) {
			if(colunas[i] == true){
				qtdColunas++;
			}
		}
	}
        
        
	
	public void imprimirLinhas(){
		System.out.println(qtdLinhas);
	}
	
	public void imprimirColunas(){
		System.out.println(qtdColunas);
	}
	
	public char[][] analise(){
		RelationMatrix m = new RelationMatrix(qtdLinhas, qtdColunas);
		int l = 0;
		for (int i = 0; i < equation.length(); i++) {
			if(equation.charAt(i) == '+')
				l++;
				
			switch (equation.charAt(i)) {
				case 'A':
					caractere(m,'A',0,i,l);
					break;
				case 'B':
					caractere(m,'B',1,i,l);
					break;
				case 'C':
					caractere(m,'C',2,i,l);
					break;
				case 'D':
					caractere(m,'D',3,i,l);
					break;
				default:
					break;
			}
		}
		return m.getMatrix();
	}
	
	private void caractere(RelationMatrix m, char caractere, int coluna, int i, int l){
		if((i+1) < equation.length()){
			if(equation.charAt(i+1) != '\''){
				m.setDados(l,coluna,'1');
			}else if(equation.charAt(i+1) == '\''){
				m.setDados(l,coluna,'0');
			}
		}
	}
}
