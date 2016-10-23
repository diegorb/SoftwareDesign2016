package iteso.mx;

/**
 * Created by felipe on 10/20/16.
 */
/*
private final ThreadLocal perThreadInstance = new ThreadLocal();
private Helper helper = null;
public Helper getHelper() {
        if (perThreadInstance.get() == null) createHelper();
        return helper;
        }
private final void createHelper() {
synchronized(this) {
        if (helper == null)
        helper = new Helper();
        }
        // Any non-null value would do as the argument here
        perThreadInstance.set(perThreadInstance);
        }
        }*/

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler instance = null;

    private ChocolateBoiler () {
        empty = true;
        boiled = false;
    }

    public synchronized static ChocolateBoiler getInstance () {
        if (instance == null) {
            synchronized (ChocolateBoiler.class) {
                instance = new ChocolateBoiler();
            }
        }

        return instance;
    }

    public synchronized void fill () {
        synchronized (ChocolateBoiler.class) {
            if (isEmpty()) {
                empty = false;
                boiled = false;
            }
        }
    }

    public synchronized void drain () {
        synchronized (ChocolateBoiler.class) {
            if (!isEmpty() && isBoiled()) {
                // drain the boiled milk and chocolate
                empty = true;
            }
        }
    }

    public synchronized void boil () {
        synchronized (ChocolateBoiler.class) {
            if (!isEmpty () && !isBoiled ()) {
                // bring the contents to a boil
                boiled = true;
            }
        }
    }

    public synchronized boolean isEmpty () {
        return empty;
    }

    public synchronized boolean isBoiled () {
        return boiled;
    }
}