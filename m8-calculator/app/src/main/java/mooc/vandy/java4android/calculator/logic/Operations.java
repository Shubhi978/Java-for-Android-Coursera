package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Created by Vidish on 23-11-2016.
 */
public abstract class Operations {

    abstract void print(); // Create abstract class

    protected void print(String outputString, ActivityInterface mOut) {
        mOut.print(outputString); // Print result
    }
}
