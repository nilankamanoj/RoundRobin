import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class ProcessOut {
    //private List<JTextField[]>TextFields=new ArrayList<JTextField[]>();
    private int number=RoundRobin.record.size();
    
    
    public  ProcessOut(){
JFrame frame = new JFrame();
frame.setTitle("resul of running");

            JPanel container = new JPanel();
            container.setLayout(new GridLayout(0,5));
            container.setBackground(Color.black);

            JScrollPane scroller = new JScrollPane(container);
            scroller.setPreferredSize(new Dimension(400, 1000));
            placeComponents(container);
          //  SpringUtilities.makeGrid(container,3, 3,5, 5,5, 5);//xPad, yPad
            frame.setLayout(new BorderLayout());
            frame.add(scroller, BorderLayout.WEST);
            frame.setSize(425, 600);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setVisible(true);
}

private  void placeComponents(JPanel panel) {

/* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout 
         * to null
         */
//panel.setLayout(new BorderLayout());

// Creating JLabel



/*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.
         */
JLabel lab= new JLabel("time");
lab.setBounds(10,25,60,25);
lab.setForeground(Color.white);
panel.add(lab);
JLabel lab1= new JLabel("proces");
lab1.setBounds(80,25,60,25);
lab1.setForeground(Color.white);
panel.add(lab1);
JLabel lab2= new JLabel("event");
lab2.setBounds(150,25,60,25);
lab2.setForeground(Color.white);
panel.add(lab2);
JLabel lab3= new JLabel("run time");
lab3.setBounds(220,25,60,25);
lab3.setForeground(Color.white);
panel.add(lab3);
JLabel lab4= new JLabel("remain");
lab4.setBounds(290,25,60,25);
lab4.setForeground(Color.white);
panel.add(lab4);
for(int i=0;i<number;i++){
 JLabel labl= new JLabel(RoundRobin.record.get(i)[0]);
labl.setBounds(10,50+20*i,60,20);
labl.setForeground(Color.white);
if(RoundRobin.record.get(i)[2]=="arrival")labl.setForeground(Color.green);
if(RoundRobin.record.get(i)[2]=="finish")labl.setForeground(Color.red);
panel.add(labl);
JLabel labl1= new JLabel(RoundRobin.record.get(i)[1]);
labl1.setBounds(80,50+20*i,60,20);
labl1.setForeground(Color.white);
if(RoundRobin.record.get(i)[2]=="arrival")labl1.setForeground(Color.green);
if(RoundRobin.record.get(i)[2]=="finish")labl1.setForeground(Color.red);
panel.add(labl1);
JLabel labl2= new JLabel(RoundRobin.record.get(i)[2]);
labl2.setBounds(150,50+20*i,60,20);
labl2.setForeground(Color.white);
if(RoundRobin.record.get(i)[2]=="arrival")labl2.setForeground(Color.green);
if(RoundRobin.record.get(i)[2]=="finish")labl2.setForeground(Color.red);
panel.add(labl2);
JLabel labl3= new JLabel(RoundRobin.record.get(i)[3]);
labl3.setBounds(220,50+20*i,60,20);
labl3.setForeground(Color.white);
if(RoundRobin.record.get(i)[2]=="arrival")labl3.setForeground(Color.green);
if(RoundRobin.record.get(i)[2]=="finish")labl3.setForeground(Color.red);
panel.add(labl3);
JLabel labl4= new JLabel(RoundRobin.record.get(i)[4]);
labl4.setBounds(290,50+20*i,60,20);
labl4.setForeground(Color.white);
if(RoundRobin.record.get(i)[2]=="arrival")labl4.setForeground(Color.green);
if(RoundRobin.record.get(i)[2]=="finish")labl4.setForeground(Color.red);
panel.add(labl4);   

}
System.out.println(RoundRobin.record);
// Creating login button
JButton loginButton = new JButton("exit");
loginButton.setBounds(250, 70+20*(number), 80, 25);
panel.add(loginButton);


loginButton.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e)
        {
            
          System.exit(0);
            
        }


    }); 
}
}