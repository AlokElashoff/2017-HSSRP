import mraa.Aio;
import mraa.Gpio;
import java.util.concurrent.TimeUnit;

public class TempSens {

  static {
    try {
      System.loadLibrary("mraajava");
    } catch (UnsatisfiedLinkError e) {
      System.err.println(
          "Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" +
          e);
      System.exit(1);
    }
  }

  public static void main (String[] args){
    Aio temp = new Aio(0);
    Gpio button = new Gpio(3);
    float value = temp.readFloat();
    System.out.println("The temperature is " + value);
  }
}
