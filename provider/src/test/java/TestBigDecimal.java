import org.junit.Test;

import java.math.BigDecimal;

/**
 * @ClassName TestBigDecimal
 * @Description: TODO
 * @Author lxc
 * @Date 2020/7/24 18:15
 * @Version V1.0
 **/
public class TestBigDecimal {

    @Test
    public void testDecimal() {
        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("5");
        BigDecimal num3 = null;

//加法
        num3 = num1.add(num2);
        System.out.println("num1+num2 = " + num3);

//减法
        num3 = num1.subtract(num2);
        System.out.println("num1-num2 = " + num3);

//乘法
        num3 = num1.multiply(num2);
        System.out.println("num1*num2 = " + num3);

//除法
        num3 = num1.divide(num2);
        System.out.println("num1/num2 = " + num3);
    }
}
