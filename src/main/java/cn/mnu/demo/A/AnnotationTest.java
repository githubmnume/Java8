package cn.mnu.demo.A;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) {
		try {
			getTodoReportForBusinessLogic();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
    /**
     * This method iterates through all messages of BusinessLogic class and fetches annotations defined on each of them.
     * After that it displays the information from annotation accordingly.
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    private static void getTodoReportForBusinessLogic() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Class<BusinessLogic> businessLogicClass = BusinessLogic.class;
        for(Method method : businessLogicClass.getMethods()) {
            Todo todoAnnotation = (Todo)method.getAnnotation(Todo.class);
            if(todoAnnotation != null) {
                System.out.println(" Method Name : " + method.getName());
                System.out.println(" Author : " + todoAnnotation.author());
                System.out.println(" Priority : " + todoAnnotation.priority());
                System.out.println(" Status : " + todoAnnotation.status());
                System.out.println(" --------------------------- ");
            }
        }
        Field[] declaredFields = businessLogicClass.getDeclaredFields();
        
        for (Field field : declaredFields) {
        	Annotation[] annotations = field.getAnnotations();
        	for (Annotation annotation : annotations) {
//        			System.out.println("Field is " + field.getName()+" and claess is " +field.getDeclaringClass() + field.getType()+ " gg"+field.getGenericType() +"annotation " +annotation.annotationType() );
        			try {
						Object instance = getInstance(field.getType());
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		/*Class<A> type = (Class<A>) field.getType();
        			Class<?> forName = Class.forName(field.getType().toString());
        			try {
						Object newInstance =type.newInstance();
						A newInstance2 = type.newInstance();
						System.out.println(newInstance.toString());
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
        		 
			}
		}
    }
    
    private static <T>  Object getInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {
//    	Class<T>
		return (T)clazz.newInstance();
	}
}
