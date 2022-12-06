package hands_on_4;

import java.util.ArrayList;

public class SLR {
	
	private double b0;
	private double b1;
	
	SLR() {
		b0=0.0;
		b1=0.0;
	}
	public void calculate_B0(ArrayList<Double> x, ArrayList<Double> y) {
		HelpAritmetic help_A=new HelpAritmetic();
		b0= ( help_A.sum(y) -b1*help_A.sum(x) )/x.size();
		
	}
	public void calculate_B1(ArrayList<Double> x, ArrayList<Double> y) {
		HelpAritmetic help_A=new HelpAritmetic();
		b1= ( help_A.sum(x)* help_A.sum(y) - x.size()*help_A.sum_XI(x, y))
				/( help_A.sum(x)* help_A.sum(x) -x.size() *help_A.sum_X2(x));
		
	}
	
	public void calculateY() {
		
		
		
	}
	public void print() {
		System.out.println("El valor de B1 es "+String.format("%.4f",b1));
		System.out.println("El valor de B es 0 "+String.format("%.4f",b0));
	}
	public double predict(double x) {
		return (b0+b1*x);
	}

}
