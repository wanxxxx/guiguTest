/**
 * @Author fangxi
 * @Description:CustomerListΪCustomer����Ĺ���ģ�飬�ڲ����������һ��Customer���󣬲��ṩ��Ӧ����ӡ��޸ġ�ɾ���ͱ�����������CustomerList����
 * @Date 2020-12-07 18:16
 */
public class CustomerList {
    private static Customer[] customers;
    private static Integer total = 0;

    public CustomerList(Integer totalCustomerNum) {
        customers = new Customer[totalCustomerNum];
    }

    //   customerList.show();
    //    ÿ�Ρ���ӿͻ������˵�1���󣬿ͻ���Customer��������ӵ������С�
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        } else {
            customers[total++] = customer;
            return true;
        }
    }

    //    ÿ�Ρ��޸Ŀͻ������˵�2�����޸ĺ�Ŀͻ���Customer�������滻������ԭ����
    public boolean replaceCustomer(Integer index, Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            customers[index] = customer;
            return true;
        }

    }

    //    ÿ�Ρ�ɾ���ͻ������˵�3���󣬿ͻ���Customer�����󱻴������������
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            for (int i = index; i < total; i++) {
                customers[i] = customers[i + 1];
            }
            total--;
            customers[total] = null;
            return true;
        }
    }

    //    ִ�С��ͻ��б����˵�4��ʱ�����г����������пͻ�����Ϣ��
    public Customer[] getAllCustomers() {
        Customer[] cus = new Customer[total];
        for (int i = 0; i < total; i++) {
            cus[i] = customers[i];
        }
        return cus;
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        } else {
            return customers[index];
        }
    }
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
