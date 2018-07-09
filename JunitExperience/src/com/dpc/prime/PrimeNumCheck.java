package com.dpc.prime;
/*接受一个1-100以内的数判断其是否为质数*/
public class PrimeNumCheck {

	//判断是否是100以内
	public boolean isRangeEgeal(int input) {

		return (input > 0 && input < 100);
	}

	// 判断是否为素数
	public boolean isPrime(int input){
		boolean result=true;
		if(input !=2){
			for(int i=2;i<100;i++){
				if(input %i==0){
					if(input!=i)
						result=false;
				}
			}
		}
		
		return result;
	}
}
