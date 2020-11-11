package views;

import javax.swing.*;
import java.awt.*;

public class LogWindow extends WindowPatternFrame{
    private static final Insets FIELD_INSETS = new Insets(7,5,0,0);
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    public LogWindow (){
        super("JANELA DE LOGUIM");

        layout = new GridBagLayout();
        setLayout(layout);

        constraints = new GridBagConstraints();

        init();
    }

    private void init(){
        JLabel label;
        JSeparator separator;

        /*label = new JLabel("CABEÇALHO");
        label.setForeground(Color.BLACK);
        addComponet(label, 0, 0,1,1);

        */

        label = new JLabel("NOME: ");
        addComponet(label,1,0,1,1);
        JTextField textField = new JTextField(20);
        addComponet(textField, 1,1,3,1);

        label = new JLabel("SENHA: ");
        addComponet(label, 2,0,1,1);
        JPasswordField passwordField = new JPasswordField(20);
        addComponet(passwordField, 2,1,3,1);

        separator = new JSeparator();
        addComponet(separator, 4 ,1,3,1);

        label = new JLabel("CRIAR CONTA: ");
        addComponet(label, 5,0,1,1);

        JButton button = new JButton("ADMINISTRADOR");
        button.setForeground(Color.BLUE);
        addComponet(button, 5,1,1,1);

        separator = new JSeparator();
        addComponet(separator, 5 ,2,2,1);

        JButton button2 = new JButton("JOGADOR");
        button2.setForeground(Color.RED);
        addComponet(button2, 5,3,1,1);
    }

    private void addComponet(JComponent comp, int row, int col, int width, int height){
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;

        constraints.insets = FIELD_INSETS;
        //contraints.fill = GridBagContraints.BOTH; ( expandir componente )

        layout.setConstraints(comp, constraints);
        add(comp);
    }
}
