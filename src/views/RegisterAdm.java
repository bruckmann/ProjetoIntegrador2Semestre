package views;

import Entities.user.Admin;
import Entities.user.User;
import Repositories.user.AdminRepository;
import Util.ViewHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RegisterAdm extends StandartFormatLog {
    private WindowManager frame;
    private ViewHelper helper = new ViewHelper();
    private final AdminRepository admRepo;

    public RegisterAdm(WindowManager windowManager){
        admRepo = new AdminRepository();
        this.frame = windowManager;
        init();
    }

    private void init(){
        JLabel label;

        label = new JLabel("OLÁ INSIRA SEUS DADOS: ");
        addComponet(label, 0, 0,5,2);

        label = new JLabel("NOME: ");
        addComponet(label,2,0,1,1);
        JTextField name = new JTextField(20);
        name.setName("Nome");
        addComponet(name,2,1,3,1);

        label = new JLabel("SENHA: ");
        addComponet(label, 3,0,1,1);
        JPasswordField password = new JPasswordField(10);
        password.setName("Senha");
        addComponet(password, 3,1,3,1);

        label = new JLabel("IDADE: ");
        addComponet(label, 4,0,1,1);
        JTextField yearsOld = new NumberMask(3);
        yearsOld.setName("Idade");
        addComponet(yearsOld,4,1,3,1);

        label = new JLabel("EMAIL: ");
        addComponet(label, 5,0,1,1);
        JTextField email = new JTextField(20);
        email.setName("Email");
        addComponet(email,5,1,3,1);

        JButton button = new JButton("CRIAR CONTA");
        button.addActionListener(new ActionListener() {
            Integer id = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<JTextField> emptyFields;
                List<JTextField> aJTextList = new ArrayList<JTextField>();
                aJTextList.add(name);
                aJTextList.add(yearsOld);
                aJTextList.add(email);

                emptyFields = helper.validateFields(aJTextList);
                boolean isPssValid = password.getPassword().length > 0;

                if(emptyFields.isEmpty() && isPssValid) {
                    id++;
                    User admin = new Admin(id, name.getText(), String.valueOf(password.getPassword()),
                            Integer.parseInt(yearsOld.getText()), email.getText());

                    List<User> admins;
                    admins = admRepo.getUsers();

                    for(User adminList : admins) {
                        if(adminList.getEmail().equals(email.getText())) {
                            JOptionPane.showMessageDialog(RegisterAdm.this,"Esse email já está cadastrado!",
                                    WindowManager.TITULO,
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }

                    admRepo.saveUser(admin);

                    JOptionPane.showMessageDialog(RegisterAdm.this,"Criação de conta concluida !!",
                            WindowManager.TITULO,
                            JOptionPane.INFORMATION_MESSAGE);
                    frame.ReturnToLogPage();
                } else {
                    for (JTextField field : emptyFields) {
                        JOptionPane.showMessageDialog(RegisterAdm.this,"O campo " + field.getName() + " não está preenchido\n",
                                WindowManager.TITULO,
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (!isPssValid) {
                        JOptionPane.showMessageDialog(RegisterAdm.this,"O campo " + password.getName() + " não está preenchido\n",
                                WindowManager.TITULO,
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        button.setForeground(Color.BLUE);
        addComponet(button, 7,1,1,1);
    }

}
