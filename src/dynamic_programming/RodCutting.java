package dynamic_programming;


public class RodCutting {
	
	private static int[] revenues;
	
	public static void main(String[] args) {
		//        {0, 1, 2, 3, 4,  5,  6,  7,  8,  9, 10}
		int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 26};
		int revenue = maxRevenueMemoizationBottomsUp(p, p.length-1);
		System.out.println(revenue);
		displayRevenues();
	}
	
	/*
	 * Recurssive approach to solving
	 */
	private static int maxRevenueRecurssive(int[] price, int n)
	{
		
		if(n == 0){
			return 0;
		}
		
		int q = Integer.MIN_VALUE;
		for(int j=1;j<=n;j++){
			q = max(q, price[j]+ maxRevenueRecurssive(price, n-j));
		}
		
		return q;
	}
	
	/*
	 * Top down memoization
	 */
	private static int maxRevenueMemoization(int[] price, int n)
	{
		int[] revenue = new int[price.length+1];
		for(int i=0;i<price.length;i++){
			revenue[i] = Integer.MIN_VALUE;
		}
		return maxRevenueMemoizationAux(price, revenue, n);
	}
	
	/*
	 * private static bottoms up memoization
	 */
	
	private static int maxRevenueMemoizationBottomsUp(int[] price, int n)
	{
		revenues = new int[price.length+1];
		
		for(int i=1;i<=n;i++)
		{
			int q = Integer.MIN_VALUE;
			for(int j=1;j<=i;j++)
			{
				q = max(q, price[j] + revenues[i-j]);
			}
			revenues[i] = q;
		}
		
		return revenues[n];
	}
	
	private static int maxRevenueMemoizationAux(int[] price, int[] revenue, int n){
		if(revenue[n]>=0){
			return revenue[n];
		} 
		
		if(n == 0)
		{
			return 0;
		}
		else{
		int q = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++)
			{
				q = max(q, price[i]+maxRevenueMemoizationAux(price, revenue, n-i));
			}
			revenue[n] = q;
			return q;
		}
	}
	
	private static int max(int a, int b){
		if(a>b){
			return a;
		}
		return b;
	}
	
	private static void displayRevenues()
	{
		for(int i =0;i<revenues.length;i++)
		{
			System.out.print(revenues[i] + " ");
		}
		System.out.println();
	}
}
