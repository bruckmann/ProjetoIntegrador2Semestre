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

    label = new JLabel("OLÁ INSIRA SEUS DADOS: ");
    addComponent(label, 0, 0,5,2);

    label = new JLabel("NOME: ");
    addComponent(label,2,0,1,1);
    name = new JTextField(20);
    name.setName("Nome");
    addComponent(name,2,1,3,1);

    label = new JLabel("SENHA: ");
    addComponent(label, 3,0,1,1);
    password = new JPasswordField(10);
    password.setName("Senha");
    addComponent(password, 3,1,3,1);

    label = new JLabel("IDADE: ");
    addComponent(label, 4,0,1,1);
    yearsOld = new NumberMask(3);
    yearsOld.setName("Idade");
    addComponent(yearsOld,4,1,3,1);

    label = new JLabel("EMAIL: ");
    addComponent(label, 5,0,1,1);
    email = new JTextField(20);
    email.setName("Email");
    addComponent(email,5,1,3,1);

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
              JOptionPane.showMessageDialog(RegisterAdm.this,
                      "Esse email já está cadastrado!",
                      WindowManager.TITULO,
                      JOptionPane.INFORMATION_MESSAGE);
              return;
            }
          }

            admRepo.saveUser(admin);

            JOptionPane.showMessageDialog(RegisterAdm.this,
                    "Criação de conta concluída !!",
                    WindowManager.TITULO,
                    JOptionPane.INFORMATION_MESSAGE);
            frame.ReturnToLogPage();
          } else {
          for (JTextField field : emptyFields) {
            JOptionPane.showMessageDialog(RegisterAdm.this,
                    "O campo " + field.getName() + " não está preenchido\n",
                    WindowManager.TITULO,
                    JOptionPane.INFORMATION_MESSAGE);
          }

          if (!isPssValid) {
            JOptionPane.showMessageDialog(RegisterAdm.this,
                    "O campo " + password.getName() + " não está preenchido\n",
                    WindowManager.TITULO,
                    JOptionPane.INFORMATION_MESSAGE);
          }
        }
      }
    });
    button.setForeground(Color.BLUE);
    addComponent(button, 7,1,1,1);

    JButton buttonCancel = new JButton("Cancelar");
    buttonCancel.addActionListener(e -> frame.ReturnToLogPage());
    buttonCancel.setForeground(Color.red);
    addComponent(buttonCancel,7,2,2,1);
  }
}
