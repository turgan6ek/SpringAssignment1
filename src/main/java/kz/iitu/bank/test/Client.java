package kz.iitu.bank.test;

public class Client {
    private String name;
    private String phone_num;
    private String card_num;
    private String pin;
    private Double cash;

    public Client(String name, String phone_num, String card_num, String pin, Double cash){
        this.name = name;
        this.phone_num = phone_num;
        this.card_num = card_num;
        this.pin = pin;
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", card_num='" + card_num + '\'' +
                ", pin='" + pin + '\'' +
                ", cash=" + cash +
                '}';
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
