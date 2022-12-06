package neural_Network;

import java.util.ArrayList;

public class DataSet {
		
	ArrayList<Double>[] pesos1;
	ArrayList<Double>[] pesos2;
	ArrayList<Double> t;//Salidas deseadas
	ArrayList<Double>valuesX;
	
	@SuppressWarnings("unchecked")
	public DataSet() {
		
		pesos1=new ArrayList[2];
		pesos2=new ArrayList[2];
		t=new ArrayList<Double>();
		valuesX=new ArrayList<Double>();
		inicializar();
		
	
	}
	public void inicializar() {
		
		
		for (int i = 0; i < 2; i++) {
            pesos1[i] = new ArrayList<Double>();
            pesos2[i]=new ArrayList<Double>(); 
        }
		
		
		//matriz 1
		pesos1[0].add(0.5);//bias 1
		pesos1[0].add(0.1);//w1
		pesos1[0].add(0.3);//w3
		pesos1[0].add(0.5);//w5

		
		pesos1[1].add(0.5);//bias 1
		pesos1[1].add(0.2);
		pesos1[1].add(0.4);
		pesos1[1].add(0.6);
		//matriz 2
		pesos2[0].add(0.5);
		pesos2[0].add(0.7);
		pesos2[0].add(0.9);
		
		pesos2[1].add(0.5);
		pesos2[1].add(0.8);
		pesos2[1].add(0.1);	
		
		t.add(0.1);
		t.add(0.5);
		
		valuesX.add(1.0);
		valuesX.add(4.0);
		valuesX.add(5.0);
		
		
	}
	public void printPesos() {
		
		System.out.println("Los valores de la matriz 1 son");
		
		for (int i=0;i<2;i++) {
			for(int y=0;y<pesos1[i].size();y++) {
				System.out.print(pesos1[i].get(y) + " ");
			}
			System.out.println(" ");
		}
		
		System.out.println("Los valores de la matriz 2 son");
		for (int i=0;i<2;i++) {
			for(int y=0;y<pesos2[i].size();y++) {
				System.out.print(pesos2[i].get(y) + " ");
			}
			System.out.println(" ");
		}
	}
	public void printDeseado() {
		
	}
	public ArrayList[] getPesos1() {
		return pesos1;
	}
	public ArrayList[] getPesos2() {
		return pesos2;
	}
	
	
	
	
	
}
