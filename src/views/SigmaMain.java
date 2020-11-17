package views;
import javax.swing.*;

public class SigmaMain {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                viewWindow();
            }
        });
    }
        //JFrame frame = null;

        //frame = new WindowPatternFrame();
        //frame = new LogWindow();
        //frame = new RegisterAdm();
        //frame = new CreateQuestionFrame();


        private static void viewWindow() {
            WindowManager frame = new WindowManager();

            frame.showFrame();
        }

        //felipe estranho
       // frame.setVisible(true);
    }
