package epi.arrays;

public class DutchNationalFlagProblem {

	public static void main(String[] args) 
	{
		COLORS[] colors = {COLORS.WHITE, COLORS.RED, COLORS.WHITE, COLORS.RED, COLORS.BLUE, COLORS.BLUE, //
				COLORS.WHITE, COLORS.RED, COLORS.BLUE};
		partition(0, colors);
		partition(colors.length-1, colors);
		displayArray(colors);
	}
	
	private enum COLORS{
		RED(1), BLUE(2), WHITE(3);
		
		private int code;
		private COLORS(int code)
		{
			this.code = code;
		}
		
		public int getCode()
		{
			return code;
		}
	}
	
	
	private static void partition(int pivot, COLORS[] colors)
	{
		COLORS pivotColor = colors[pivot];
		
		int smallerCodeIndex = 0;
		int greaterCodeIndex = colors.length-1;
		
		int equal = 0;
		
		while(equal < greaterCodeIndex)
		{
			if(colors[equal].getCode()<pivotColor.getCode())
			{
				swap(colors, smallerCodeIndex, equal);
				smallerCodeIndex++;
				equal++;
			}
			else if(colors[equal].getCode() == pivotColor.getCode())
			{
				equal++;
			}
			else
			{
				swap(colors, equal, greaterCodeIndex);
				greaterCodeIndex--;
			}
		}
	}

	private static void swap(COLORS[] colors, int i, int smallerCodeIndex) 
	{
		COLORS temp = colors[i];
		colors[i] = colors[smallerCodeIndex];
		colors[smallerCodeIndex] = temp;
	}

	private static void displayArray(COLORS[] colors)
	{
		for(int i=0;i<colors.length;i++)
		{
			System.out.print(colors[i].name() + " ");
		}
	}
	
}
