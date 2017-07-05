import mraa.Aio;
import mraa.Gpio;
import java.util.concurrent.TimeUnit;
import java.time.*;

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
    DateTimeZone zonePacific = DateTimeZone.forID( "Pacific/Auckland" );
    DateTime now = DateTime.now( zonePacific );

    //TimeZone.setDefault(TimeZone.getTimeZone("Pacific/Auckland"));
    //Calendar cal = Calendar.getInstance();
    //SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    System.out.println(  );
    double c;
    double f;
    double k;
    double value;

    Aio temp = new Aio(0);
    Gpio button = new Gpio(3);

    value = temp.readFloat();
    value = value*1023;
    //c = (value-500)/10;
    //f = (9/5)*(c)+32;

    k = Math.log(((10240000/value) - 10000));
    k = 1 / (0.001129148 + (0.000234125 + (0.0000000876741 * k * k ))* k );
    c = k - 273.15;              // Convert Kelvin to Celsius
    f = (c * 9.0)/ 5.0 + 32.0;


    System.out.println(now + " " + f);
  }
}
