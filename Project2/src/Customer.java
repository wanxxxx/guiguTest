/**
 * @Author fangxi
 * @Description:Customer为实体对象，用来封装客户信息
 * @Date 2020-12-07 18:16
 */
public class Customer {
    private String  name;
    private String gender;
    private Integer age;
    private String phoneNum;
    private String mail;

    public Customer() {
    }

    public Customer(String name, String gender, Integer age, String phoneNum, String mail) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNum = phoneNum;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
