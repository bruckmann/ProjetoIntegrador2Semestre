package views;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import java.awt.*;

public class StandardFormatLog extends JPanel {
  public GridBagConstraints constraints;
  public GridBagLayout layout;
  public static final Insets FIELD_INSETS = new Insets(7,0,0,0);

  public StandardFormatLog() {


    layout = new GridBagLayout();
    setLayout(layout);

    constraints = new GridBagConstraints();
    setBackground(Color.decode("#5CDB95"));


  }

  public void addComponent(JComponent comp, int row, int col, int width, int height) {
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
