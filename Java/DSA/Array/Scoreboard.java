/** Class for storing high scores in an array in nondecreasing order */
public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    /** Constructs an empty scoreboard with the given capacity for storing entries*/

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    /**Attempt to add a new score to the collection (if it is high enough) */
    public void add(GameEntry e) {
        int newScore = e.getScore();
        // is the new entry e really a high score?
        if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
            if (numEntries < board.length)  // no score drops from the board
                numEntries++;  // so overall number increases
            // Shift any lower scores rightward to make room for the new entry
            int j = numEntries - 1;
            while (j > 0 && board[j-1].getScore() < newScore) {
                board[j] = board[j-1];  // shift entry from j-1 to j
                j--;  // and decrement j
            }
            board[j] = e;  // when done, add new entry
        }
    }
    /** Remove and return the high score at index i */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if ( i < 0 || i >= numEntries)
            throw new IndexOutOfBoundsException("Invalid index: "+ i);
        GameEntry temp = board[i];                     // save the object to be removed count up from i (not down)
        for(int j = i; j < numEntries - 1; j++) {      // move one cell to the left
            board[i] = board[j+1];                     // null out the old last score
        }
        board[numEntries - 1] = null;
        numEntries--;
        return temp;                                   // return the removed object
    }

    public static void main(String[] args) {

    
        // Create a new GameEntry object
        GameEntry game1 = new GameEntry("Player1", 100);

       // GameEntry game2 = new GameEntry("Player2", 200);

        // Perform the getName method 
        String name = game1.getName();
        System.out.println(name);
        
        // Perform the  getScore method
        int score = game1.getScore();
        System.out.println(score);

        // Perform the toString method
        String game1Str = game1.toString();
        System.out.println("GameEntry as String" + game1Str);
    }
}


