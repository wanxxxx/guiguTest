/**
 * @Author fangxi
 * @Description:����˵�����ʾ�ʹ����û�����
 * @Date 2020-12-07 18:16
 */
public class CustomerView {
    private Customer[] customers = new Customer[5];

    //�˵�����ʾ
    public void enterMainMenu() {
        boolean loopFlag = true;
        char choose;
        while (loopFlag) {
//            System.out.print("-----------------�ͻ���Ϣ�������-----------------\n" +
//                    "\t\t 1 �� �� �� ��\n" +
//                    "\t\t 2 �� �� �� ��\n" +
//                    "\t\t 3 ɾ �� �� ��\n" +
//                    "\t\t 4 �� �� �� ��\n" +
//                    "\t\t 5 ��       ��\n" +
//                    "\t\t ��ѡ��(1-5)��");
            choose = CMUtility.readMenuSelection();
            switch (choose) {
                case '1':
                    addCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    if (CMUtility.readConfirmSelection() == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }


    }

    //�����û�����
    public void addCustomer() {
//����ӿͻ��������Ƿ���ȷ�����û�����ʾ�Ƿ���ȷ�������Ե���ӵĿͻ���������10ʱ�������Ƿ���ȷ

        System.out.println("---------------------��ӿͻ�---------------------");
        System.out.printf("����");
        String name = CMUtility.readString(4);
        do {
            System.out.printf("�Ա�");
            CMUtility.readChar();
        } while (true);
//        System.out.printf("����");
//        System.out.printf("�绰");
//        System.out.printf("����");

    }

    public void modifyCustomer() {
//���޸Ŀͻ��������Ƿ���ȷ�����û�����ʾ�Ƿ���ȷ����
    }

    public void deleteCustomer() {
//��ɾ���ͻ��������Ƿ���ȷ�����û�����ʾ�Ƿ���ȷ����

    }

    public void listAllCustomers() {
        //���ͻ��б������Ƿ���ȷ������Ƿ������
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
