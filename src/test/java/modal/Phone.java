package modal;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data  // Аннотация @Data принадлежит библиотеке Lombok и автоматически генерирует несколько полезных методов для класса, упрощая работу с ним. Конкретно, она создает:
//Геттеры и сеттеры для всех полей.
//
//Метод toString(), который возвращает строковое представление объекта с текущими значениями всех полей.
//
//Методы equals() и hashCode(), которые позволяют сравнивать объекты этого класса и использовать их в коллекциях, таких как HashMap или HashSet.
//Это значительно сокращает объем кода, который вам нужно писать и поддерживать, и делает класс более читабельным.
public class Phone {
    private String brand;
    private String model;
    private final List<String> navigationSystem = new ArrayList<>(); //Это поле представляет систему навигации, которую поддерживает телефон. Используется List, что позволяет хранить несколько навигационных систем, таких как GPS, GLONASS, Galileo и т. д. Поле объявлено как final, что означает, что ссылка на этот список не может быть изменена, но вы можете добавлять или удалять элементы из списка.
    private String operatingSystem;
    private int memoryGB;
    private Cpu cpu;
    private Camera camera;


}
