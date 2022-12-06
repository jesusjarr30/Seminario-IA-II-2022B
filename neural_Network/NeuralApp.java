package neural_Network;

public class NeuralApp {
	public static void main(String[] args) {
		Neurona n=new Neurona();
		//n.entrenamiento();
		n.entrenar();
		//n.printH();
		System.out.println("   --------------------      ");
		n.printPesos();
	}
	
	
	
}
