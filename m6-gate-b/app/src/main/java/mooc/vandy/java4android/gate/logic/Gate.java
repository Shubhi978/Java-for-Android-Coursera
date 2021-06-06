package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {

    // TODO -- Fill in your code here
    public static final int IN=1;
    public static final int OUT=-1;
    public static final int CLOSED=0;

    int mSwing;

    public void Gate() {
        mSwing=CLOSED;
    }
    public int getSwingDirection(){
        return (mSwing);
    }
    public boolean setSwing(int direction){
        if (direction==IN|direction==OUT|direction==CLOSED) {
            mSwing=direction;
            return true;
        }
        else
            return false;
    }
    public boolean open(int direction) {
        if (direction==IN|direction==OUT) {
            this.setSwing(direction);
            return true;
        }
        else
            return false;
    }
    public void close(){
        mSwing=CLOSED;
    }
    public int thru(int count){
        if(this.getSwingDirection()==IN){return count;}
        else if(getSwingDirection()==OUT){return -1*count;}
        else return 0;
    }
    public String toString() {
        if(getSwingDirection()==CLOSED)                                  // for a gate that is closed
            return "This gate is closed";
        else if(getSwingDirection()==IN)                                // for a gate that has opened to swing IN
            return "This gate is open and swings to enter the pen only";
        else if(getSwingDirection()==OUT)                                // for a gate that been opened swing OUT
            return "This gate is open and swings to exit the pen only";
        else // for a gate that has a swing value other than IN, OUT, or CLOSED
            return "This gate has an invalid swing direction";
    }
}
