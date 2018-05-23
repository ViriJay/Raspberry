import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class MainClass {

    public static void main(String[] args) {
        GpioController gpioController = GpioFactory.getInstance();
        GpioPinDigitalOutput pinOut = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01);

        pinOut.high();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pinOut.low();
    }
}
