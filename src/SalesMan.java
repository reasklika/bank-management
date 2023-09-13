public class SalesMan {
    String code;
    String surname;
    String name;
    String SSN;
    
    SalesMan (String code, String surname, String name, String SSN){
        this.code = code;
        this.surname = surname;
        this.name = name;
        this.SSN = SSN;
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

    void setSSN(String SSN) {
        this.SSN = SSN;
    }

    String getCode (SalesMan sm) {
        return this.code;
    }

    public String toString(){
        return "Salesman code: " + this.code + "\nSalesman name: " + this.name + "\nSalesman surname: " + this.surname + "\nSalesman SSN: " + this.SSN + "\n"; 
    }
}