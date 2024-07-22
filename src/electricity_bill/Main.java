package electricity_bill;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main(){
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Icon/Splash.jpg"));
        Image img2 = img.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel imgL=new JLabel(img3);

        add(imgL);
        setSize(600,400);
        setLocation(400,200);
        setVisible(true);
        try {
            Thread.sleep(3000);
            setVisible(false);

            new Login();
        }catch (Exception ez){
            ez.printStackTrace();
        }

    }
    public static void main(String[] args) {
    new Main();

    }
}