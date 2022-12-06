package neural_Network;

import java.util.ArrayList;

public class Neurona {
	
	private ArrayList<Double>[] pesos1;
	private ArrayList<Double>[] pesos2;
	private ArrayList<Double> t;//Salidas deseadas
	private ArrayList<Double>valuesX;
	private ArrayList<Double>h;
	private ArrayList<Double>o;
	private ArrayList<Double>temporal_2;
	private ArrayList<Double>h_temporal;
	private ArrayList<Double> temporal_1;
	
	private double error;
	private double learingRate;
	
	@SuppressWarnings("unchecked")
	public Neurona() {
		
		pesos1=new ArrayList[2];
		pesos2=new ArrayList[2];
		h=new ArrayList<Double>();
		t=new ArrayList<Double>();
		valuesX=new ArrayList<Double>();
		o=new ArrayList<Double>();
		temporal_2=new ArrayList<Double>();
		h_temporal=new ArrayList<Double>();
		temporal_1=new ArrayList<Double>();
		error=1.0;
		
		learingRate=0.01;
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
		t.add(0.05);
		valuesX.add(1.0);
		valuesX.add(1.0);
		valuesX.add(4.0);
		valuesX.add(5.0);
		//los valores de h son 0
		h.add(0.0);
		h.add(0.0);
		o.add(0.0);
		o.add(0.0);
		temporal_2.add(0.0);
		temporal_2.add(0.0);
		temporal_2.add(0.0);
		temporal_2.add(0.0);
		temporal_2.add(0.0);
		
		temporal_1.add(0.0);
		temporal_1.add(0.0);
		temporal_1.add(0.0);
		temporal_1.add(0.0);
		temporal_1.add(0.0);
		temporal_1.add(0.0);
		temporal_1.add(0.0);

		
		h_temporal.add(0.0);
		h_temporal.add(0.0);
		
		
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


	public void entrenar() {
		double errorDeseado=0.001;
		int iterador=0;
		//calcular los valores para la primera capa
		while(error>errorDeseado) {
			HiddenLayer();//correr por l aprimera capa
			OutputLayer();//correcr por la segunda capa
			sumAquares();//calcular el error
			retropropagarError();
			propagarerror();
			capaOculta();
			//printH();
			//printPesos();
			actualizar();
			//printPesos();
			iterador++;
		}
		System.out.println("iteracion "+iterador);

		
		//printH();
	}


	private void actualizar() {
		// TODO Auto-generated method stub
		///capa exterior
		int k=0;
		
		for (int i=0;i<2;i++) {
			for (int j=1;j<pesos2[0].size();j++) {
				pesos2[i].set(j,  pesos2[i].get(j) - learingRate * temporal_2.get(k) ) ;
				k++;
			}
		}
		k=0;
		pesos2[0].set(0,   pesos2[0].get(0) - learingRate * temporal_2.get(4)  );
		pesos2[1].set(0,   pesos2[0].get(0) - learingRate * temporal_2.get(4)  );
		//capa oculta
		for (int i=0;i<2;i++) {
			for (int j=1;j<pesos1[0].size();j++) {
				pesos1[i].set(j,  pesos1[i].get(j) - learingRate * temporal_1.get(k) ) ;
				k++;
			}
		}
		pesos1[0].set(0,   pesos1[0].get(0) - learingRate * temporal_1.get(6)  );
		pesos1[1].set(0,   pesos1[0].get(0) - learingRate * temporal_1.get(6)  );
		
		
		
		
	}
	private void sumAquares() {
		error=(0.5)*(Math.pow((o.get(0)-t.get(0)), 2) + Math.pow((o.get(1)-t.get(1)), 2));
		System.out.println("El error es"+String.format("%.8f",error));
		
	}
	private void HiddenLayer() {
		double suma=0;
		for(int iterador=0;iterador<2;iterador++) {
			
			for(int i=0;i<pesos1[iterador].size();i++) {
				
				suma+=pesos1[iterador].get(i)*valuesX.get(i);
			}
			
			suma=(1/( 1 + Math.pow(Math.E,(-1*suma))));
			h.set(iterador, suma);
			suma=0;
		}
		
		
	}
	public void OutputLayer() {
		double suma=0;
		for(int iterador=0;iterador<2;iterador++) {
			
			for(int i=1;i<pesos2[iterador].size();i++) {
				
				suma+=pesos2[iterador].get(i)*h.get(i-1);
			}
			suma+=pesos2[0].get(0);
			suma=(1/( 1 + Math.pow(Math.E,(-1*suma))));
			o.set(iterador, suma);
			System.out.println("El valor de o es: "+suma);
			suma=0;
		}
		
		
		
	}
	//retropropagar el error
	public void retropropagarError() {
		int k=0;
		double numero=0;
		for(int i=0;i<2;i++) {
			
			for(int j=1;j<pesos2[i].size();j++) {
				numero=( o.get(i)-t.get(i))*(o.get(i)*(1-o.get(i))*h.get(j-1));
				temporal_2.set(k, numero);
				k++;
			}
		}
		//para el bias
		numero=( o.get(0)-t.get(0))*(o.get(0)*(1-o.get(0))*1) + ( o.get(1)-t.get(1))*(o.get(1)*(1-o.get(1))*1);
		temporal_2.set(k, numero);	
	}
	private void propagarerror() {
		double numero= (o.get(0)-t.get(0))*(o.get(0)*(1-o.get(0))*pesos2[0].get(1)) + ( o.get(1)-t.get(1))*(o.get(1)*(1-o.get(1))*pesos2[1].get(1));
		h_temporal.set(0, numero);
		numero= (o.get(0)-t.get(0))*(o.get(0)*(1-o.get(0))*pesos2[0].get(2)) + ( o.get(1)-t.get(1))*(o.get(1)*(1-o.get(1))*pesos2[1].get(2));
		h_temporal.set(1, numero);
	}
	private void capaOculta() {
		// TODO Auto-generated method stub
		double suma=0;
		int k=0;
		for (int i=0;i<2;i++) {
			
			for(int j=1;j<pesos1[0].size();j++) {
				suma=h_temporal.get(i) * (h.get(i)*(1-h.get(i))) * valuesX.get(j);
				temporal_1.set(k, suma);
				k++;
				
			}
		}
		suma=(o.get(0)-t.get(0))*(o.get(0)*(1-o.get(0))*  pesos2[0].get(1)  *(h.get(0)*(1-h.get(0)))  *1 ) + ( o.get(1)-t.get(1))*(o.get(1)*(1-o.get(1))*  pesos2[1].get(2)  *(h.get(1)*(1-h.get(1)))  *1   );
		temporal_1.set(k,suma);
		
		
	}
	
	public void printH() {
		System.out.println("El valor de h1 es"+h.get(0));
		System.out.println("El valor de h2 es"+h.get(1));
		System.out.println("El valor deseado o1 es "+String.format("%.4f",o.get(0)));
		System.out.println("El valor deseado o es "+String.format("%.4f",o.get(1)));
		System.out.println("El valor del erro es "+String.format("%.8f",error));
		System.out.println("pesos actualizados "+temporal_2);
		System.out.println("valores de las h "+h_temporal);
		System.out.println("pesos capa oculta"+temporal_1);
		
		
		
	}

	
	
	
	
}
