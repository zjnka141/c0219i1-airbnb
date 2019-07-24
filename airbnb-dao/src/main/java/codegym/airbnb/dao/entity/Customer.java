package codegym.airbnb.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String tenant;
    private Date hire_date;
    private String house_type;
    private String house_address;
    private int price;
    private Boolean deleted;

    public Customer() {
    }

    public Customer(String tenant, Date hire_date, String house_type, String house_address) {
        this.tenant = tenant;
        this.hire_date = hire_date;
        this.house_type = house_type;
        this.house_address = house_address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", tenant='" + tenant + '\'' +
                ", hire_date=" + hire_date +
                ", house_type='" + house_type + '\'' +
                ", house_address='" + house_address + '\'' +
                ", rice='" + price + '\'' +
                ", deleded=" + deleted +
                '}';
    }
}
