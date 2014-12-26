package geometria.mock;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class GenericHandle<T> implements InvocationHandler{

    private T _instance;

    @SuppressWarnings("unchecked")
    public GenericHandle( Class<T> type, Object ... initargs ){
	Constructor<?>[] constructors = type.getConstructors();
	String errors = "";
	for( Constructor<?> c: constructors ){
	    try{
		_instance = (T) c.newInstance(initargs);
	    }
	    catch(Exception e){
		errors += e.toString() + " -- ";
	    }
	}
	
	String s = Arrays.asList( initargs ).toString();
	throw new IllegalArgumentException( "No puedo crear una instancia de " + type.getName() + " con " + s + ":" + errors );
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T create( Class<T> type, Object ... initargs ){
	
	GenericHandle<T> handler = new GenericHandle<>(type, initargs);
	
	T proxy = (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, handler );
	return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
	
	Method[] methods = _instance.getClass().getMethods();
	String errors = "";
	for( Method m: methods ){
	    try{
		return m.invoke(_instance, args);
	    }
	    catch(Exception e){
		errors += e.toString() + " -- ";
	    }
	}

	String s = Arrays.asList( args ).toString();
	throw new IllegalStateException( "No se pudo invocar " + method.getName() + " con " + s + " : " + errors );
    }
}
