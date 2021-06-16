import classes.Car;
import classes.User;
import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String getAllParams(Method method){
        String str = "";
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < method.getParameterTypes().length; i++){
            list.add(method.getParameterTypes()[i].getName());
        }
        str = StringUtils.join(list, " ");
        return str;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        Object object;
        System.out.print("Classes:\n" +
                "\t - User\n" +
                "\t - Car\n" +
                "________________________\n" +
                "Enter class name:\n" +
                "-> "
        );
        String str = scanner.nextLine();
        if (!str.equals("User") && !str.equals("Car"))
            System.exit(-1);
        if (str.equals("User"))
            object = new User();
        else
            object = new Car();
        Field[] field = object.getClass().getDeclaredFields();
        System.out.print("---------------------\n" +
                            "fields:\n"
                );
        for (int i = 0; i < field.length; i++){
            System.out.println("\t" + field[i].getType().getSimpleName() + " " + field[i].getName());
        }
        System.out.println("methods:");
        Method[] methods = object.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++){
            System.out.println("\t" + methods[i].getReturnType().getSimpleName() + " " + methods[i].getName() + "(" + getAllParams(methods[i]) + ")");
        }
        System.out.println("---------------------\n" +
                "Let’s create an object.");
        
        for (int i = 0; i < field.length; i++){
            System.out.print(field[i].getName() + ":\n-> ");
            field[i].setAccessible(true);
            if (field[i].getType().getSimpleName().equals("int")){
                if (!scanner.hasNextInt())
                    System.exit(-1);
                try {
                    field[i].setInt(object, scanner.nextInt());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            } else {
                try {
                    field[i].set(object, scanner.nextLine());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }
        System.out.println("Object created: " + object);
        System.out.print("---------------------\n" +
                "Enter name of the field for changing:\n-> ");
        str = scanner.next();
        for (int i = 0 ; i < field.length; i++){
            if (field[i].getName().equals(str)){
                System.out.print("Enter " + field[i].getType().getSimpleName() + " value:\n-> ");
                if (field[i].getType().getSimpleName().equals("int")){
                    if (!scanner.hasNextInt())
                        System.exit(-1);
                    try {
                        field[i].setInt(object, scanner.nextInt());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                } else {
                    try {
                        field[i].set(object, scanner.next());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }
                continue;
            }
        }
        System.out.println("Object updated: " + object);
        System.out.print("---------------------\n" +
                "Enter name of the method for call:\n-> ");
        str = scanner.next();
        for (int i = 0; i < methods.length; i++){
            String nameMethod = methods[i].getName() + "(" + getAllParams(methods[i]) + ")";
            if (nameMethod.equals(str)){
                if (!getAllParams(methods[i]).equals("")){
                    System.out.print("Enter " + getAllParams(methods[i]) + " value:\n-> ");
                    if (!scanner.hasNextInt())
                        System.exit(-1);
                    try {
                        System.out.println("Method returned:\n" + methods[i].invoke(object, scanner.nextInt()).toString());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }
                else {
                    try {
                        System.out.println("Method returned:\n" + methods[i].invoke(object));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }
            }
        }
    }
}
