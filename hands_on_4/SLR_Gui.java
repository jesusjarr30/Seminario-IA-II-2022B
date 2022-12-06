package hands_on_4;

import jade.core.AID;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
  @author Giovanni Caire - TILAB
 */
class SLR_Gui extends JFrame {	
	private GenericAgent myAgent;
	
	private JTextField number;
	
	SLR_Gui(GenericAgent a) {
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("Enter number:"));
		number = new JTextField(15);
		p.add(number);
		//p.add(new JLabel("Price:"));
		//priceField = new JTextField(15);
		//p.add(priceField);
		getContentPane().add(p, BorderLayout.CENTER);
		
		JButton addButton = new JButton("Predict");
		addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
					String numero = number.getText().trim();
					//String price = priceField.getText().trim();
					myAgent.predecirSLR(Double.parseDouble(numero));
					number.setText("");
					//priceField.setText("");
				
			}
		} );
		p = new JPanel();
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);
		
		// Make the agent terminate when the user closes 
		// the GUI using the button on the upper right corner	
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		} );
		
		setResizable(false);
	}
	
	public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}	
}
