package com.pb.sharin.hw12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {
    //===========================================================================
    //Метод для вывода меню и выбора пользователя
    //===========================================================================
    static void startMenu() {
        System.out.println("--============================================--");
        System.out.println("Работа с телефонной книгой:");
        System.out.println("\t1. Добавление контакта       - нажмите \"1\".");
        System.out.println("\t2. Удаление контакта         - нажмите \"2\".");
        System.out.println("\t3. Информация по контактам   - нажмите \"3\".");
        System.out.println("Поиск контактов:");
        System.out.println("\t1. Поиск контактов по ФИО - нажмите \"4\".");
        System.out.println("Вывод всех записей с сортировкой:");
        System.out.println("\t1. По ФИО                    - нажмите \"5\".");
        System.out.println("\t2. По дате рождения          - нажмите \"6\".");
        System.out.println("Переход в меню Редактирование елемента  \t\"7\".");
        System.out.println("Експорт/Импорт телефонной книги:");
        System.out.println("\t1. Запись в файл (Експорт)    - нажмите \"8\".");
        System.out.println("\t2. Загрузка данных (Импорт)]  - нажмите \"9\".");
        System.out.println("Выход из приложения\t\t         - нажмите \"0\".");
    }

    //===========================================================================
    //Метод для редактирования Контактов
    //===========================================================================
    static void editMenu() {
        System.out.println("--============================================--");
        System.out.println("Редактирование контакта:");
        System.out.println("\t1. Указать ФИО редактируемого контакта \"1\".");
        System.out.println("\t2. Изменение ФИО             - нажмите \"2\".");
        System.out.println("\t3. Изменение адреса          - нажмите \"3\".");
        System.out.println("Выход из меню редактирования   - нажмите \"0\".");
    }

    static void exportContacts(ArrayList<Contact> contactsExport) throws JsonProcessingException {
        //=============================================================================
        //Выгрузка данных
        //=============================================================================
        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);
        //======================================================
/*      Для JSON стим не использую, оставил через MAP,
        тут пример заливки в String
        //======================================================
        String contactsJsonWriteSTRM = contactsExport.stream()
                .map(e -> e.toString())
                .reduce("", String::concat);

        System.out.println("--------------------------------------------");
        System.out.println("contactsJsonWriteSTRM:");
        System.out.println(contactsJsonWriteSTRM);
        System.out.println("--------------------------------------------");
 */
        //======================================================
        String contactsJsonWrite = mapper.writeValueAsString(contactsExport);
        //Локальный путь к файлу в проекте для выгрузки данных
        Path pathWrite = Paths.get("files/exportStream.json");

        try (BufferedWriter writer = Files.newBufferedWriter(pathWrite)) {
            writer.write(contactsJsonWrite);
        } catch (Exception ex) {
            System.out.println("Ошибка выгрузки данных: " + ex);
        }
        System.out.println("------------------------------------------");
        System.out.println("Print - contactsJsonWrite");
        System.out.println(contactsJsonWrite);
        System.out.println("------------------------------------------");

        System.out.println("Выгрузка успешно завершена.");
    }

    static ArrayList<Contact> importContacts() throws JsonProcessingException {
        //=============================================================================
        //Загрузка данных
        //=============================================================================
        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        //Локальный путь к файлу в проекте для загрузки данных
        Path pathLoad = Paths.get("files/exportStream.json");
        String contactsJsonRead = new String();

        try (BufferedReader reader = Files.newBufferedReader(pathLoad)) {
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            contactsJsonRead = stringBuilder.toString();

        } catch (Exception ex) {
            System.out.println("Ошибка загрузки данных: " + ex);
        }
        //Преобразовываем String в Contact
        ArrayList<Contact> contactsImport = mapper.readValue(contactsJsonRead, new TypeReference<ArrayList<Contact>>() {
        });
        System.out.println("------------------------------------------");
        System.out.println("Print - contactsJsonRead");
        System.out.println(contactsJsonRead);
        System.out.println("------------------------------------------");

        System.out.println("Загрузка успешно завершена.");
        return contactsImport;
    }

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("hw12 \"Lambda and Stream API\"");
        //==============================================================================
        //Значения для формирования тестовых данных
        //==============================================================================
        List<String> phons1 = Arrays.asList("0971234567", "0501234567", "0561234567");
        List<String> phons3 = Arrays.asList("0951234567");

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Иванов Иван Иванович", LocalDate.of(2000, 5, 2), phons1, "г.Днепр"));
        contacts.add(new Contact("Петров Петр Петрович", LocalDate.of(1990, 4, 12), "г.Киев"));
        contacts.add(new Contact("Дмитренко Дмитрий", LocalDate.of(1996, 1, 20), phons3, "г.Харьков"));
        contacts.add(new Contact("Сидоров С.С.", LocalDate.of(1980, 8, 20), phons3, "г.Днепр"));
        contacts.add(new Contact("Сидоров С.С.", LocalDate.of(1996, 5, 15), phons1, "г.Харьков"));

        //======================================================================
        int provMenu = 0; //переменная для условия работы приложения
        int provChoice = 0; //выбор пользователя
        startMenu();
        //======================================================================
        while (provMenu == 0) {
            System.out.println("--============================================--");
            System.out.println("Сделайте Ваш выбор:");
            Scanner scan = new Scanner(System.in);
            String userСhoice = scan.next();
            provChoice = Integer.parseInt(userСhoice);//получаем значение из метода для вывода меню и выбора пользователя

            if (provChoice == 0) {
                provMenu = 0;
                System.out.println("Bыход.");
                break;
            }
            // 1. Добавление контакта
            if (provChoice == 1) {
                try {
                    //Вывод данных
                    Scanner scanAdd = new Scanner(System.in);
                    System.out.println("Добавление нового контакта, введите данные:");
                    System.out.print("ФИО: ");
                    String addFio = scanAdd.nextLine();
                    System.out.print("Адрес: ");
                    String addAddress = scanAdd.nextLine();
                    System.out.print("Дату рождения (в формате \"yyyy-MM-dd\"): ");
                    String addDate = scanAdd.nextLine();
                    System.out.print("Телефон: ");
                    String phoneValue = scanAdd.nextLine();

                    DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE;
                    LocalDate addDateBD = LocalDate.parse(addDate, formatter1);

                    List<String> addPhone = Arrays.asList(phoneValue);
                    contacts.add(new Contact(addFio, addDateBD, addPhone, addAddress));
                    //System.out.println(addNew);

                } catch (Exception ex) {
                    System.out.println("Ошибка добавления данных." + ex);
                }
                System.out.println("Кол-во контактов:" + contacts.size());
                System.out.println(contacts);

                continue;
            }
            // 2. Удаление контакта
            if (provChoice == 2) {
                try {
                    Scanner scanAdd = new Scanner(System.in);
                    System.out.println("Удаление по ФИО, введите данные:");
                    String delFio = scanAdd.nextLine();
                    //==================================================================
                    //Лямбда выражение - удаление
                    if (contacts.removeIf(cs -> Objects.equals(cs.getFio(), delFio))) {
                        System.out.println("Удаление выполнено.");
                    } else System.out.println("Контакты для удаления не найдены.");
                    //==================================================================
                } catch (Exception ex) {
                    System.out.println("Ошибка удаления данных." + ex);
                }
                continue;
            }
            // 3. Вывод Контактов
            if (provChoice == 3) {
                try {
                    //==================================================================
                    //Вывод через стрим отсортированных по Адресу
                    contacts.stream()
                            .sorted(Comparator.comparing(Contact::getAddress))
                            .forEach(System.out::print);
                    //==================================================================
                    System.out.println();
                } catch (Exception ex) {
                    System.out.println("Ошибка вывода данных." + ex);
                }
                continue;
            }
            // 4. Поиск контактов по ФИО
            if (provChoice == 4) {
                try {
                    Scanner scanAdd = new Scanner(System.in);
                    System.out.println("Поиск по ФИО, введите данные:");
                    String provFio = scanAdd.nextLine();
                    //==================================================================
                    //Поиск через стрим по FIO в массив
                    List<Contact> findFIO;
                    findFIO = contacts.stream()
                            .sorted(Comparator.comparing(Contact::getFio))
                            .filter(c -> Objects.equals(provFio, c.getFio()))
                            .collect(Collectors.toList());
                    //==================================================================
                    //Если есть то выводим елементы
                    if (findFIO.size() > 0) {
                        System.out.println("-------------------------------------");
                        System.out.println("Найдено " + findFIO.size() + " контакт(ов).");
                        System.out.println(findFIO);
                    }
                    //Если НЕТ сообщение
                    else {
                        System.out.println("-------------------------------------");
                        System.out.println("Контакты не найдены");
                    }

                } catch (Exception ex) {
                    System.out.println("Ошибка поиска данных." + ex);
                }
                continue;
            }
            //  5. Сортировка по ФИО
            if (provChoice == 5) {
                //==================================================================
                //Вывод через стрим отсортированных по ФИО
                System.out.println("Сортировка по ФИО:");
                contacts.stream()
                        .sorted(Comparator.comparing(Contact::getFio))
                        .forEach(System.out::print);
                //==================================================================
                System.out.println();
                continue;
            }
            // 6. Сортировка по дате рождения
            if (provChoice == 6) {
                //==================================================================
                //Вывод через стрим отсортированных по ДАТЕ РОЖДЕНИЯ
                System.out.println("Сортировка по дате рождения:");
                contacts.stream()
                        .sorted(Comparator.comparing(Contact::getDateOfBirth))
                        .forEach(System.out::print);
                //==================================================================
                System.out.println();
                continue;
            }
            // 7. Переход в меню Редактирование елемента
            if (provChoice == 7) {
                try {
                    editMenu();
                    int provMenuEdit = 0; //переменная для условия работы приложения
                    int provChoiceEdit = 0; //выбор пользователя
                    int editIndex = -1;
                    //если есть данные редактируем последний добавленный
                    if (contacts.size() != 0) editIndex = contacts.size() - 1;
                    //======================================================================
                    while (provMenuEdit == 0) {
                        System.out.println("--============================================--");
                        System.out.println("Сделайте Ваш выбор по редактированию:");
                        Scanner scanEdit = new Scanner(System.in);
                        String userСhoiceEdit = scanEdit.next();
                        provChoiceEdit = Integer.parseInt(userСhoiceEdit);//получаем значение из метода для вывода меню и выбора пользователя

                        if (provChoiceEdit == 0) {
                            provMenuEdit = 0;
                            System.out.println("Bыход из меню редактирования.");
                            break;
                        }

                        if (provChoiceEdit == 1) {
                            try {

                                Scanner scanAdd = new Scanner(System.in);
                                System.out.println("Введите ФИО для поиска контакта:");
                                String editFio = scanAdd.nextLine();

                                int qtyElem = -1;
                                for (int i = 0; i < contacts.size(); i++) {
                                    if (editFio.equals(contacts.get(i).getFio()) == true) {
                                        qtyElem = i;
                                        break;
                                    }
                                    qtyElem++;
                                }
                                //Проверяем изменилось ли значение, найден ли индекс
                                if (qtyElem == -1) {
                                    System.out.println("-------------------------------------");
                                    System.out.println("Контакт для редактирования НЕ найден.");
                                } else {
                                    System.out.println("-------------------------------------");
                                    System.out.println("Контакт для редактирования найден. ИД:" + qtyElem);
                                    editIndex = qtyElem;
                                    contacts.get(editIndex).print();
                                }
                            } catch (Exception ex) {
                                System.out.println("Ошибка поиска." + ex);
                            }
                            //==================================================================
                            continue;
                        }
                        if (provChoiceEdit == 2) {
                            try {
                                System.out.println("--============================================--");
                                System.out.println("Текущее ФИО контакта:" + contacts.get(editIndex).getFio());
                                System.out.println("Введите ФИО для замены:");
                                String newFio = scanEdit.next();
                                contacts.get(editIndex).setFio(newFio);
                                contacts.get(editIndex).print();
                            } catch (Exception ex) {
                                System.out.println("Ошибка редактирования ФИО." + ex);
                            }
                            continue;
                        }
                        if (provChoiceEdit == 3) {
                            try {
                                System.out.println("--============================================--");
                                System.out.println("Контакт:" + contacts.get(editIndex).getFio());
                                System.out.println("\tизменяемы адрес: " + contacts.get(editIndex).getAddress());
                                System.out.println("Введите адрес для замены:");
                                String newAddress = scanEdit.next();
                                contacts.get(editIndex).setAddress(newAddress);
                                contacts.get(editIndex).print();
                            } catch (Exception ex) {
                                System.out.println("Ошибка редактирования адреса." + ex);
                            }
                            continue;
                        }


                    }

                    continue;
                } catch (Exception ex) {
                    System.out.println("Ошибка работы с меню редактирования." + ex);
                }
            }

            // 8. Запись в файл (Експорт)
            if (provChoice == 8) {
                exportContacts(contacts);
                continue;
            }
            // 9. Загрузка из файла (Импорт)
            if (provChoice == 9) {
                contacts = importContacts();
                continue;
            }
            System.out.println("Желаете продолжить работу?");
            continue;
        }
    }
}
