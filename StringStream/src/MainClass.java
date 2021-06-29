import java.util.stream.Stream;

public class MainClass
{

	public static void main(String[] args)
	{
		String str_test1 = "Hello Java";
		String str_test2 = "Hello Java8";
		String str_test3 = "Hello Java!";
		
		System.out.println(isallAlphabet(""));
		System.out.println(isallAlphabet(null));
		System.out.println(isallAlphabet(str_test1));
		System.out.println(isallAlphabet(str_test2));
		System.out.println(isallAlphabet(str_test3));
	}
	
	public static boolean isallAlphabet(String s_input)
	{
		if(s_input != null)
		{
			if(!s_input.isEmpty())
			{
				Boolean test = s_input.chars().allMatch(ch -> Character.isLetter(ch )|| Character.isSpaceChar(ch));
				return test;
			}
		}
		return false;
	}
}
