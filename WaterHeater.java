import java.util.Date;

/**
 * Created by miked on 10/4/2016.
 */
public class WaterHeater extends ServiceCall {
    //add variables for age and city fee, only for Water Heater
    private int age;
    private double cityFee;
    //Needed variables to define the Water Heater object
    public WaterHeater(String serviceAddress, String problemDescription, Date date, int age){

        super(serviceAddress,problemDescription,date);

        this.age = age;
    }
        //getters and setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //Method determines city fee based on whether or not the issue is resolved
    public double getCityFee() {
        //if the service call is not resolved, there is no city fee
        if (resolvedDate == null) {
            cityFee = 0;
            return cityFee;
        } else {
            //only when the issue is resolved, the city fee is enforced
            cityFee = 20;
            return cityFee;
        }
    }

    public void setCityFee(double cityFee) {
        this.cityFee = cityFee;

    }

    @Override
    public String toString() {

        //These statements use the Java ternary operator
        //This says "if resolvedDate == null, then set resolvedDate to "Unresolved". Otherwise, set resolvedDate to resolvedDate.toString()
        //Same logic as an if-else statment, but more consise if the condition is simple and the if statment's task is
        //to set the value of a variable based on a condition being true or false.
        String resolvedDateString = (resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = (this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);
        //use getCityFee because the city fee variable changes based on resolution of service call
        String cityFeeString = (cityFee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(getCityFee());

        return "Water Heater Service Call " + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Age of unit= " + age +"\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString +"\n" +
                "City Fee = " + cityFeeString + "\n" +
                "Total Charges= $" + (getTotalCharges());//Display total charges to reflect both fee and city fee
    }
    //method to get the total charges if the service call is resolved
    public double getTotalCharges( ) {
        if (resolvedDate == null) {
            /*because the fee will return a -1 if the issue is not resolved, we set the total charges variable to
            * zero if the service call is not resolved*/
            double totalCharges = 0;
            return totalCharges;
        } else {
            //when the service call is resolved, calculate the total charges
            double totalCharges = getCityFee() + getFee();
            return totalCharges;
        }

    }


}
