/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Principal {
	
                public void run(String eq){
                    ConvertEquation q = new ConvertEquation(eq);
		char[][] matriz = q.analise();
		for(int i = 0; i < matriz.length; i++ ){
			for(int j = 0; j < matriz[0].length; j++){
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
            }
    
                
	}
