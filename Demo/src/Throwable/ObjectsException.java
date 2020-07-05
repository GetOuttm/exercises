package Throwable;

import java.util.Objects;

public class ObjectsException {
    public static void main(String[] args) {
        method(null);
    }

    public static void method(Object o) {
        if (o == null) {
            throw new NullPointerException("对象为空");
        }
        Objects.requireNonNull(o,"对象为空");
    }

}

