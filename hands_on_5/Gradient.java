package hands_on_5;

import java.util.ArrayList;


public class Gradient {
	private double b0;
	private double b1;
	private double error;
	private double eta;
	private int max;//iteration max
	
	//para las operaciones
	private double xi;
	private double xiyi;
	private double xi2;
	private double yi;
	
	
	Gradient(double eta,int max) {
		
		b0=Math.random();
		b1=b0;
		error=1;
		this.eta=eta;
		this.max=max;
		xi=0;
		xiyi=0;
		xi2=0;
		yi=0;
		
	}

	public void GradientDesent(ArrayList<Double>x,ArrayList<Double> y,double max) {
		HelpAritmetic h=new HelpAritmetic();
		xi=h.sum(x);
		xiyi=h.sum_XI(x, y);
		xi2=h.sum_X2(x);
		yi=h.sum(y);
		
		double errordeseado=0.01;
		double derivadaB1=0;
		double derivadaB0=0;
		int i=0;
		//lostF(x,y);
		lost(x,y);
		System.out.println("el error inicial es  "+String.format("%.5f", error));
		
		print();
		//error>0.01
		while(error>0.01) {
			
			//System.out.println("El errror es "+error+ " error deseado"+ errordeseado+"iteraciones maximas son "+i);
			i++;
			derivadaB0=derivateB0(x,y);
			derivadaB1=derivateB1(x,y);
			//muiplicar por el learning rate
			derivadaB0=MulLearnignRate(derivadaB0);//b0
			derivadaB1=MulLearnignRate(derivadaB1);//b1
			newBetas(derivadaB0,derivadaB1);
			lost(x,y);
			/*lostF(x,y);
			if(error<0) {
				error=error*-1;
			}*/
			
			//print();
		}
		System.out.println("El numero de iteraciones "+i);
		
	}
	
	private double derivateB0(ArrayList<Double>x,ArrayList<Double> y) {
		double sum=0;
		for (int i=0;i<x.size();i++) {
			sum+=  -2 * ( y.get(i) - ( b0 + b1 * x.get(i) ) );
		}
		return sum;
	}
	private double derivateB1(ArrayList<Double>x,ArrayList<Double> y) {
		double sum=0;
		for (int i=0;i<x.size();i++) {
			sum+=  -2 * x.get(i) * ( y.get(i) - ( b0 + b1 * x.get(i) ) );
		}
		return sum;
	}
	/*
	private double derivateB0_2(ArrayList<Double>x,ArrayList<Double> y) {
		double sum=0;
		sum= y.size() * b0 +b1 * xi - yi;
		
		return sum;
	}
	private double derivateB1_2(ArrayList<Double>x,ArrayList<Double> y) {
		double sum=0;
		sum= b0 * xi +b1 * xi2 - xiyi; 
		return sum;
	}*/
	
	
	private double MulLearnignRate(double slope) {
		return slope * eta;
	}
	private void newBetas(double primera,double segunda) {
		b0=b0-primera;
		b1=b1-segunda;
		
	}
	
	public void print() {
		System.out.println("Los valores para b1 es "+String.format("%.5f", b1));
		System.out.println("Los valores para b0 son "+String.format("%.5f", b0));
		System.out.println("EL error es "+String.format("%.5f", error));
	
	}
	private void lost(ArrayList<Double>x, ArrayList<Double> y) {
		double residual=0;
		double predicted=0;
		double cero=0;
		
		for(int i=0;i<x.size();i++) {
			
			predicted=b0+b1*x.get(i);
			predicted=y.get(i)-predicted;
			//predicted=Math.pow(predicted, 2);
			residual+=predicted;
			//System.out.println("Diferencia "+i+" con valor de x es "+x.get(i)+" y: "+y.get(i)+"   es: "+String.format("%.5f", predicted));
		}
		if( 0 >= residual) {
			residual =residual * -1;
			
		}
		this.error=residual;
	}
	private void lostF(ArrayList<Double> x,ArrayList<Double> y) {
		double suma=0;
		double predicted=0;
		for (int i=0;i<x.size();i++) {
			predicted=b0+b1*x.get(i);
			suma+=Math.pow((y.get(i)-predicted), 2);
		}
		suma=(1.0/y.size())*suma;
		this.error=suma;
		
	}
	

}
