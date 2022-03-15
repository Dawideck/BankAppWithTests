import java.util.Scanner;

public class BankApp {


    public static void main(String[] args) {

        Scanner inpucik = new Scanner(System.in);   //deklarujemy skaner
        boolean brejker = true;                     //zmienna obslugujaca petle
        boolean brejker2 = true;                    //zmienna obslugujaca drugą petle
        int userAccNum;                             //zmienna zapisujaca wybor numeru konta
        int iterator = 0;                           //zmienna informujaca petle o ilosci stworzonych kont oraz o numerze kolejnego konta
        int choice;                                 //zmienna od wyboru opcji z menu

        Account[] accArray = new Account[10];       //tworzymy tablice ktora obsluzy maksymalnie 10 kont


        System.out.println("========================");
        System.out.println("Welcome to our The 10 AccountsBank.");
        System.out.println("========================\n");

        System.out.println();

        //tworzymy pierwsze konto na pozycji 0
        accArray[iterator] = new Account();

        System.out.println("Please create the FIRST account.");
        System.out.println("Enter your name: ");
        String name = inpucik.nextLine();
        accArray[iterator].setUserName(name);

        System.out.println("Enter your surname: ");
        String surname = inpucik.nextLine();
        accArray[iterator].setUserSurname(surname);

        System.out.println("Enter your desired account number: ");
        userAccNum = inpucik.nextInt();
        accArray[iterator].setAccNumber(userAccNum);

        //zwieksz wartosc zmiennej o 1, dzieki czemu kolejne konto zostanie stworzone na kolejnej pozycji tablicy
        iterator++;

        //glowna petla w ktorej sie wszystko dzieje, bedzie aktywna, dopoki brejker nie dostanie wartosci "false"
        while (brejker) {

                // "Menu" wyboru
                System.out.println("1: If you want to create a new account.");
                System.out.println("2: To check your account balance.");
                System.out.println("3: To deposit moneyz.");
                System.out.println("4: To withdraw moneyz. (plz don't tho).\n");
                System.out.println("0: To exit our bank.\n");
                System.out.print("Your choice:");
                choice = inpucik.nextInt();
                inpucik.nextLine();

                switch (choice) {
                    case 1 -> {
                        //stworz nowy obiekt na pozycji 'iterator' w tablicy
                        accArray[iterator] = new Account();

                        //do obiektu na pozycji 'iterator' przypisz imie
                        System.out.println("Enter your name: ");
                        name = inpucik.nextLine();
                        accArray[iterator].setUserName(name);

                        //do obiektu na pozycji 'iterator' przypisz nazwisko
                        System.out.println("Enter your surname: ");
                        surname = inpucik.nextLine();
                        accArray[iterator].setUserSurname(surname);

                        //przyjmujemy numer konta
                        System.out.println("Enter your desired account number: ");

                        //odpalamy petle ktora bedzie aktywna, dopoki uzytkownik nie wpisze unikalnego numeru konta
                        while (brejker2) {
                            userAccNum = inpucik.nextInt();

                            //przechodzimy po calej tablicy obiektow
                            for (int i = 0; i < iterator; i++) {
                                //i sprawdzamy, czy juz taki numer konta zostal wpisany
                                if (accArray[i].getAccNumber() == userAccNum) {
                                    System.out.println("Account number already exists!");
                                    //jezeli nie znalezlismy takiego numeru konta w naszej tablicy,
                                    //to przypisujemy ten numer konta na biezacej pozycji 'iterator'
                                } else {
                                    accArray[iterator].setAccNumber(userAccNum);
                                    //oraz wychodzimy z petli ustawiajaca brejker2 jako false.
                                    brejker2 = false;
                                }
                            }

                        }

                        //po stworzeniu konta zwiekszamy iterator,
                        //by kolejne stworzylo sie na nastepnym miejscu w tablicy
                        iterator++;
                    }
                    case 2 -> {
                        //uzytkownik wprowadza swoj numer konta, ktorego stan chce sprawdzic
                        System.out.println("Enter Your account number: ");
                        userAccNum = inpucik.nextInt();

                        //przechodzimy przez cala tablice sprawdzajac na ktorym miejscu
                        //obiekt z takim numerem konta sie znajduje
                        //i jezeli je znajdziemy, to wyswietlamy jego stan
                        for (int i = 0; i < iterator; i++) {
                            if (accArray[i].getAccNumber() == userAccNum) {
                                System.out.println(accArray[i].showBalance());
                                //jezeli nie znajdziemy w naszej tablicy obiektu
                                //posiadajacego taki numer konta, to monitujemy o tym uzytkownika
                            } else {
                                System.out.println("Account not found!");
                            }
                        }


                    }
                    case 3 -> {
                        //jak wyzej
                        System.out.println("Enter Your account number: ");
                        userAccNum = inpucik.nextInt();
                        for (int i = 0; i < iterator; i++) {
                            //jesli znajdziemy taki numer konta
                            if (accArray[i].getAccNumber() == userAccNum) {
                                System.out.println("How much would you like to deposit? *drools*");
                                double depo = inpucik.nextDouble();
                                //przyjmujemy od uzytkownika kwote i dodajemy tyle do konta
                                accArray[i].deposit(depo);
                                System.out.println("Account balance updated.");
                            } else {
                                //jak nie znajdziemy - monitujemy
                                System.out.println("Account not found!");
                            }
                        }

                    }
                    case 4 -> {
                        //jak wyzej
                        System.out.println("Enter Your account number: ");
                        userAccNum = inpucik.nextInt();

                        for (int i = 0; i < iterator; i++) {
                            if (accArray[i].getAccNumber() == userAccNum) {
                                //po znalezieniu numeru konta pytamy ile pobrac
                                System.out.println("How much would you like to withdraw?");
                                double withdrawal = inpucik.nextDouble();
                                //probujemy pobrac podana kwote, jesli bedzie wieksza niz nasz stan konta
                                //zostaniemy o tym poinformowani - ta funkcja jest napisana bezp. w klasie Account
                                System.out.println(accArray[i].withdraw(withdrawal));
                            } else {
                                //analogicznie
                                System.out.println("Account not found!");
                            }
                        }

                    }
                    case 0 -> {
                        //zegnamy czule klienta
                        System.out.println("Don't let the door hit you on your way out.");
                        //ustawiamy zmienna na "false" jednoczesnie wychodzac z petli i przerywajac dzialanie programu
                        brejker = false;
                    }
                }

        }
    }

}
