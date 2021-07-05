public class Square {
    private DrawingCanvas myCanvas;
    private int length;
    private String character;
    private String alignment;

    private int startPosition;

    public Square(DrawingCanvas myCanvas){
        this.myCanvas = myCanvas;
    }

    public void askDetail(){
        System.out.println("Side length:");
        int length = Integer.parseInt(ConsoleDrawing.sc.nextLine());
        if(length <= Math.min(myCanvas.getWidth(), myCanvas.getHeight())){

            System.out.println("Printing character:");
            String character = ConsoleDrawing.sc.nextLine();
            System.out.println("Alignment (left, middle, right):");
            String alignment = ConsoleDrawing.sc.nextLine();
            this.length = length;
            this.character = character;
            this.alignment = alignment;
            showSquare();

        }else{
            System.out.println("Error! The side length is too long (Current canvas size is " + myCanvas.getWidth()
                    + "x" + myCanvas.getHeight() +"). Please try again.");
            askDetail();
        }
    }

    public void showSquare(){
        if(alignment.equals("middle")){
            this.startPosition = (myCanvas.getWidth() - this.length) / 2;
        }else if(alignment.equals("right")){
            this.startPosition = myCanvas.getWidth() - this.length;
        }else{
            this.startPosition = 0;
        }

        for(int i = 0; i < myCanvas.getHeight(); i++){
            for(int j = 0; j < myCanvas.getWidth(); j++){
                if(j >= startPosition && j < startPosition + length && i < length){
                    System.out.print(character);
                }else{
                    System.out.print(myCanvas.getUnit());
                }
            }
            System.out.println();
        }
        System.out.println("Type I/O to zoom in/out. Use other keys to continue.");
        String zoom = ConsoleDrawing.sc.nextLine();
        if(zoom.equals("I")){
            if(length < Math.min(myCanvas.getWidth(), myCanvas.getHeight())){
                length++;
            }
            showSquare();
        }else if(zoom.equals("O")){
            if(length > 1){
                length--;
            }
            showSquare();
        }else{
            askContinue();
        }
    }

    private void askContinue(){
        System.out.println("Draw another square (Y/N)?");
        String answer = ConsoleDrawing.sc.nextLine();
        if(answer.equals("Y")){
            askDetail();
        }else if(answer.equals("N")){
            return;
        }else{
            System.out.println("Unsupported option. Please try again!");
            askContinue();
        }
    }
}
