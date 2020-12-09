package views;

import Entities.user.LoggedUser;
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
    JLabel labelEmail;
    JLabel labelPassword;
    JLabel labelCreateAccount;
    JTextField email;
    JPasswordField password;
    JButton button;
    JPanel panelHeader;

    panelHeader = new JPanel();
    panelHeader.setBackground(Color.decode("#8EE4AF"));

    JLabel header = new JLabel("OLÁ FAÇA SEU LOGIN");
    addComponent(header,0,1,1,1);
    header.setForeground(Color.BLACK);
    panelHeader.add(header);
    add(panelHeader,BorderLayout.NORTH);


    labelEmail = new JLabel("EMAIL: ");
    email = new JTextField(20);
    email.setName("email");
    addComponent(labelEmail,1,1,1,1);
    addComponent(email, 2,1,3,1);
    panelLayout.add(labelEmail);
    panelLayout.add(email);

    labelPassword = new JLabel("SENHA: ");
    password = new JPasswordField(20);
    password.setName("senha");
    addComponent(labelPassword, 3,1,1,1);
    addComponent(password, 4,1,3,1);
    panelLayout.add(labelPassword);
    panelLayout.add(password);

    labelCreateAccount = new JLabel("CRIAR CONTA: ");
    addComponent(labelCreateAccount, 6,1,1,1);
    panelLayout.add(labelCreateAccount);

    button = new JButton("ADMINISTRADOR");
    button.addActionListener(e -> frame.showLogAdm());
    button.setForeground(Color.decode("#EEDDFF"));
    button.setBackground(Color.decode("#379683"));
    addComponent(button, 7,1,3,1);
    panelLayout.add(button);

        /*JButton button2 = new JButton("JOGADOR");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLogPlayer();
            }
        });
        button2.setForeground(Color.RED);
        addComponent(button2, 5,2,1,1); */


    JButton buttonLog = new JButton("LOGAR");
    buttonLog.setForeground(Color.decode("#EEDDFF"));
    buttonLog.setBackground(Color.decode("#379683"));


    buttonLog.addActionListener(e -> {
      List<JTextField> emptyFields;
      List<JTextField> aJTextList = new ArrayList<>();
      aJTextList.add(email);

      emptyFields = ViewHelper.validateFields(aJTextList);
      boolean isPssValid = password.getPassword().length > 0;

      if(emptyFields.isEmpty()  && isPssValid) {
        List<User> admins;
        admins = admRepo.getUserByEmail(String.valueOf(email.getText()));

        for(User adminList : admins) {
          if(String.valueOf(email.getText()).equals(adminList.getEmail())
                  && String.valueOf(password.getPassword()).equals(adminList.getPassword()))
          {
            LoggedUser.user = adminList;
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
    addComponent(buttonLog,5,1,3,1);
    panelLayout.add(buttonLog);
    add(panelLayout,BorderLayout.CENTER);
  }
}
