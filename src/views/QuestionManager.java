package views;

import javax.swing.*;
import java.awt.*;

public class QuestionManager extends StandartFormatLog {
    private JButton createButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTable questionTable;

    public QuestionManager(){

        createTable();

    }



    private void createTable(){



        JPanel panel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();

        createButton = new JButton("CRIAR");
        panel.add(createButton);
        buttonGroup.add(createButton);

        updateButton = new JButton("ALTERAR");
        panel.add(updateButton);
        buttonGroup.add(updateButton);

        deleteButton = new JButton("DELETAR");
        panel.add(deleteButton);
        buttonGroup.add(deleteButton);

        addComponet(panel,5,0,1,1);

        //FIM DOS BOTÕES

        questionTable = new JTable();
        /*questionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        questionTable.setMinimumSize();*/
        questionTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jScrollPane = new JScrollPane(questionTable);

        addComponet(jScrollPane,0,0,1,1);
    }

}
