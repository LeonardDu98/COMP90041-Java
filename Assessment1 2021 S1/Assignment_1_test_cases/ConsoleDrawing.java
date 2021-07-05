import java.util.Scanner;

public class ConsoleDrawing {
    static private DrawingCanvas myCanvas = null;
    static public Scanner sc = new Scanner(System.in);

    /**
     * 1.String -> int: Integer
     * 2.static method use non-static var
     * 3.递归
     * 4.Scanner
     *      a.static
     *      b.para
     *      c.design
     */
    public static void main(String[] args) {
	// write your code here

        //canvasStart
        myCanvas = new DrawingCanvas(args);
        ConsoleDrawing myInstance = new ConsoleDrawing();
        myInstance.welcome();
        myInstance.showMenu();
    }

    public void welcome(){
        System.out.println("----WELCOME TO MY CONSOLE DRAWING APP----");
        myCanvas.printDetail();
    }

    public void showMenu(){
        System.out.println("Please select an option. Type 4 to exit.\n" +
                           "1. Draw triangles\n" +
                           "2. Draw squares\n" +
                           "3. Update drawing canvas settings\n" +
                           "4. Exit");
//        int i = sc.nextInt();
//        sc.nextLine();
        int option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1:
                Triangle myTriangle = new Triangle(myCanvas);
                myTriangle.askDetail();
                break;
            case 2:
                Square mySquare = new Square(myCanvas);
                mySquare.askDetail();
                break;
            case 3:
                myCanvas.update();
                myCanvas.printDetail();
                break;
            case 4:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Unsupported option. Please try again!");
        }
        showMenu();
    }
}
