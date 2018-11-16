package io.exnihilo.onlinetests;

import java.util.Scanner;

class PrimeNumber
{
public static void main(String[] args)
{
	int inpNo,flag;
	Scanner s=new Scanner(System.in);
	
	inpNo=s.nextInt();
	for(int i=2;i<inpNo;i++)
	{
		flag=0;
		for(int j=2;j<i;j++)
		{
			if(i%j==0)
				flag=1;
		}
		if(flag==0)
		{
		System.out.println(i);
		}	
	}
}
}
