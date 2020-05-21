import java.math.BigInteger;

public class FME {
    static BigInteger modPow(BigInteger base, BigInteger exp, BigInteger n){
        base=base.remainder(n);
        if(exp.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }
        else if (exp.equals(BigInteger.ONE)){
            return  base;
        }
        else if(exp.remainder(BigInteger.TWO).equals(BigInteger.ZERO)){
            return modPow(base.multiply(base.remainder(n)),exp.divide(BigInteger.TWO),n);
        }
        else {
            return (base.multiply(modPow(base,exp.subtract(BigInteger.ONE),n))).remainder(n);
        }
    }

}
