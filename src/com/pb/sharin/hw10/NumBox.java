package com.pb.sharin.hw10;

public class NumBox<T extends Number> {
    /*
                    F extends Number, D extends Number, B extends Number, L extends Number, S extends Number
       T - int(32), F - float, D - double, B - byte(8), L - long(64), S - short(16)
    private F floatValue;
    private D doubleValue;
    private B byteValue;
    private L longValue;
    private S shortValue;
     */
    private final T[] numbers;
    private int count = 0;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
        numbers[0] = null;
       System.out.println("Создан пустой массив.");
    }

    //передаем значение в массив
    public void add(T number) throws Exception {
        if (count == numbers.length) {
            throw new Exception("Массив полон.");
        } else {
            this.numbers[count] = number;
            count++;
            System.out.println("Добавлен " + count + "-й елемент массива.");
        }
    }

    //возвращающий число по индексу
    public T get(int index) {
        //проверка что в массиве есть значения и индекс в его приделах
        if ((count > 0) && (0 < index) && (index < count)) {
            return numbers[index];
        } else {
            if (count > 0) {
                //если индек некоррктный возвращаем последний элемент
                System.out.println("Елемента с указанным индексом нет. " +
                        "Последний доступный с индексом " + (count - 1));
                return numbers[count - 1];
            }
            else {
                return numbers[0];
            }
        }
    }

    //возвращает текущее количество элементов
    public int length() {
        return count;
    }

    //подсчет среднего арифметического среди элементов массива
    public double average() {
        double arrSum = sum();
        double arrAvr = arrSum / length();
        return arrAvr;
    }

    //сумма всех элементов массива
    public double sum() {
            double arrSum = 0;
            for (int i = 0; i < count; i++) arrSum = arrSum + get(i).doubleValue();

            return (double) arrSum;
    }

        //максимальный элемент массива.
        public T max() {
            int maxElem = 0;
            for (int i = 0; i < count; i++) {
                if (get(maxElem).doubleValue() < get(i).doubleValue()) {
                    maxElem = i;      //временное значение, для замены местами
                }
            }
            return get(maxElem);
        }

        public void print(){
           if(count >0) {
               for (int i = 0; i < count; i++) {
                   System.out.println(i + "-й: " + this.numbers[i]);
               }
           } else {
               System.out.println("Массив пуст.");
           }
        }
    }
