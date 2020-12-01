package views;

import Entities.user.Admin;
import Entities.user.User;
import Repositories.user.AdminRepository;
import Util.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class RegisterAdm extends StandardFormatLog {
  private final WindowManager frame;
  private final AdminRepository admRepo;

  private JTextField name;
  private JPasswordField password;
  private JTextField yearsOld;
  private JTextField email;

  private final String title = WindowManager.TITULO;
  private final int infoMessage = JOptionPane.INFORMATION_MESSAGE;
  private final RegisterAdm thisFrame = RegisterAdm.this;

  public RegisterAdm(WindowManager windowManager){
    admRepo = new AdminRepository();
    this.frame = windowManager;

    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentShown(ComponentEvent e) {
        name.setText("");
        password.setText("");
        yearsOld.setText("");
        email.setText("");
      }
    });

    init();
  }

  private void init(){
    JLabel label;
    JLabel header;

    header = new JLabel("OLÁ INSIRA SEUS DADOS: ");
    addComponent(header, 0, 1,5,2);

    label = new JLabel("NOME: ");
    addComponent(label,2,1,1,1);
    name = new JTextField(20);
    name.setName("Nome");
    addComponent(name,3,1,3,1);

    label = new JLabel("SENHA: ");
    addComponent(label, 4,1,1,1);
    password = new JPasswordField(10);
    password.setName("Senha");
    addComponent(password, 5,1,3,1);

    label = new JLabel("IDADE: ");
    addComponent(label, 6,1,1,1);
    yearsOld = new NumberMask(3);
    yearsOld.setName("Idade");
    addComponent(yearsOld,7,1,3,1);

    label = new JLabel("EMAIL: ");
    addComponent(label, 8,1,1,1);
    email = new JTextField(20);
    email.setName("Email");
    addComponent(email,9,1,3,1);

    JButton button = new JButton("CRIAR CONTA");
    button.addActionListener(new ActionListener() {
      Integer id = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
        java.util.List<JTextField> emptyFields;
        List<JTextField> aJTextList = new ArrayList<>();
        aJTextList.add(name);
        aJTextList.add(yearsOld);
        aJTextList.add(email);

        emptyFields = ViewHelper.validateFields(aJTextList);
        boolean isPssValid = password.getPassword().length > 0;

        if(emptyFields.isEmpty() && isPssValid) {
          id++;
          User admin = new Admin(id, name.getText(), String.valueOf(password.getPassword()),
                  Integer.parseInt(yearsOld.getText()), email.getText());

          List<User> admins;
          admins = admRepo.getUsers();

          for(User adminList : admins) {
            if(adminList.getEmail().equals(email.getText())) {
              JOptionPane.showMessageDialog(thisFrame,"Esse email já está cadastrado!", title, infoMessage);
              return;
            }
          }
          admRepo.saveUser(admin);

          JOptionPane.showMessageDialog(thisFrame,"Criação de conta concluída !!", title, infoMessage);
          frame.ReturnToLogPage();
          } else {
          for (JTextField field : emptyFields) {
            String message = "O campo " + field.getName() + " não está preenchido\n";
            JOptionPane.showMessageDialog(thisFrame, message, title, infoMessage);
          }

          if (!isPssValid) {
            String message = "O campo " + password.getName() + " não está preenchido\n";
            JOptionPane.showMessageDialog(thisFrame, message, title, infoMessage);
          }
        }
      }
    });
    button.setForeground(Color.decode("#EEDDFF"));
    button.setBackground(Color.decode("#379683"));
    addComponent(button, 10,1,3,1);

    JButton buttonCancel = new JButton("Cancelar");
    buttonCancel.addActionListener(e -> frame.ReturnToLogPage());
    buttonCancel.setForeground(Color.decode("#EEDDFF"));
    buttonCancel.setBackground(Color.decode("#379683"));
    addComponent(buttonCancel,11,1,3,1);
  }
}
