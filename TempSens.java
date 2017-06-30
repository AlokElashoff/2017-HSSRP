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
    float c;
    float f;
    float value;

    Aio temp = new Aio(0);
    Gpio button = new Gpio(3);

    value = temp.readFloat();
    value = value * 5000;
    c = (value-500)10;
    f = 9/5(c)+32;


    System.out.println("The temperature is " + f);
  }
}
