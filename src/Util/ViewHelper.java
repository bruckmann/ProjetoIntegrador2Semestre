package Util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ViewHelper {
    public static List<JTextField> validateFields(List<JTextField> aList) {
      List<JTextField> emptyFields = new ArrayList<>();
      if(aList.isEmpty()) {
        return aList;
      }
      for(JTextField field : aList) {
        if(field.getText().isBlank()){
          emptyFields.add(field);
        }
      }
      return emptyFields;
    }
}
