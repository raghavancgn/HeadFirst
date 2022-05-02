package HeadFirst;
class NewDog {
    //instance variables
    int size;
    String name;

    //method
    void bark() {
        if (size > 60) {
            System.out.println("Wooof!!Wooof..");
        } else if (size > 14) {
            System.out.println("Ruff !! Ruff");
        } else {
            System.out.println("Yip!!! Yip!! ");
        }
    }

    public static class NewDogTestDrive {
        public static void main(String[] args) {
            //Dog Test code goes as below
            NewDog one = new NewDog();
            one.size = 70;
            NewDog two = new NewDog();
            two.size = 8;
            NewDog three = new NewDog();
            three.size = 35;

            one.bark();
            two.bark();
            three.bark();
        }
    }
}
