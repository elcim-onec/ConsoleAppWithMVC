package com.company.View;

public class Menu {
    public void displayMenu(){

        System.out.println("Welcome");
        System.out.println(" _______________________________________________________________________");
        System.out.println("|                                                                       |");
        System.out.println("|       Enter any combination of existing entity and CRUD number :      |");
        System.out.println("|_______________________________________________________________________|");
        System.out.println("|                                  |                                    |");
        System.out.println("|        entity number:            |           CRUD number:             |");
        System.out.println("|__________________________________|____________________________________|");
        System.out.println("|   |                              |   |                                |");
        System.out.println("| 1 | Score                        | 1 | GET ALL                        |");
        System.out.println("| 2 | Sentiment                    | 2 | GET BY ID                      |");
        System.out.println("| 3 | Comment Segment              | 3 | CREATE                         |");
        System.out.println("| 4 | Product                      | 4 | UPDATE                         |");
        System.out.println("|   |                              | 5 | DELETE                         |");
        System.out.println("|___|______________________________|___|________________________________|");
    }
}
