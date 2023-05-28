import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    private JFrame main;
    private JButton clicker;
    private JLabel image;
    private JLabel background;
    private JLabel count_display;
    private int count;


    public Gui() {

        //count
        this.count = 0;

        //creating main frame
        this.main = new JFrame("Tasbeeh Counter");
        this.main.setSize(1000,1000);
        this.main.setLayout(null);
        this.main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.main.setResizable(false);

        //creating button
        this.clicker = new JButton("Click Here.");
        this.clicker.setBounds(300,650,400,200);
        this.clicker.setBackground(Color.PINK);
        this.clicker.addActionListener(this);

        //creating subhanallah image
        java.net.URL imageUrl = Main.class.getResource("sub.png");
        this.image = new JLabel(new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(480,240,Image.SCALE_DEFAULT)));
        this.image.setBounds(260,150,480,240);

        //changing background of GUI
        java.net.URL imageUrl2 = Main.class.getResource("background.jpg");
        this.background = new JLabel(new ImageIcon(new ImageIcon(imageUrl2).getImage().getScaledInstance(1000,1000,Image.SCALE_DEFAULT)));
        this.background.setBounds(0,0,1000,1000);

        //creating counter display
        this.count_display = dynamicCountDisplay(this.count);
        this.count_display = new JLabel(Integer.toString(this.count));
        this.count_display.setBounds(430,240,500,500);
        this.count_display.setFont(new Font("Serif", Font.BOLD, 70));

        //adding everything to main frame

        this.addAll();
    }
    public void addAll() {
        this.main.add(this.count_display);
        this.main.add(this.image);
        this.main.add(this.clicker);
        this.main.add(this.background);
    }
    public void addAllNewCount(JLabel button){
        this.main.add(button);
        this.main.add(this.image);
        this.main.add(this.clicker);
        this.main.add(this.background);
    }
    public void wipeout(){
        this.main.getContentPane().removeAll();
    }

    public void run(){
        this.main.setVisible(true);
    }

    public static JLabel dynamicCountDisplay(int number) {
        JLabel r_value;
        r_value = new JLabel(Integer.toString(number));
        r_value.setBounds(430,240,500,500);
        r_value.setFont(new Font("Serif", Font.BOLD, 70));
        return r_value;
    }

    public void updateCountDisplay() {
        this.main.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.count++;
        JLabel update = dynamicCountDisplay(this.count);
        System.out.println(this.count);
        this.wipeout();
        this.addAllNewCount(update);
        updateCountDisplay();
    }
}