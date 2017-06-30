import mraa.Aio;
import java.util.concurrent.TimeUnit;

public class LightDoorUnlock {

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

  public static void main(String[] args)
  {
    int[] password;
    for(int i = 0; i < 4; i++) {

      Aio light = new Aio(3);
      float value = light.readFloat();
      //System.out.println("The reading from the phototransistor is " + value);
      if(value <= .5) {
        value = 0;
      }
      else {
        value = 1;
      }
      password[i] = value;
      TimeUnit.SECONDS.sleep(1);
    }
      System.out.println("The password is " + password);

  }
}
