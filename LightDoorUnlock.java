import mraa.*;


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

    Aio light = new Aio(3);
    float value = light.readFloat();
    System.out.println("The reading from the phototransistor is " + value);
  }
}
