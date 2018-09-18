package ru.innopolis.stx13._7_classLoader.magic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HumanInvocation implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanLoader humanLoader = new HumanLoader(proxy.getClass().getClassLoader());
        Class humanClass = humanLoader.loadClass("ru.innopolis.stx13._7_classLoader.magic.proxy.EuropeanHuman");
        Method method1 = humanClass.getMethod(method.getName(), method.getParameterTypes());
        return method1.invoke(humanClass.newInstance(), args);
    }
}
