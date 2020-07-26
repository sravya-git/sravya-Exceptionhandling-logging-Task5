package Logging;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.LogManager;

/* 
 * Acts an interface for calculating different types of interests
 */
interface CalculateInterest

{
	public double getInterest(double principal,double time,double rate_of_interest);
}
/*
 * implementing the CalculateInterest 
 */
class SimpleInterest implements CalculateInterest
{
	double simple_interest;
	public double getInterest(double principal,double time,double rate_of_interest)
	{
		simple_interest=(principal*time*rate_of_interest)/100;
		return simple_interest;
	}
}
class CompoundInterest implements CalculateInterest
{
	double compound_interest,amount;
	
	public double getInterest(double principal,double time,double rate_of_interest)
	{
		amount=principal*Math.pow((1.0+rate_of_interest/100),time);
		compound_interest=amount-principal;
		return compound_interest;
	}
}
class GetData
{
	Scanner sc=new Scanner(System.in);
	 Logger logger=Logger.getLogger((GetData.class.getName()));
	
	 
   
    public double getPricipal()
    {
      logger.info("enter the principal");
      
      double principal=sc.nextDouble();
      return principal;
    }
    public double getPeriod()
    {
      logger.info("enter the period");
      double time=sc.nextDouble();
      return time;
    }public double getRateOfInterest()
    {
        logger.info("enter the Rate of Interest");
        double rate_of_interest=sc.nextDouble();
        return rate_of_interest;
    }
      
}
class Interest extends GetData
{

    static
    {
        Interest interest=new Interest();
        Logger logger = Logger.getLogger(Interest.class.getName());
    	double principal=interest.getPricipal();
    	double period=interest.getPeriod();
    	double rate_of_interest=interest.getRateOfInterest();
    	SimpleInterest si=new SimpleInterest();
    	CompoundInterest ci=new CompoundInterest();
    	double simple_interest=si.getInterest(principal, period, rate_of_interest);
    	double compound_interest=ci.getInterest(principal,period, rate_of_interest);
    	
    	 
    	 logger.info("Simple Interest="+simple_interest);
    	 logger.info("Compound Interest="+compound_interest);
 
    }
    public static void main(String args[])
    {
    	
    }

}

