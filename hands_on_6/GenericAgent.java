package hands_on_6;

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
    LogisticRegression lr=new LogisticRegression();
   

    public void action() {
     
      lr.start();
      System.out.println("Evaluation with 3.5 Hall of Famers and 4 All-Stars");
      
      double resultado=lr.evaluacion(0.0,0.0);
      System.out.println("el resultado es "+resultado);
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
