package codegym.airbnb.dao.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class BookingDTO implements Serializable {
    private Integer id;
    private String fullName;
    private LocalDate birthday;
    private String relationship;
    private String gender;
    private String phone;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String descriptionBookingHouse;
    private Integer amount;

    public String getDescriptionBookingHouse() {
        return descriptionBookingHouse;
    }

    public void setDescriptionBookingHouse(String descriptionBookingHouse) {
        this.descriptionBookingHouse = descriptionBookingHouse;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
