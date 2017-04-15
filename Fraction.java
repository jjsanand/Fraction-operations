/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraction;

/**
 *
 * @author Jagatdeep
 */
public class Fraction implements FractionInterface, Comparable<Fraction>
{
	private	int num;	// Numerator	
	private	int den;	// Denominator	

	public Fraction()
	{
		// set fraction to default = 0/1
		setFraction(0, 1);
	}	// end default constructor

	public Fraction(int numerator, int denominator)
	{
		// implement this method!
            setFraction(numerator,denominator);
	}	// end constructor

	public void setFraction(int numerator, int denominator)
	{
               num = numerator;
               den = denominator;
		if( den == 0){ 
                // return FractionException if initialDenominator is 0
                throw new ArithmeticException("Error, divide by 0. ");
               }
                reduceToLowestTerms();
               changeSign();   
               
        } //end setFraction
        
	public double toDouble()
	{
		// return double floating point value
		// implement this method!
		double n = num;	// convert to double
                double d = den;	
                return (n / d);		
	}	// end toDouble 

	public FractionInterface add(FractionInterface secondFraction)
	{
            int a,b,c,d;
            Fraction secFrac = (Fraction) secondFraction;
            a = getNumerator();
            b = getDenominator();
            c = secFrac.num;
            d = secFrac.den;
            
            Fraction sum = new Fraction (a*d + c*b, b*d);
            return sum;
	}	// end add

	public FractionInterface subtract(FractionInterface secondFraction)
	{
	    int a,b,c,d;
            Fraction secFrac = (Fraction) secondFraction;
            a = getNumerator();
            b = getDenominator();
            c = secFrac.num;
            d = secFrac.den;
            Fraction diff = new Fraction (a*d - c*b,b*d);
                return diff;
	}	// end subtract

	public FractionInterface multiply(FractionInterface secondFraction)
	{
            int a,b,c,d;
            Fraction secFrac = (Fraction) secondFraction;
            a = getNumerator();
            b = getDenominator();
            c = secFrac.num;
            d = secFrac.den;
            Fraction product = new Fraction (a*c, b*d );
		return product;
	}	// end multiply

	public FractionInterface divide(FractionInterface secondFraction)
	{
		
            int a,b,c,d;
            Fraction secFrac = (Fraction) secondFraction;
            a = getNumerator();
            b = getDenominator();
            c = secFrac.num;
            d = secFrac.den;
            Fraction quo = new Fraction();

             // return FractionException if secondFraction is 0
            if(secFrac.num == 0 || secFrac.den == 0) {  
            throw new ArithmeticException("Divide by 0");                                                  
        }
        else {
           quo = new Fraction(a*d,b*c);    
        } 
        return quo;                
	}	// end divide

	public FractionInterface getReciprocal() 
	{
	
        Fraction opposite = new Fraction();
        opposite = new Fraction(den,num);
         
        // return ArithmeticException if secondFraction is 0
        if(opposite.den == 0 || opposite.num == 0) {
            throw new ArithmeticException("ArithmeticException:");
        }
        else {
            opposite.changeSign();
        }
        return opposite;

	} // end getReciprocal


	public boolean equals(Object other)
	{
		Fraction secondFraction = (Fraction) other; // cast to Fraction
        return getNumerator() == secondFraction.num && 
                getDenominator() == secondFraction.den;
	} // end equals


	public int compareTo(Fraction other)
	{
		if ( this.equals(other)) {
            return 0; 
        }
         // if current Fraction is greater than 2nd fraction return 1
        else if (getNumerator() > other.getNumerator() && 
                getDenominator() > other.getDenominator()){
            return 1;
        }
        // if current Fraction is smaller than 2nd fraction return -1
        else if (getNumerator() < other.getNumerator() && 
                getDenominator() < other.getDenominator()){
            return -1;
        }
        return 0;

	} // end compareTo

	
	public String toString()
	{
		return num + "/" + den;
	} // end toString


	/** Task: Reduces a fraction to lowest terms. */

        //-----------------------------------------------------------------
        //  private methods start here
        //-----------------------------------------------------------------

    
        private int getNumerator()
        {
            return num;
            
        }
        
        private int getDenominator()
        {
            
            return den;
        }
        
        private void changeSign() {
        // implement this method!
        if (num > 0 && den < 0) {
            num = num * -1;
            den = den * -1;
        }
        else if (num < 0 && den < 0) {
            num = num * -1;
            den = den * -1;
        }
    }   // end changesign

         
	private void reduceToLowestTerms()
	{
                // implement this method!
                //
                // Outline:
                // compute GCD of num & den
                // greatestCommonDivisor works for + numbers.
                // So, you should eliminate - sign
                // then reduce numbers : num/GCD and den/GCD
            
            int gcd1 = greatestCommonDivisor(num,den);
            num = num / gcd1;
            den = den / gcd1;
            
            
	}	// end reduceToLowestTerms

  	/** Task: Computes the greatest common secondFraction of two integers.
	 *  @param integerOne	 an integer
	 *  @param integerTwo	 another integer
	 *  @return the greatest common divisor of the two integers */
	private int greatestCommonDivisor(int integerOne, int integerTwo)
	{
		 int result;

		 if (integerOne % integerTwo == 0)
			result = integerTwo;
		 else
			result = greatestCommonDivisor(integerTwo, integerOne % integerTwo);

		 return result;
	}	// end greatestCommonDivisor


	//-----------------------------------------------------------------
	//  Simple test is provided here 

	public static void main(String[] args)
	{
		FractionInterface firstOperand = null;
		FractionInterface secondOperand = null;
		FractionInterface result = null;
                double doubleResult = 0.0;

		Fraction nineSixteenths = new Fraction(9, 16);	// 9/16
		Fraction oneFourth = new Fraction(1, 4);        // 1/4

		System.out.println("\n=========================================");
		// 7/8 + 9/16
		firstOperand = new Fraction(7, 8);
		result = firstOperand.add(nineSixteenths);
		System.out.println("The sum of " + firstOperand + " and " +
				nineSixteenths + " is \t\t" + result);

		// 9/16 - 7/8
		firstOperand = nineSixteenths;
		secondOperand = new Fraction(7, 8);
		result = firstOperand.subtract(secondOperand);
		System.out.println("The difference of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);

		// 15/-2 * 1/4
		firstOperand.setFraction(15, -2);
		result = firstOperand.multiply(oneFourth);
		System.out.println("The product of " + firstOperand	+
				" and " +	oneFourth + " is \t" + result);

		// (-21/2) / (3/7)
		firstOperand.setFraction(-21, 2);
		secondOperand.setFraction(3, 7);
		result = firstOperand.divide(secondOperand);
		System.out.println("The quotient of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);

		// -21/2 + 7/8
		firstOperand.setFraction(-21, 2);
		secondOperand.setFraction(7, 8);
		result = firstOperand.add(secondOperand);
		System.out.println("The sum of " + firstOperand	+
				" and " +	secondOperand + " is \t\t" + result);


                // 0/10, 5/(-15), (-22)/7
		firstOperand.setFraction(0, 10);
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		firstOperand.setFraction(1, -3);
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		firstOperand.setFraction(-22, 7);
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\n=========================================");
		firstOperand.setFraction(-21, 2);
		System.out.println("First = " + firstOperand);
		// equality check
		System.out.println("check First equals First: ");
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of fractions OK");
		else
			System.out.println("ERROR in identity of fractions");

		secondOperand.setFraction(-42, 4);
		System.out.println("\nSecond = " + secondOperand);
		System.out.println("check First equals Second: ");
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of fractions OK");
		else
			System.out.println("ERROR in equality of fractions");

		// comparison check
		Fraction first  = (Fraction)firstOperand;
		Fraction second = (Fraction)secondOperand;
		
		System.out.println("\ncheck First compareTo Second: ");
		if (first.compareTo(second) == 0)
			System.out.println("Fractions == operator OK");
		else
			System.out.println("ERROR in fractions == operator");

		second.setFraction(7, 8);
		System.out.println("\nSecond = " + secondOperand);
		System.out.println("check First compareTo Second: ");
		if (first.compareTo(second) < 0)
			System.out.println("Fractions < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		System.out.println("\ncheck Second compareTo First: ");
		if (second.compareTo(first) > 0)
			System.out.println("Fractions > operator OK");
		else
			System.out.println("ERROR in fractions > operator");

		System.out.println("\n=========================================");

		System.out.println("\ncheck FractionException: 1/0");
		try {
			Fraction a1 = new Fraction(1, 0);		    
		}
		catch ( FractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch

		System.out.println("\ncheck FractionException: division");
		try {
			Fraction a2 = new Fraction();		    
			Fraction a3 = new Fraction(1, 2);		    
			a3.divide(a2);
		}
		catch ( FractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch



	}	// end main
} // end Fraction

