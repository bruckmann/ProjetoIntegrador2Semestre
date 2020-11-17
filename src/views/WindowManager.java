package views;

import javax.swing.*;


public class WindowManager extends JFrame {
    public static final  String TITULO = "Janela Principal";

    public WindowManager(){
        super(TITULO);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showFrame(){
        setSize(640,480);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
