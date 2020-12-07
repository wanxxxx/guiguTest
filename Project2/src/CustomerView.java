/**
 * @Author fangxi
 * @Description:负责菜单的显示和处理用户操作
 * @Date 2020-12-07 18:16
 */
public class CustomerView {
    private Customer[] customers = new Customer[5];

    //菜单的显示
    public void enterMainMenu() {
        boolean loopFlag = true;
        char choose;
        while (loopFlag) {
            System.out.print("-----------------客户信息管理软件-----------------\n" +
                    "\t\t\t\t 1 添 加 客 户\n" +
                    "\t\t\t\t 2 修 改 客 户\n" +
                    "\t\t\t\t 3 删 除 客 户\n" +
                    "\t\t\t\t 4 客 户 列 表\n" +
                    "\t\t\t\t 5 退       出\n" +
                    "\t\t\t\t 请选择(1-5)：");
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

    //处理用户操作
    public void addCustomer() {
//“添加客户”操作是否正确，给用户的提示是否明确合理；测试当添加的客户总数超过10时，运行是否正确

        System.out.println("---------------------添加客户---------------------");
        System.out.printf("姓名");
        String name = CMUtility.readString(4);
        do {
            System.out.printf("性别");
            CMUtility.readChar();
            if()
        } while (true);
        System.out.printf("年龄");
        System.out.printf("电话");
        System.out.printf("邮箱");

    }

    public void modifyCustomer() {
//“修改客户”操作是否正确，给用户的提示是否明确合理；
    }

    public void deleteCustomer() {
//“删除客户”操作是否正确，给用户的提示是否明确合理；

    }

    public void listAllCustomers() {
        //“客户列表”操作是否正确，表格是否规整；
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
