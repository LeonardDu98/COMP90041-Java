public class Triangle {
    private DrawingCanvas myCanvas;
    private int length;
    private String character;

    private int startPosition;

    private int state = 0;

    public Triangle(DrawingCanvas myCanvas){
        this.myCanvas = myCanvas;
    }

    //Scanner
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

            if(alignment.equals("middle")){
                this.startPosition = (myCanvas.getWidth() - this.length) / 2;
            }else if(alignment.equals("right")){
                this.startPosition = myCanvas.getWidth() - this.length;
            }else{
                this.startPosition = 0;
            }
            showTriangle();
        }else{
            System.out.println("Error! The side length is too long (Current canvas size is " + myCanvas.getWidth()
                    + "x" + myCanvas.getHeight() +"). Please try again.");
            askDetail();
        }
    }

    /*
    AAAAA-----
    AAAA------
    AAA-------
    AA--------
    A---------
    ----------
     */
    private void showTriangle(){
        switch (state % 4){
            case 0:
                leftTop();
                break;
            case 1:
                rightTop();
                break;
            case 2:
                rightBottom();
                break;
            case 3:
                leftBottom();
        }
        System.out.println("Type R/L to rotate clockwise/anti-clockwise. Use other keys to continue.");
        String rotate = ConsoleDrawing.sc.nextLine();
        if(rotate.equals("R")){
            state++;
            showTriangle();
        }else if(rotate.equals("L")){
            state += 3;//change later (-1 % 4 == -1)
            showTriangle();
        }else{
            askContinue();
        }
    }

    private void askContinue(){
        System.out.println("Draw another triangle (Y/N)?");
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

    /*
    AAAAA-----
    -AAAA-----
    --AAA-----
    ---AA-----
    ----A-----
    ----------
     */
    private void rightTop(){
        for(int i = 0; i < myCanvas.getHeight(); i++){
            for(int j = 0; j < myCanvas.getWidth(); j++){
                if(j >= startPosition + i && j < startPosition + length && i < length){
                    System.out.print(character);
                }else{
                    System.out.print(myCanvas.getUnit());
                }
            }
            System.out.println();
        }
    }

    /*
    ----A-----
    ---AA-----
    --AAA-----
    -AAAA-----
    AAAAA-----
    ----------
     */
    private void rightBottom(){
        for(int i = 0; i < myCanvas.getHeight(); i++){
            for(int j = 0; j < myCanvas.getWidth(); j++){
                if(j >= startPosition + length - 1 - i && j < startPosition + length && i < length){
                    System.out.print(character);
                }else{
                    System.out.print(myCanvas.getUnit());
                }
            }
            System.out.println();
        }
    }

    /*
    A---------
    AA--------
    AAA-------
    AAAA------
    AAAAA-----
    ----------
     */
    private void leftBottom(){
        for(int i = 0; i < myCanvas.getHeight(); i++){
            for(int j = 0; j < myCanvas.getWidth(); j++){
                if(j >= startPosition && j <= startPosition + i  && i < length){
                    System.out.print(character);
                }else{
                    System.out.print(myCanvas.getUnit());
                }
            }
            System.out.println();
        }
    }

    private void leftTop(){
        for(int i = 0; i < myCanvas.getHeight(); i++){
            for(int j = 0; j < myCanvas.getWidth(); j++){
                if(j >= startPosition && j < startPosition + length - i && i < length){
                    System.out.print(character);
                }else{
                    System.out.print(myCanvas.getUnit());
                }
            }
            System.out.println();
        }
    }
}
