package views;
import javax.swing.*;
import java.awt.*;

public class StandartFormatLog extends JFrame {
    public GridBagConstraints constraints;
    public GridBagLayout layout;
    public static final Insets FIELD_INSETS = new Insets(7,0,0,0);

    public StandartFormatLog(String title) {
        super(title);
        this.setSize(640,480);
        this.setResizable(false);

        layout = new GridBagLayout();
        setLayout(layout);

        constraints = new GridBagConstraints();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

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
