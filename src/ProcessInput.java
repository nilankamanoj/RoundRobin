import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 
public class ProcessInput {
    private List<JTextField[]>TextFields=new ArrayList<JTextField[]>();
    private int number,tq;
    public  ProcessInput(int number,int tq){
        this.number=number;
        this.tq=tq;
            // Creating instance of JFrame
            JFrame frame = new JFrame("Input Process here");
// Setting the width and height of frame
frame.setSize(450,130+50*number);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific 
         * positions in a JFrame. Inside panels we can add text 
         * fields, buttons and other components.
         */
JPanel panel = new JPanel();
// adding panel to frame
frame.add(panel);
/* calling user defined method for adding components
         * to the panel.
         */
placeComponents(panel);

// Setting the frame visibility to true
frame.setVisible(true);
}

private  void placeComponents(JPanel panel) {

/* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout 
         * to null
         */
panel.setLayout(null);

// Creating JLabel



/*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.
         */
JLabel lab= new JLabel("process");
lab.setBounds(10,25,80,25);
panel.add(lab);
JLabel lab1= new JLabel("name");
lab1.setBounds(100,25,80,25);
panel.add(lab1);
JLabel lab2= new JLabel("arrival time");
lab2.setBounds(240,25,80,25);
panel.add(lab2);
JLabel lab3= new JLabel("burst time");
lab3.setBounds(310,25,80,25);
panel.add(lab3);
for(int i=0;i<number;i++){
JLabel processnum = new JLabel((i+1)+"");
processnum.setBounds(10,50+50*i,80,25);
panel.add(processnum);

/*This is similar to text field but it hides the user
         * entered data and displays dots instead to protect
         * the password like we normally see on login screens.

         */
JTextField[] txtfld = new JTextField[3];
JTextField nameText = new JTextField(20);
nameText.setBounds(100,50+50*i,120,25);
panel.add(nameText);
txtfld[0]=nameText;

JTextField arrivalText = new JTextField(20);
arrivalText.setBounds(240,50+50*i,50,25);
panel.add(arrivalText);
txtfld[1]=arrivalText;

JTextField burstText = new JTextField(20);
burstText.setBounds(310,50+50*i,50,25);
panel.add(burstText);
txtfld[2]=burstText;

TextFields.add(txtfld);

}

// Creating login button
JButton loginButton = new JButton("run");
loginButton.setBounds(10, 50+50*(number), 80, 25);
panel.add(loginButton);


loginButton.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e)
        {
            for (int i = 0 ; i < number ; i++)
            {
                System.out.println(TextFields.get(i)[0].getText()+","+TextFields.get(i)[1].getText()+","+TextFields.get(i)[2].getText());
                new Process(parseInt(TextFields.get(i)[1].getText()),parseInt(TextFields.get(i)[2].getText()),TextFields.get(i)[0].getText());
            }
            	RoundRobin rr=new RoundRobin(tq,Process.processes);
                
        try {
            rr.RunShedular();
            ProcessOut pp=new ProcessOut();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ui1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }


    }); 
}
}