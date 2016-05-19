package com.lab111;

import com.lab111.labwork2.C11;
import com.lab111.labwork2.If2;
import com.lab111.labwork3.*;
import com.lab111.labwork4.Picture;

/**
 * Template first class.
 * @author Kyryll Kurylchenko
 *
 */
public final class TestMain {
  int id = 4311;
  public void Lab2(){
    C11 eks = new C11();
    If2 if2 = new C11();

    eks.meth1();
    eks.meth2();
    eks.meth3();
  };
  public void Lab3(){
    Diagram picture = new Diagram();

    Operator first = new Operator();
    first.part.setString("Begin");
    Operator second = new Operator();
    second.part.setString("i:=0");
    Condition third = new Condition();
    third.part.setString("i<5");
    Operator firstcondition = new Operator();
    firstcondition.part.setString("k+1;i++");
    Operator last =new Operator();
    last.part.setString("print i");
    Operator end = new Operator();
    end.part.setString("End");
    picture.addComponent(first);
    picture.addComponent(second);
    picture.addComponent(third);
    picture.addComponent(firstcondition);
    picture.addComponent(last);
    picture.addComponent(end);

    picture.WriteRelations();
  };
  public void Lab4(){
    Picture first = new Picture();
    first.show(true);
    first.setTyperamka(1,1,1,5);
    first.print();
  };

  /**
   * Constructor.
   *
   */
  private TestMain() {
    super();
  }
  
  /**
   * Invokes at application startup.
   * @param args Parameters from command line
   */
  public static void main(final String[] args) {
    System.out.println(4311%11);

      }

}
