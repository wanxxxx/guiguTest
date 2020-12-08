package exception;

import java.util.Scanner;

/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-06 20:07
 */
public class EcmDef extends Exception {
    public static void main(String[] args) {
        try {
            new EcmDef().method(args);
        }catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (EcDef e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void method(String nums[]) throws Exception{
            double num1 = Integer.parseInt(nums[0]);
            double num2 = Integer.parseInt(nums[1]);

            if (num1 < 0 || num2 < 0) {
                throw new EcDef("不能为负数");
            }
            double a = num1 / num2;
            System.out.println("没问题");
    }

}


