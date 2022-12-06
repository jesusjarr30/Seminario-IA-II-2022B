package hands_on_4;

import java.util.ArrayList;

public class HelpAritmetic {
	//for math operation

	HelpAritmetic(){
		
	}
	public double sum(ArrayList<Double> list) {
		double suma=0;
		for(int i=0;i<list.size();i++) {
			suma+=list.get(i);
			
		}
		return suma;
	}
	public double sum_XI(ArrayList<Double> x,ArrayList<Double> y) {
		double suma= 0;
		for(int i=0;i<x.size();i++) {
			suma+=(x.get(i)*y.get(i));
		}
		
		
		
		return suma;
	}
	public double sum_X2(ArrayList<Double> x) {
		double suma=0;
		for(int i=0;i<x.size();i++) {
			suma+=(x.get(i)*x.get(i));
		}
		return suma;
		
	}
	
	

}
