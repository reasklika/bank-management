public class SalesMan {
    String code;
    String surname;
    String name;
    String AFM;
    
    SalesMan (String code, String surname, String name, String AFM){
        this.code = code;
        this.surname = surname;
        this.name = name;
        this.AFM = AFM;
    }

    SalesMan() {
        
    }

    void setCode(String code) {
        this.code = code;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAFM(String AFM) {
        this.AFM = AFM;
    }

    String getCode (SalesMan sm) {
        return this.code;
    }

    public String toString(){
        return "Salesman code: " + this.code + "\nSalesman name: " + this.name + "\nSalesman surname: " + this.surname + "\nSalesman AFM: " + this.AFM + "\n"; 
    }
}