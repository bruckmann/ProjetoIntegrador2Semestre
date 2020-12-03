package views;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import java.awt.*;

public class StandardFormatLog extends JPanel {
  public GridBagConstraints constraints;
  public BorderLayout layout;
  public GridBagLayout secondLayout;
  public JPanel panelLayout;
  public static final Insets FIELD_INSETS = new Insets(7,0,0,0);

  public StandardFormatLog() {

    layout = new BorderLayout();
    setLayout(layout);

    constraints = new GridBagConstraints();
    secondLayout = new GridBagLayout();

    panelLayout = new JPanel();
    panelLayout.setBackground(Color.decode("#5CDB95"));
    panelLayout.setLayout(secondLayout);

    Font font = new Font("AmericanTypewriter", Font.BOLD, 14);
    UIManager.put("Label.font", font);
    UIManager.put("Button.font",font);
    UIManager.put("RadioButton.font",font);

  }

  public void addComponent(JComponent comp, int row, int col, int width, int height) {
    constraints.gridx = col;
    constraints.gridy = row;
    constraints.gridwidth = width;
    constraints.gridheight = height;

    constraints.insets = FIELD_INSETS;
    constraints.fill = GridBagConstraints.BOTH;

    secondLayout.setConstraints(comp, constraints);
    add(comp);
  }
}
