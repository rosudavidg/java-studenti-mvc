package model;

public class Student {
    private int id;
    private String nume;
    private String prenume;
    private String cnp;

    public Student() {
    }

    public Student(String nume, String prenume, String cnp) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }

    public Student(int id, String nume, String prenume, String cnp) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
    
    @Override
    public String toString() {
        return this.id + " " + this.nume + " " + this.prenume + " " + this.cnp;
    }
}
