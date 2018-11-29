/*
 * This Class demonstrates use of Todo annotation defined in Todo.java
 * 
 * @author Yashwant Golecha (ygolecha@gmail.com)
 * @version 1.0
 * 
 */

package cn.mnu.demo.A;

import cn.mnu.demo.A.Todo.Status;

public class BusinessLogic {
	@FieldAnnotation
	private A a;
	
    public BusinessLogic() {
        super();
    }
    
    @Todo(status=Status.FINISHED)
    public void compltedMethod() {
        System.out.println("This method is complete");
    }    
    
    @Todo(priority = Todo.Priority.HIGH)
    public void notYetStartedMethod() {
        // No Code Written yet
    }
    
    @Todo(priority = Todo.Priority.MEDIUM, author = "Uday", status = Todo.Status.ASSIGNED)
    public void incompleteMethod1() {
        //Some business logic is written
        //But its not complete yet
    }

    @Todo(priority = Todo.Priority.LOW, status = Todo.Status.ASSIGNED )
    public void incompleteMethod2() {
        //Some business logic is written
        //But its not complete yet
    }
}
