package views;

import Util.ViewHelper;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;


public class RegisterPlayer extends StandardFormatLog {
  private final WindowManager frame;

  public RegisterPlayer(WindowManager windowManager){

    this.frame = windowManager;

    init();
  }

  private void init(){
    JLabel label;
    JPanel panel;

    label = new JLabel("OLÁ INSIRA SEUS DADOS: ");
    addComponent(label, 0, 0,5,2);

    label = new JLabel("NOME: ");
    addComponent(label,2,0,1,1);
    JTextField name = new JTextField(20);
    name.setName("nome");
    addComponent(name,2,1,3,1);

    label = new JLabel("SENHA: ");
    addComponent(label, 3,0,1,1);
    JPasswordField password = new JPasswordField();
    password.setName("Senha");
    addComponent(password, 3,1,3,1);

    label = new JLabel("IDADE: ");
    addComponent(label, 4,0,1,1);
    JTextField yearsOld = new NumberMask(3);
    yearsOld.setName("Idade");
    addComponent(yearsOld,4,1,3,1);

    label = new JLabel("SERIE: ");
    addComponent(label, 6,0,1,1);
    JTextField grade = new NumberMask(1);
    grade.setName("Série");
    addComponent(grade,6,1,3,1);

    label = new JLabel("TDAH: ");
    addComponent(label, 7,0,1,1);
    panel = new JPanel();
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton jRadioButton = new JRadioButton("SIM");
    jRadioButton.setName("Tdah");
    buttonGroup.add(jRadioButton);
    JRadioButton jRadioButton2 = new JRadioButton("NÃO");
    buttonGroup.add(jRadioButton2);
    panel.add(jRadioButton);
    panel.add(jRadioButton2);
    addComponent(panel,7,1,1,1);

    JButton button = new JButton("CRIAR CONTA");
    button.addActionListener(e -> {
      List<JTextField> emptyFields;
      boolean isButtonSelected;
      List<JTextField> aJTextList = new ArrayList<>();
      aJTextList.add(name);
      aJTextList.add(yearsOld);
      aJTextList.add(grade);

      emptyFields = ViewHelper.validateFields(aJTextList);
      boolean isPssValid = password.getPassword().length > 0;
      isButtonSelected = (jRadioButton.isSelected()) || (jRadioButton2.isSelected());

      if(emptyFields.isEmpty() && isButtonSelected && isPssValid) {
        JOptionPane.showMessageDialog(RegisterPlayer.this,
                "Criação de conta concluída !!",
                WindowManager.TITULO,
                JOptionPane.INFORMATION_MESSAGE);
        frame.ReturnToLogPage();
      } else {
        for(JTextField field : emptyFields) {
          JOptionPane.showMessageDialog(RegisterPlayer.this,
                  "O campo " + field.getName() + " não está preenchido\n",
                  WindowManager.TITULO,
                  JOptionPane.INFORMATION_MESSAGE);
        }
        if(!isButtonSelected) {
          JOptionPane.showMessageDialog(RegisterPlayer.this,
                  "O botão " + jRadioButton.getName() + " não está selecionado\n",
                  WindowManager.TITULO,
                  JOptionPane.INFORMATION_MESSAGE);
        }
        if(!isPssValid) {
          JOptionPane.showMessageDialog(RegisterPlayer.this,
                  "O campo " + password.getName() + " não está preenchido\n",
                  WindowManager.TITULO,
                  JOptionPane.INFORMATION_MESSAGE);

        }
      }
    });
    button.setForeground(Color.BLUE);
    addComponent(button, 10,1,1,1);
  }
}

