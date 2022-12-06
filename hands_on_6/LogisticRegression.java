package hands_on_6;

import java.util.ArrayList;

public class LogisticRegression {

	private ArrayList<Double> w;
	private ArrayList<Double>[] data;
	private ArrayList<Double> y;
	private double learningRate;
	private double resultado;
	
	

	@SuppressWarnings("unchecked")
	public LogisticRegression() {
		
		w=new ArrayList<Double>();
		data=new ArrayList[3];
		y=new ArrayList<Double>();
		resultado=0;
		
		
		inicilizar();
		
	}		
	private void inicilizar() {
		for(int i=0;i<data.length;i++) {
			data[i]=new ArrayList<Double>();
		}
		
		data[0].add(1.0);
		data[0].add(1.0);
		data[0].add(1.0);
		
		data[1].add(1.0);
		data[1].add(4.0);
		data[1].add(2.0);
		
		data[2].add(1.0);
		data[2].add(2.0);
		data[2].add(4.0);
		
		w.add(0.0);
		w.add(0.0);
		w.add(0.0);
		
		y.add(0.0);
		y.add(1.0);
		y.add(1.0);
		learningRate=0.1;
	}

	public void start() {
		int i=0;
		printDatos();
		printW();
		while(i<100) {
			i++;
			
			train();
			//printp();
			printW();
			
		}
		System.out.println("-------------------------------");
		
	}
	public void train() {
		
		int j=0;
		ArrayList<Double> aux=new ArrayList<Double>();
		double suma=0;
		for(int i=0;i<w.size();i++) {
			suma=0;
			suma=(y.get(0) -sigmoideTR(0))*data[j].get(0)  + (y.get(1) - sigmoideTR(1))*data[j].get(1) +(y.get(2) - sigmoideTR(2))*data[j].get(2);
			suma=w.get(j) + learningRate*suma;
			
			aux.add(suma);
			j++;
			
		}
		//actualizacion de los pesos
		for(int i=0;i<aux.size();i++) {
			suma=aux.get(i);
			w.set(i, suma);
		}
		
		//sigmoide();
	}
	
	
	public double evaluacion(double a,double b) {
		//evaluacion de la sigmoide con los datos finales
		
		double elevado=0;
		double suma=0;
		elevado=w.get(0)+(w.get(1)*a)+(w.get(2)*b);
		elevado=-1*elevado;
		
		suma=1/(1+Math.pow(Math.E, elevado));
		resultado=suma;
		return suma;
	}
	public double sigmoideTR(int indice) {
		//realiza el calculo de la sigmoide 
		//usada cuando se esta iterando con el for
		
		double elevado=0;
		double suma=0;
		elevado=w.get(0)+(w.get(1)*data[indice].get(1))+(w.get(2)*data[indice].get(2));
		elevado=-1*elevado;
		
		suma=1/(1+Math.pow(Math.E, elevado));
		resultado=suma;
		return suma;
		
	}
	public double sigmoide(double a) {
		
		double suma=0;
		
		a=-1*a;
		
		suma=1/(1+Math.pow(Math.E, a));
		
		return suma;
	}
	
	
	
	
	public void printDatos() {
		System.out.println("los valores de los pesos son ");
		for(int i=0;i<data.length;i++) {
			for (int j=0;j<data[i].size();j++) {
				
				System.out.print(String.format("  "+"%.5f", data[i].get(j)));
			}
			System.out.println("");
			
		}
		
	}
	public void printW() {
		System.out.println("El vector w es ");
		for (int i=0;i<w.size();i++) {
			System.out.print(String.format("%.5f  ", w.get(i)));
		}
		System.out.println("");
		
	}
	public void printp() {
		//System.out.println("El resultado "+(y.get(2) - 0.5)*data[0].get(2));
		System.out.println(String.format("%.5f  ", resultado));
	}
	
	
}
