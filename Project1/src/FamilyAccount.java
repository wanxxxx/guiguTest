/**
 * @Author fangxi
 * @Description:
 * @Date 2020-12-07 10:36
 */
public class FamilyAccount {
    public static Integer balance = 10000;
    public static StringBuffer details=new StringBuffer("��֧\t�˻����\t��֧���\t˵ ��\n");

    public char show() {
        System.out.print("-----------------��ͥ��֧�������-----------------\n" +
                "\t\t1 ��֧��ϸ\n" +
                "\t\t2 �Ǽ�����\n" +
                "\t\t3 �Ǽ�֧��\n" +
                "\t\t4 ��   ��\n" +
                "\t\t��ѡ��(1-4)��");
        return Utility.readMenuSelection();
    }

    public void details() {
        System.out.println(details.toString());
    }

    public void income() {
        System.out.print("���������");
        int incomeNum = Utility.readNumber();
        System.out.print("��������˵����");
        String description = Utility.readString();
        balance += incomeNum;
        details.append("����\t" + balance + "\t" + incomeNum + "\t" + description+"\n");
    }

    public void expend() {
        System.out.print("����֧����");
        int expendNum = Utility.readNumber();
        System.out.print("����֧��˵����");
        String description = Utility.readString();
        balance -= expendNum;
        details.append("֧��\t" + balance + "\t" + expendNum + "\t" + description+"\n");
    }

    public boolean exit() {
        System.out.println("ȷ���Ƿ��˳�(Y/N)��");
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
