import java.util.ArrayList;
import java.util.Scanner;

class Car {
    private String name;
    private int number;
    public boolean isAvailable;
    String cusName = "";

    public Car(String name, int number, boolean isAvailable) {
        this.name = name;
        this.number = number;
        this.isAvailable = isAvailable;
    }

    public void getDetails() {
        System.out.print("Car Name: " + name);
        System.out.println(", Car Number: " + number);
    }

    public int getNumber() {
        return number;
    }

    public void rentCar(String cusName) {
        isAvailable = false;
        this.cusName = cusName;
    }

    public void returnCar() {
        isAvailable = true;
    }
}

class RentalSystem {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Car> carslist = new ArrayList<>();

    public void addCar(Car car) {
        carslist.add(car);
    }

    public int availableCars() {
        int i = 0;
        for (Car car : carslist) {
            if (car.isAvailable) {
                car.getDetails();
                i = 1;
            }
        }
        if (i == 0) {
            System.out.println("No cars available!");
        }
        return i;
    }

    public void allAvailableCars() {
        int i = 0;
        for (Car car : carslist) {
            car.getDetails();
        }
    }

    public void bookCar() {
        System.out.println("\nAvailable Cars");
        int a = availableCars();
        if (a == 0) {
            return;
        }

        System.out.print("\nType customer name: ");
        String name = sc.nextLine();

        System.out.print("Type the car number you want to rent: ");
        int number = sc.nextInt();
        sc.nextLine();

        for (Car car : carslist) {
            if (car.getNumber() == number && car.isAvailable) {
                car.rentCar(name);
                System.out.println("\nCar Rented Successfully By " + name + "!");
                car.getDetails();
                System.out.println("\n");
                return;
            }
        }
        System.out.println("Invalid Number!");
    }

    public void returnCar() {
        System.out.print("\nType the car number you want to return: ");
        int number = sc.nextInt();
        sc.nextLine();

        for (Car car : carslist) {
            if (car.getNumber() == number && !car.isAvailable) {
                car.returnCar();
                System.out.println("\nCar number: " + number + " returned by " + car.cusName + " successfully!");
                System.out.println("\n");
                return;
            }
        }
        System.out.println("Invalid Number!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalSystem rs = new RentalSystem();

        Car car1 = new Car("Toyota", 1234, true);
        Car car2 = new Car("Suzuki", 5678, true);
        Car car3 = new Car("Hyundai", 9823, false);
        Car car4 = new Car("Maruti", 3784, true);
        Car car5 = new Car("Honda", 2784, false);
        Car car6 = new Car("Range Rover", 7486, true);

        rs.addCar(car1);
        rs.addCar(car2);
        rs.addCar(car3);
        rs.addCar(car4);
        rs.addCar(car5);
        rs.addCar(car6);

        while (true) {
            System.out.println("\n1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. Check All Cars");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    rs.bookCar();
                    break;
                case 2:
                    rs.returnCar();
                    break;
                case 3:
                    rs.allAvailableCars();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
