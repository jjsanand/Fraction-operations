/************************************************************************************
 * Do not modify this file.
 * FractionException class. It is used by Fraction class
 *************************************************************************************/

package csc220.assignment1;

public class FractionException extends RuntimeException
{
    public FractionException()
    {
	this("");
    }

    public FractionException(String errorMsg) 
    {
	super(errorMsg);
    }

}
