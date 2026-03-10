package trees;


import java.math.BigDecimal;
import java.math.RoundingMode;


public class PowOfXraisedToN {

    public double myPow(double x, int n) {
        return recursivePower(x,n);
    }

    private double recursivePower(double x, int n){
        if (n == 1){
            return x;
        }

        double value = 0.0;
        if (n < 0){
            value = 1 / (x * recursivePower(x,(n*-1)-1));
        }
        else{
            value = x * recursivePower(x, n-1);
        }

//        String stringValue = String.format("%.5f", value);
//        DecimalFormat df = new DecimalFormat("#.00000");
//        String formattedVal = df.format(value);


//        return Double.parseDouble(stringValue.substring(0, stringValue.length()-1));
        return BigDecimal.valueOf(value).setScale(5, RoundingMode.HALF_UP).doubleValue();
    }
}
