package ua.prog.kiev.lesson1.taskTwo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTaskTwo {

    private static void storeDataToAnnotatedFile() throws InvocationTargetException, IllegalAccessException {
        Saver instanceOfSaver = new Saver();
        Class<?> saver = instanceOfSaver.getClass();
        Field[] allFields = saver.getDeclaredFields();
        for (Field field : allFields) {
            if (field.isAnnotationPresent(WriteTo.class)) {
                WriteTo writeTo = field.getAnnotation(WriteTo.class);
                field.setAccessible(true);
                field.set(instanceOfSaver, writeTo.path());
                break;
            }
        }

        Method[] allClassMethods = saver.getDeclaredMethods();
        for (Method method : allClassMethods) {
            if (method.isAnnotationPresent(WriteToFile.class)) {
                method.invoke(instanceOfSaver);
                System.out.println("Method " + method.getName() + " saved text to file succesfully.");
            }
        }
    }

    public static void main(String[] args) {
        try {
            storeDataToAnnotatedFile();
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
