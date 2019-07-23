package codegym.airbnb.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "houses")
public class House extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String typeHouse;
    private String typeRoom;
    private String address;
    @Column(name = "number_of_bathrooms")
    private Integer numberOfBathrooms;
    @Column(name = "number_of_bedrooms")
    private Integer numberOfBedrooms;
    @Column(name="describe_house")
    private String describe;
    @Column(name = "price_by_night")
    private String priceByNight;
    private String area;
    @Column(name = "price_by_month")
    private String priceByMonth;
    private String image;
//    @ManyToOne
//    @JoinColumn(name = "account_id")
//    private Account account;
    private String status;
    private Boolean deleted;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPriceByMonth() {
        return priceByMonth;
    }

    public void setPriceByMonth(String priceByMonth) {
        this.priceByMonth = priceByMonth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeHouse() {
        return typeHouse;
    }

    public void setTypeHouse(String typeHouse) {
        this.typeHouse = typeHouse;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Integer getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(Integer numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPriceByNight() {
        return priceByNight;
    }

    public void setPriceByNight(String priceByNight) {
        this.priceByNight = priceByNight;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
