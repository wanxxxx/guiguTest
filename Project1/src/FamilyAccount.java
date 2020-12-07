/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-07 10:36
 */
public class FamilyAccount {
    public static Integer balance = 10000;
    public static StringBuffer details=new StringBuffer("收支\t账户金额\t收支金额\t说 明\n");

    public char show() {
        System.out.print("-----------------家庭收支记账软件-----------------\n" +
                "\t\t1 收支明细\n" +
                "\t\t2 登记收入\n" +
                "\t\t3 登记支出\n" +
                "\t\t4 退   出\n" +
                "\t\t请选择(1-4)：");
        return Utility.readMenuSelection();
    }

    public void details() {
        System.out.println(details.toString());
    }

    public void income() {
        System.out.print("本次收入金额：");
        int incomeNum = Utility.readNumber();
        System.out.print("本次收入说明：");
        String description = Utility.readString();
        balance += incomeNum;
        details.append("收入\t" + balance + "\t" + incomeNum + "\t" + description+"\n");
    }

    public void expend() {
        System.out.print("本次支出金额：");
        int expendNum = Utility.readNumber();
        System.out.print("本次支出说明：");
        String description = Utility.readString();
        balance -= expendNum;
        details.append("支出\t" + balance + "\t" + expendNum + "\t" + description+"\n");
    }

    public boolean exit() {
        System.out.println("确认是否退出(Y/N)：");
        if (Utility.readConfirmSelection() == 'Y') {
            return false;
        } else return true;
    }

    public static void main(String[] args) {
        FamilyAccount familyAccount = new FamilyAccount();
        boolean loopFlag = true;
        char choose;
        while (loopFlag) {
            choose = familyAccount.show();
            switch (choose) {
                case '1':
                    familyAccount.details();
                    break;
                case '2':
                    familyAccount.income();
                    break;
                case '3':
                    familyAccount.expend();
                    break;
                case '4':
                    loopFlag = familyAccount.exit();
            }
        }
    }
}
