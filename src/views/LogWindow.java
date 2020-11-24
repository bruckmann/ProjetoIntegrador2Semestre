package views;

import Entities.user.User;
import Util.ViewHelper;
import Repositories.user.AdminRepository;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LogWindow extends StandardFormatLog {
  private final WindowManager frame;
  private final AdminRepository admRepo = new AdminRepository();

  private final String title = WindowManager.TITULO;
  private final int infoMessage = JOptionPane.INFORMATION_MESSAGE;
  private final LogWindow thisFrame = LogWindow.this;

  public LogWindow (WindowManager windowManager){

    this.frame = windowManager;

    init();
  }

  private void init(){

    JLabel label;
    JTextField name;
    JPasswordField password;
    JButton button;

    label = new JLabel("OLÁ FAÇA SEU LOGIN");
    label.setForeground(Color.BLACK);
    addComponent(label, 0, 0,5,2);

    label = new JLabel("NOME: ");
    addComponent(label,2,0,1,1);
    name = new JTextField(20);
    name.setName("nome");
    addComponent(name, 2,1,3,1);

    label = new JLabel("SENHA: ");
    addComponent(label, 3,0,1,1);
    password = new JPasswordField(20);
    password.setName("senha");
    addComponent(password, 3,1,3,1);

    label = new JLabel("CRIAR CONTA: ");
    addComponent(label, 5,0,1,1);

    button = new JButton("ADMINISTRADOR");
    button.addActionListener(e -> frame.showLogAdm());
    button.setForeground(Color.BLUE);
    addComponent(button, 5,1,3,1);

        /*JButton button2 = new JButton("JOGADOR");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLogPlayer();
            }
        });
        button2.setForeground(Color.RED);
        addComponent(button2, 5,2,1,1); */

    label = new JLabel(" ");
    addComponent(label, 6,0,1,1);

    JButton buttonLog = new JButton("LOGAR");
    buttonLog.addActionListener(e -> {
      List<JTextField> emptyFields;
      List<JTextField> aJTextList = new ArrayList<>();
      aJTextList.add(name);

      emptyFields = ViewHelper.validateFields(aJTextList);
      boolean isPssValid = password.getPassword().length > 0;

      if(emptyFields.isEmpty()  && isPssValid) {
        List<User> admins;
        admins = admRepo.getUsers();

        for(User adminList : admins) {
          if(String.valueOf(name.getText()).equals(adminList.getName())
                  && String.valueOf(password.getPassword()).equals(adminList.getPassword()))
          {
            frame.ManageQuestionTable();
            return;
          }
        }

        JOptionPane.showMessageDialog(thisFrame, "Usuário ou senha inválido", title, infoMessage);
      } else {
        for(JTextField field : emptyFields) {
          String message = "O campo " + field.getName() + " não está preenchido\n";
          JOptionPane.showMessageDialog(thisFrame, message, title, infoMessage);
        }

        if(!isPssValid) {
          String message = "O campo " + password.getName() + " não está preenchido\n";
          JOptionPane.showMessageDialog(thisFrame, message, title, infoMessage);
        }
      }
    });

    buttonLog.setForeground(Color.MAGENTA);
    addComponent(buttonLog,7,1,3,1);
  }
}
