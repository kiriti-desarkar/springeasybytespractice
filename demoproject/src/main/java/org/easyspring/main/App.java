package org.easyspring.main;

import org.easyspring.beans.Vehicle;
import org.easyspring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda City");
        System.out.println("Vehicle name "+
                "from non-spring context is: "+
                vehicle.getName());
        /*
        The var keyword was introduced in Java 10.
        Type inference is used in var keyword
        in which it detects automatically
        the datatype of a variable based on
        the surrounding context.
         */
        //var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: "+
                veh.getName());

        /*
        We don't need to do any explicit casting while fetching
        a bean from context. Spring is smart enough to look for a bean
        of the type you requested in its context.
        If such a bean does not exist, Spring will throw an exception
         */
        String hello = context.getBean(String.class);
        System.out.println(hello);
        Integer num = context.getBean(Integer.class);
        System.out.println(num);
    }
}
