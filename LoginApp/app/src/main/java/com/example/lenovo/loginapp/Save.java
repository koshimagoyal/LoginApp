package com.example.lenovo.loginapp;

/**
 * Created by lenovo on 25-01-2018.
 */


public class Save {
            String firstname,lastname,add,city,state,street,country,pin,mobno,bankno,code;

            public Save()
            {

            }

            public Save(String firstname,String lastname,String city,String street,String state,String country,String pin,String mobno,String bankno,String code)
            {
                this.firstname=firstname;
                this.lastname=lastname;
                this.add=add;
                this.city=city;
                this.country=country;
                this.state=state;
                this.street=street;
                this.pin=pin;
                this.mobno=mobno;
                this.bankno=bankno;
                this.code=code;


            }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }



    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }

    public String getPin() {
        return pin;
    }

    public String getMobno() {
        return mobno;
    }

    public String getBankno() {
        return bankno;
    }

    public String getCode() {
        return code;
    }
}

