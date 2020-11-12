package views;
import javax.swing.*;
import java.awt.*;

public class WindowPatternFrame extends JFrame {
    private GridBagConstraints constraints;
    private  GridBagLayout layout;
    private static final Insets FIELD_INSETS = new Insets(7,0,0,0);

    public WindowPatternFrame(){
        this("Demo WindowPatternFrame");
    }

    public WindowPatternFrame(String title) {
        super(title);
        this.setSize(640,480);
        this.setResizable(false);

        layout = new GridBagLayout();
        setLayout(layout);

        constraints = new GridBagConstraints();


    }

    public void addComponet(JComponent comp, int row, int col, int width, int height) {
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        constraints.insets = FIELD_INSETS;
        constraints.fill = GridBagConstraints.BOTH;

        layout.setConstraints(comp, constraints);
        add(comp);
    }
}
