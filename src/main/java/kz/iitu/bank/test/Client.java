package kz.iitu.bank.test;

public class Client {
    private int client_id;

    public int getClient_id() {
        return client_id;
    }
    public Client(){

    }
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    private String name;
    private String phone_num;
    private String card_num;
    private String pin;
    private Double cash;
    private String cvv, Exp_date;

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExp_date() {
        return Exp_date;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", card_num='" + card_num + '\'' +
                ", pin='" + pin + '\'' +
                ", cash=" + cash +
                ", cvv='" + cvv + '\'' +
                ", Exp_date='" + Exp_date + '\'' +
                '}';
    }

    public void setExp_date(String exp_date) {
        Exp_date = exp_date;
    }

    public Client(int client_id, String name, String phone_num, String card_num, String exp_date,String cvv, String pin, Double cash) {
        this.client_id = client_id;
        this.name = name;
        this.phone_num = phone_num;
        this.card_num = card_num;
        this.pin = pin;
        this.cash = cash;
        this.cvv = cvv;
        Exp_date = exp_date;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }
}
