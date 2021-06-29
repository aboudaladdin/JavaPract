

import java.util.function.BiPredicate;

public class StringUtil
{
	public static boolean isBetterStr(String a,String b)
	{
		return a.length() > b.length();
	}
	public static boolean betterString(String a , String b , BiPredicate<String, String> p)
	{
		return p.test(a, b);
	}
	public static boolean betterNumber(Integer a , Integer b , BiPredicate<Integer, Integer> p)
	{
		return p.test(a, b);
	}
	
	public static <T,V> boolean betterGeneral(T a , V b , BiPredicate<T, V> p)
	{
		return p.test(a, b);
	}
}
