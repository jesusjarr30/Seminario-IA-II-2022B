package hands_on_5;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.util.ArrayList;
import java.util.List;
public class GenericAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyGenericBehaviour());
  } 
  private class MyGenericBehaviour extends Behaviour {
    //instnciar los objetos de ayuda
    DataSet data= new DataSet();
		int max=100000;
		double learningRate=0.00001;
    Gradient gradient=new Gradient(learningRate,max);
   

    public void action() {
     
      gradient.GradientDesent(data.getX(),data.getY(),max);
		  //data.print();		
		  gradient.print();
    } 
    
    public boolean done() {
        return true;
  
    }
   
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
