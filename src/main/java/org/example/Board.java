package org.example;



public class Board {
    private static final int cellsByX = 15;
    private static final int cellsByY = 60;
    private boolean[][] field;

    public Board(int numberOfCells) {
            field = generateField(numberOfCells) ;
}

private static boolean[][] generateField(int aliveCellCount) {
    boolean[][] field = new boolean[cellsByX][cellsByY];
    for (int i = 0; i < aliveCellCount; i++) {
        int x = (int) (Math.random() * cellsByX);
        int y = (int) (Math.random() * cellsByY);

        if (field[x][y]){
            i--;
        } else {
            field[x][y] = true;
        }
    }
    return field;
}


    public void print() {
    for (boolean[] row : field){
        for (boolean cell : row){
            System.out.print((cell) ? '●' : 'o');
            }
        System.out.println();
        }
    }

    public int nextStep(){
        boolean[][] nextField = new boolean[cellsByX][cellsByY];
        int alive = 0;
        for (int x = 0; x < cellsByX; x++){
            for (int y = 0; y < cellsByY; y++){
                int countAlive = countAlive(x,y);
                boolean isAlive = countAlive == 2 || countAlive == 3;
                if(isAlive){
                    nextField[x][y] = true;
                    alive++;
                }
            }
        }
        field = nextField;
        return alive;
    }

    public int countAlive(int cellX, int cellY){
        int count = -1;
        for (int x = Math.max(cellX - 1, 0); x < Math.min(cellX + 1, cellsByX - 1); x++){
            for (int y = Math.max(cellY - 1, 0); y < Math.min(cellY + 1, cellsByY - 1); y++){
                    if (field[x][y]){
                        count++;

                    }
            }
        }
return count;
    }

}