package cn.mnu.demo.container;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

import org.mockito.internal.stubbing.answers.ReturnsElementsOf;
public class MyArrays{
	
private MyArrays() {
}

public static <T> ArrayList<T> asListT(T... a) {
	return new ArrayList<T>(a);
//	return new ArrayList(a);
}

public static  ArrayList<String> asListString(String... a) {
	return new ArrayList<String>(a);
}

public static  ArrayList asList(Object... a) {
    return new ArrayList<>(a);
}

private static class ArrayList<E> extends AbstractList<E>
implements RandomAccess, java.io.Serializable
{
private static final long serialVersionUID = -2764017481108945198L;
private final E[] a;

ArrayList(E[] array) {
    a = Objects.requireNonNull(array);
}

@Override
public E get(int index) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}
}
}