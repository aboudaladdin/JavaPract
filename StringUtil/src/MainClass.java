import java.util.function.BiPredicate;


public class MainClass
{

	public static void main(String[] args)
	{
		BiPredicate<String, String> stcomparator = (n,d) -> n.length() > d.length() ? true : false;
		BiPredicate<String ,Integer> intStringComp = (n,d) -> n.length() > d ? true:false;
		
		System.out.println(StringUtil.betterString("Abbb", "ZzzZzz", stcomparator));
		System.out.println(StringUtil.betterString("Abb", "Zz", StringUtil::isBetterStr));
		System.out.println(StringUtil.betterGeneral("Abbb", 2, intStringComp));
	}

}
