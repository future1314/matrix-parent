package zhangyuyao;

import java.lang.reflect.Field;

import com.google.gson.Gson;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 加载类
        // 反射获取属性
        // 构造函数确定对象
        // 为属性赋值
        // 反序列化输出对象

        Class<?> clazz = Class.forName("zhangyuyao.model.SimpleModel");

        Object object = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            Class<?> fieldClass = field.getType();

            field.setAccessible(true);

            if (fieldClass == byte.class || fieldClass == Byte.class) {

                field.set(object, getByteValue());

            } else if (fieldClass == short.class || fieldClass == Short.class) {

                field.set(object, getShortValue());

            } else if (fieldClass == char.class || fieldClass == Character.class) {
                field.set(object, getCharValue());

            } else if (fieldClass == boolean.class || fieldClass == Boolean.class) {
                field.set(object, getBooleanValue());

            } else if (fieldClass == int.class || fieldClass == Integer.class) {
                field.set(object, getIntValue());

            } else if (fieldClass == long.class || fieldClass == Long.class) {
                field.set(object, getLongValue());

            } else if (fieldClass == float.class || fieldClass == Float.class) {
                field.set(object, getFloatValue());

            } else if (fieldClass == double.class || fieldClass == Double.class) {
                field.set(object, getDoubleValue());

            } else {
                // 不是基本类型
                field.set(object, getObject(field));
            }

        }

        System.out.println(new Gson().toJson(object));
    }

    private static Object getObject(Field f) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = f.getType();

        Object object = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            Class<?> fieldClass = field.getType();

            field.setAccessible(true);

            if (fieldClass == byte.class || fieldClass == Byte.class) {

                field.set(object, getByteValue());

            } else if (fieldClass == short.class || fieldClass == Short.class) {

                field.set(object, getShortValue());

            } else if (fieldClass == char.class || fieldClass == Character.class) {
                field.set(object, getCharValue());

            } else if (fieldClass == boolean.class || fieldClass == Boolean.class) {
                field.set(object, getBooleanValue());

            } else if (fieldClass == int.class || fieldClass == Integer.class) {
                field.set(object, getIntValue());

            } else if (fieldClass == long.class || fieldClass == Long.class) {
                field.set(object, getLongValue());

            } else if (fieldClass == float.class || fieldClass == Float.class) {
                field.set(object, getFloatValue());

            } else if (fieldClass == double.class || fieldClass == Double.class) {
                field.set(object, getDoubleValue());

            }
        }
        return object;
    }

    public static byte getByteValue() {
        return 1;
    }

    public static short getShortValue() {
        return 2;
    }

    public static char getCharValue() {
        return '3';
    }

    public static boolean getBooleanValue() {
        return true;
    }

    public static int getIntValue() {
        return 5;
    }

    public static long getLongValue() {
        return 6;
    }

    public static float getFloatValue() {
        return 7.8f;
    }

    public static double getDoubleValue() {
        return 9.1;
    }
}