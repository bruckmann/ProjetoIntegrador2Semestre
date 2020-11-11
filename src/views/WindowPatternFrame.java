package views;
import javax.swing.JFrame;

public class WindowPatternFrame extends JFrame {

    public WindowPatternFrame(){
        this("Demo WindowPatternFrame");
    }

    public WindowPatternFrame(String title) {
        super(title);
        this.setSize(640,480);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
