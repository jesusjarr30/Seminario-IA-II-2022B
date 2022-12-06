package hands_on_4;

import java.util.ArrayList;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.util.Scanner;


import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import java.util.*;


public class GenericAgent extends Agent {

  private SLR_Gui myGui;
  private double dato;

  protected void setup() {

    // Create and show the GUI 
		myGui = new SLR_Gui(this);
		myGui.showGui();
    dato=0;
		// Register the book-selling service in the yellow pages
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType("HandsON4");
		sd.setName("JADE-SLR");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		}
		catch (FIPAException fe) {
			fe.printStackTrace();
		}
    
  } 
  protected void takeDown() {
      // Deregister from the yellow pages
      try {
        DFService.deregister(this);
      }
      catch (FIPAException fe) {
        fe.printStackTrace();
      }
      // Close the GUI
      myGui.dispose();
      // Printout a dismissal message
      System.out.println("Seller-agent "+getAID().getName()+" terminating.");
	}
  public void predecirSLR(double numero ) {
    dato=numero;
		addBehaviour(new MyGenericBehaviour());
	}

  private class MyGenericBehaviour extends Behaviour {

    int cont=0;
    DataSet d;
    SLR slr;
    Scanner sc;
    //double dato;

    public void action() {
        //dato=0;
        System.out.println("Agent's action method is executed");
        d=new DataSet();
        slr=new SLR();
        sc =new Scanner(System.in);
        

        slr.calculate_B1(d.getX(), d.getY());
		    slr.calculate_B0(d.getX(), d.getY());
        System.out.println("Escriba un valor de x para calcular un valor de y");
		    //dato=Double.parseDouble(sc.nextLine());
        System.out.println("El dato antes de entrar es "+dato);
        slr.print();
        dato=slr.predict(dato);
        System.out.println("El resultado es "+dato);

        cont+=1;
    } 
    
    public boolean done() {
      if (cont == 1)
        return true;
      else
	return false;
    }
   
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}