package A3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OrderBookDriver 
{
	public static void main(String[] args) 
	{	
		OrderBook book = new OrderBook();
		
		book.add(new OrderOffer("Jane1", 1.1, 10));
		book.add(new OrderOffer("Jane2", 1.12, 10));
		book.add(new OrderOffer("Jane3", 1.15, 10));
		book.add(new OrderOffer("Jane4", 1.13, 10));
		book.add(new OrderOffer("Jane5", 1.01, 10));
		book.add(new BidOrder("John1", 0.99, 100));
		book.add(new BidOrder("John2", 0.90, 100));
		book.add(new BidOrder("John3", 0.95, 100));
		book.add(new BidOrder("John4", 0.97, 100));
		book.add(new BidOrder("John5", 1.00, 100));

		book.printFullDetails();
		
		System.out.print("Launching GUI... Part 2");
		
		OrderBook bookGUI = new OrderBook();
		JFrame frame = new JFrame("Order Market Entry System");
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField jtfInputPrice = new JTextField("Enter Price here...");
		jtfInputPrice.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	jtfInputPrice.setText("");
            }
        });
		JTextField jtfInputVolume = new JTextField("Enter Volume here...");
		jtfInputVolume.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	jtfInputVolume.setText("");
            }
        });
		JTextField jtfInputName = new JTextField("Enter Name here...");
		jtfInputName.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	jtfInputName.setText("");
            }
        });
		
		JLabel lblTOShow = new JLabel("Last Order added: ");
		
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton jbtnSubmit = new JButton("Submit");
		jbtnSubmit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				Object[] options = {"Order Offer",
                "Bid Order!"};
				int n = JOptionPane.showOptionDialog(frame,
				"is this an offer or a bid?",
				"Option Seletion",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
				double price = 0.0;
				int volume = 0;
				try
				{
					String temp = jtfInputPrice.getText();
					price = Double.parseDouble(temp);
					temp = jtfInputVolume.getText();
					volume = Integer.parseInt(temp);
				}
				catch(NumberFormatException e)
				{
					lblTOShow.setText("ERROR: Enter a correct price/volume volume.");
					return;
				}
				String name = jtfInputName.getText();
				
				Order newOrder = null;
				if(n == 0)
				{
					newOrder = new OrderOffer(name, price, volume);
					
				}
				else if (n == 1)
				{
					newOrder = new BidOrder(name, price, volume);
				}
				bookGUI.add(newOrder);
				
				jtfInputPrice.setText("Enter Price here...");
				jtfInputVolume.setText("Enter Volume here...");
				jtfInputName.setText("Enter Name here...");
				
				lblTOShow.setText("Last Order added: " + newOrder);
			}
        });
		JButton jbtnReset = new JButton("Reset");
		jbtnReset.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent event) {
				jtfInputPrice.setText("Enter Price here...");
				jtfInputVolume.setText("Enter Volume here...");
				jtfInputName.setText("Enter Name here...");
			}
				});
		p1.add(jbtnSubmit);
		p1.add(jbtnReset);
		
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p3.add(lblTOShow);
		
		JPanel p2 = new JPanel(new BorderLayout());
		p2.setBorder(new EmptyBorder(5,5,5,5));
		p2.add(p1, BorderLayout.NORTH);
		p2.add(p3, BorderLayout.SOUTH);
	
		JPanel p4 = new JPanel(new BorderLayout());
		p4.setBorder(new EmptyBorder(3,3,3,3));
		p4.add(jtfInputPrice, BorderLayout.NORTH);
		p4.add(jtfInputVolume, BorderLayout.CENTER);
		p4.add(jtfInputName, BorderLayout.SOUTH);
		
		frame.add(p4, BorderLayout.NORTH);
		frame.add(p2, BorderLayout.SOUTH);
		frame.setVisible(true);

	}
}
