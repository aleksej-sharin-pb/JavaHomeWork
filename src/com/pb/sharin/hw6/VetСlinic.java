package com.pb.sharin.hw6;
import com.pb.sharin.hw6.Veterinarian;
import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        //================================================================
        //Создаем животных
        Dog dog1 = new Dog("Жужа", "белой масти", "есть");  //собака с ошейником
        Dog dog2 = new Dog("Жужа", "белой масти", "нет");   //собака без ошейника
        Cat cat  = new Cat("Люся", "Мейкун");
        Horse horse = new Horse("Бурушка", "Богатырский");

        //================================================================
        //Демонстрация методов по животным
        System.out.println("------------------------------------------");
        System.out.println(dog1);
        dog1.makeNoise();

        System.out.println(cat);
        cat.eat();

        System.out.println(horse);
        horse.sleep();
        //================================================================
        //Отводим их в вет.клинику
        System.out.println("------------------------------------------");
        Animal[] animals = new Animal[]{dog1, cat, horse};

        //================================================================
        //Создали ветеринара через конструктор
        Veterinarian veterinar = new Veterinarian("Петров П.П.");
        System.out.println("------------------------------------------");
        //================================================================
        //Меняем ветеринара по рефлексии
        Class vetClass = Class.forName("com.pb.sharin.hw6.Veterinarian");
        Constructor constr = vetClass.getConstructor(new Class[] {String.class});
        Object obj = constr.newInstance("Иванов И.И.");
        if(obj instanceof Veterinarian){
            System.out.println("Ветеренар " + veterinar.getFio() + "ушел домой." );
            veterinar = ((Veterinarian) obj); //подмена на созданного по рефлексии
            System.out.println("Вместе него будет принимать " + veterinar.getFio() + "." );
        }
        //================================================================
        //Начинаем лечить всех животных
        System.out.println("------------------------------------------");
        System.out.println("Клиника работает!!!");
        for(Animal a: animals){
            veterinar.treatAnimal(a);
        }
        System.out.println("Лечение животных завершено.");
        //================================================================
        //Демонстрация переопределенных методов
        System.out.println("------------------------------------------");
        System.out.println("toString dog2 ->" + dog1.toString());
        System.out.println("toString dog2 ->" + dog2.toString());
        System.out.println("equals dog1 and dog2 ->" + dog1.equals(dog2)); //собаки Жужи, сравниваем породу и кличку
        System.out.println("hashCode dog1 ->" + dog1.hashCode());          //сравниваем породу, кличку и наличие ошейника
        System.out.println("hashCode dog2 ->" + dog2.hashCode());          //коды будут разные
        System.out.println("------------------------------------------");
    }
}
