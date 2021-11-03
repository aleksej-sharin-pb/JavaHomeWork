package com.pb.sharin.hw6;

public class Veterinarian {

    private String fio;

    public Veterinarian(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        System.out.println(fio);
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void treatAnimal(Animal animal){
        String msg = new String();
        msg = "У ветеринара " + fio + " сейчас " + animal.getPet()+ ", "
            + "кормит "    + animal.getFood() + ", "
            + "отводит в "   + animal.getLocation() + ".";
        System.out.println(msg);
    }
}
