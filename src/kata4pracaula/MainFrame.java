
package kata4pracaula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    
    public MainFrame() throws HeadlessException {
        this.setTitle("Hello World");
        this.setSize(500, 300);
        centerOnScreen();
        
        //this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.add(createButton(), BorderLayout.NORTH);
        this.setLayout(new GridLayout(2,2));
        this.add(createPanel(), BorderLayout.NORTH);
        this.setVisible(true);
        
    }
    
    private void centerOnScreen(){
        this.setLocation(getCenterPoint());
    }

    private Point getCenterPoint() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        return new Point(
                ((int)(screenSize.getWidth() - this.getWidth() / 2)),
                ((int)(screenSize.getHeight() - this.getHeight()/2)));
    }
    
    private JButton createButton(){
        JButton button = new JButton("Click");
        // ActionListener es una clase anonima para que el button invoque una clase propia
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        return button;
    }
    
    private void refresh(){
        this.setTitle("Bye bye world");
    }
    
    private JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.add(createButton());
        panel.setBackground(Color.red);
        return panel;
    }
    
}
