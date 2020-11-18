package views;

import javax.swing.*;
import java.awt.*;


public class WindowManager extends JFrame {
    public static final  String TITULO = "SIGMA";

    private CardLayout layout;
    private JPanel cardsPanel;

    private LogWindow logWindow;
    private RegisterPlayer registerPlayer;
    private RegisterAdm registerAdm;
    private CreateQuestionFrame createQuestionFrame;

    public WindowManager(){
        super(TITULO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();
        cardsPanel = new JPanel();
        cardsPanel.setLayout(layout);
        add(cardsPanel);

        createCards();
    }

    public void showFrame(){
        setSize(640,480);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void showLogAdm(){
        layout.show(cardsPanel,RegisterAdm.class.getName());
    }

    public void showLogPlayer(){
        layout.show(cardsPanel,RegisterPlayer.class.getName());
    }

    public void ReturnToLogPage(){

        layout.show(cardsPanel,LogWindow.class.getName());
    }

    private void createCards(){
        logWindow = new LogWindow(this);
        cardsPanel.add(logWindow, LogWindow.class.getName());

        registerPlayer = new RegisterPlayer(this);
        cardsPanel.add(registerPlayer, RegisterPlayer.class.getName());

        registerAdm = new RegisterAdm(this);
        cardsPanel.add(registerAdm, RegisterAdm.class.getName());

        createQuestionFrame = new CreateQuestionFrame();
        cardsPanel.add(createQuestionFrame,CreateQuestionFrame.class.getName());

    }
}
