package views;

import Entities.user.User;
import Entities.user.Admin;
import Util.ViewHelper;
import Repositories.user.AdminRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LogWindow extends StandartFormatLog {
    private WindowManager frame;
    private ViewHelper helper = new ViewHelper();
    private final AdminRepository admRepo = new AdminRepository();

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
        addComponet(label, 0, 0,5,2);

        label = new JLabel("NOME: ");
        addComponet(label,2,0,1,1);
        name = new JTextField(20);
        name.setName("nome");
        addComponet(name, 2,1,3,1);

        label = new JLabel("SENHA: ");
        addComponet(label, 3,0,1,1);
        password = new JPasswordField(20);
        password.setName("senha");
        addComponet(password, 3,1,3,1);


        label = new JLabel("CRIAR CONTA: ");
        addComponet(label, 5,0,1,1);

        button = new JButton("ADMINISTRADOR");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLogAdm();
            }
        });
        button.setForeground(Color.BLUE);
        addComponet(button, 5,1,3,1);

        /*JButton button2 = new JButton("JOGADOR");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showLogPlayer();
            }
        });
        button2.setForeground(Color.RED);
        addComponet(button2, 5,2,1,1); */


        label = new JLabel(" ");
        addComponet(label, 6,0,1,1);

        JButton buttonLog = new JButton("LOGAR");
        buttonLog.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            java.util.List<JTextField> emptyFields;
            List<JTextField> aJTextList = new ArrayList<JTextField>();
            aJTextList.add(name);

            emptyFields = helper.validateFields(aJTextList);
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
                JOptionPane.showMessageDialog(LogWindow.this,"Usuário ou senha inválido",
                        WindowManager.TITULO,
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                for(JTextField field : emptyFields) {
                    JOptionPane.showMessageDialog(LogWindow.this,"O campo " + field.getName() + " não está preenchido\n",
                            WindowManager.TITULO,
                            JOptionPane.INFORMATION_MESSAGE);
                }

                if(!isPssValid) {
                    JOptionPane.showMessageDialog(LogWindow.this,"O campo " + password.getName() + " não está preenchido\n",
                            WindowManager.TITULO,
                            JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        });
        buttonLog.setForeground(Color.MAGENTA);
        addComponet(buttonLog,7,1,3,1);
    }
}
