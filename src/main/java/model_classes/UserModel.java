package model_classes;

import java.util.Objects;

public class UserModel {
    public int id;
    public String name;
    public String username;
    public String email;
    public AddressModel address;
    public String phone;
    public String website;
    public CompanyModel company;

    public UserModel(int id, String name, String username, String email, AddressModel address, String phone, String website, CompanyModel company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        UserModel other = (UserModel) obj;
        return id == other.id &&
                Objects.equals(name, other.name) &&
                Objects.equals(username, other.username) &&
                Objects.equals(email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email);
    }
}