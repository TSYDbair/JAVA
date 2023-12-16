package org.example;

import ru.esstu.*;

import java.util.Scanner;

public class Main {
    private static void VV(StudentList studentList) {
        System.out.println("Список всех студентов:");
        for (Student student : studentList.getAll()) {
            System.out.print("ID:" + student.getId());
            System.out.print("- группа: " + student.getGroup()+"\n");
            System.out.print("   ФИО: " + student.getLastName());
            System.out.print(" " + student.getFirstName());
            System.out.print(" " + student.getPartonymicName()+"\n");
        }
    }

    private static void AddStudent(StudentList studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID: ");
        String id = scanner.next();
        System.out.print("Введите имя: ");
        String firstName = scanner.next();
        System.out.print("Введите фамилию: ");
        String lastName = scanner.next();
        System.out.print("Введите отчество: ");
        String patronymicName = scanner.next();
        System.out.print("Введите группу: ");
        String group = scanner.next();

        Student student = new Student(id, firstName, lastName, patronymicName, group);
        studentList.add(student);
    }

    private static void EditStudent(StudentList studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID: ");
        String id = scanner.next();
        Student EDStudent = studentList.getById(id);

        if (EDStudent != null) {
            System.out.print("Введите имя: ");
            String firstName = scanner.next();
            System.out.print("Введите фамилию: ");
            String lastName = scanner.next();
            System.out.print("Введите отчество: ");
            String partonymicName = scanner.next();
            System.out.print("Введите группу: ");
            String group = scanner.next();

            Student updatedStudent = new Student(id, firstName, lastName, partonymicName, group);
            studentList.update(updatedStudent);
        } else {
            System.out.println("Студент не найден.");
        }
    }

    private static void DeleteStudent(StudentList studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID: ");
        String id = scanner.next();
        Student DELStudent = studentList.getById(id);
        if (DELStudent != null) {
            studentList.delete(id);
        } else {
            System.out.println("Студент не найден.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList Data = null;

            System.out.println("1- List");
            System.out.println("2- TXT файл");
            System.out.println("3- XML файл");
            System.out.println("4- JSON файл");
            //System.out.println("5- База данных");
            int sw = scanner.nextInt();

            switch (sw) {
                case 1:
                    Data = new StudentListArrayList();
                break;
                case 2:
                    System.out.print("Введите название TXT папки: ");
                    String directory = scanner.next();
                    Data = new StudentListFile(directory);
                    break;
                case 3:
                    System.out.print("Введите название файла XML: ");
                    String xmlFileName = scanner.next();
                    Data = new StudentListXML(xmlFileName);
                    break;
                case 4:
                    System.out.print("Введите название файла JSON: ");
                    String jsonFileName = scanner.next();
                    Data = new StudentListJSON(jsonFileName);
                    break;
                default:
                    break;
            }


        for (;;) {
            System.out.println("1- Получить список всех студентов");
            System.out.println("2- Добавить студента");
            System.out.println("3- Редактировать");
            System.out.println("4- Удалить");

            int sw1 = scanner.nextInt();
            switch (sw1) {
                case 1:
                    VV(Data);
                    break;
                case 2:
                    AddStudent(Data);
                    break;
                case 3:
                    EditStudent(Data);
                    break;
                case 4:
                    DeleteStudent(Data);
                    break;
                default:
                    break;
            }
        }
    }
}