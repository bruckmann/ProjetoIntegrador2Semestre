package Entities.questions;

public class Alternative {

  private int value;
  private boolean isRight;

  public Alternative(int value, boolean isRight) {
    this.value = value;
    this.isRight = isRight;
  }

  public int getValue(){
    return this.value;
  }

  public boolean correct() {
    return this.isRight;
  }

}
