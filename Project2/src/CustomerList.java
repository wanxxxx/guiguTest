/**
 * @Author fangxi
 * @Description:CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法，供CustomerList调用
 * @Date 2020-12-07 18:16
 */
public class CustomerList {
    private static Customer[] customers;
    private static Integer total = 0;

    public CustomerList(Integer totalCustomerNum) {
        customers = new Customer[totalCustomerNum];
    }

    //   customerList.show();
    //    每次“添加客户”（菜单1）后，客户（Customer）对象被添加到数组中。
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        } else {
            customers[total++] = customer;
            return true;
        }
    }

    //    每次“修改客户”（菜单2）后，修改后的客户（Customer）对象替换数组中原对象。
    public boolean replaceCustomer(Integer index, Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        } else {
            customers[index] = customer;
            return true;
        }

    }

    //    每次“删除客户”（菜单3）后，客户（Customer）对象被从数组中清除。
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

    //    执行“客户列表”（菜单4）时，将列出数组中所有客户的信息。
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
