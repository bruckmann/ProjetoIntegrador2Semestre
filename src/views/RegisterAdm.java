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
    JLabel labelName;
    JLabel labelPassword;
    JLabel labelAge;
    JLabel labelEmail;
    JLabel header;

    JButton buttonCreate;
    JButton buttonCancel;

    JPanel panelHeader;

    panelHeader = new JPanel();
    panelHeader.setBackground(Color.decode("#8EE4AF"));

    header = new JLabel("OLÁ INSIRA SEUS DADOS: ");
    addComponent(header, 0, 1,5,2);
    panelHeader.add(header);
    add(panelHeader,BorderLayout.NORTH);

    labelName = new JLabel("NOME: ");
    addComponent(labelName,2,1,1,1);
    name = new JTextField(20);
    name.setName("Nome");
    addComponent(name,3,1,3,1);
    panelLayout.add(labelName);
    panelLayout.add(name);

    labelPassword = new JLabel("SENHA: ");
    addComponent(labelPassword, 4,1,1,1);
    password = new JPasswordField(10);
    password.setName("Senha");
    addComponent(password, 5,1,3,1);
    panelLayout.add(labelPassword);
    panelLayout.add(password);


    labelAge = new JLabel("IDADE: ");
    addComponent(labelAge, 6,1,1,1);
    yearsOld = new NumberMask(3);
    yearsOld.setName("Idade");
    addComponent(yearsOld,7,1,3,1);
    panelLayout.add(labelAge);
    panelLayout.add(yearsOld);

    labelEmail = new JLabel("EMAIL: ");
    addComponent(labelEmail, 8,1,1,1);
    email = new JTextField(20);
    email.setName("Email");
    addComponent(email,9,1,3,1);
    panelLayout.add(labelEmail);
    panelLayout.add(email);

    buttonCreate = new JButton("CRIAR CONTA");
    buttonCreate.addActionListener(new ActionListener() {
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


          if(!admRepo.saveUser(admin)) {
            JOptionPane.showMessageDialog(thisFrame,"Erro na criação de conta!", title, infoMessage);
            return;
          }

          JOptionPane.showMessageDialog(thisFrame,"Criação de conta concluída!", title, infoMessage);
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
    buttonCreate.setForeground(Color.decode("#EEDDFF"));
    buttonCreate.setBackground(Color.decode("#379683"));
    addComponent(buttonCreate, 10,1,3,1);
    panelLayout.add(buttonCreate);

    buttonCancel = new JButton("CANCELAR");
    buttonCancel.addActionListener(e -> frame.ReturnToLogPage());
    buttonCancel.setForeground(Color.decode("#EEDDFF"));
    buttonCancel.setBackground(Color.decode("#379683"));
    addComponent(buttonCancel,11,1,3,1);
    panelLayout.add(buttonCancel);
    add(panelLayout,BorderLayout.CENTER);
  }
}
