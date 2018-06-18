import org.kaaproject.kaa.client.DesktopKaaPlatformContext;
import org.kaaproject.kaa.client.Kaa;
import org.kaaproject.kaa.client.KaaClient;
import org.kaaproject.kaa.client.SimpleKaaClientStateListener;
import org.kaaproject.kaa.client.configuration.base.ConfigurationListener;
import org.kaaproject.kaa.client.configuration.base.SimpleConfigurationStorage;
import org.kaaproject.kaa.client.logging.strategies.RecordCountLogUploadStrategy;
import org.kaaproject.kaa.schema.sample.SensorConfiguration;
import org.kaaproject.kaa.schema.sample.DataCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import com.pi4j.gpio.extension.base.AdcGpioProvider;
import com.pi4j.gpio.extension.mcp.MCP3008GpioProvider;
import com.pi4j.gpio.extension.mcp.MCP3008Pin;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.event.GpioPinAnalogValueChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerAnalog;
import com.pi4j.io.spi.SpiChannel;

/**
 * Class implement functionality for First Kaa application. Application send temperature data
 * from the Kaa endpoint with required configured sampling period
 */
public class KaaSensorData {

    private static final long DEFAULT_START_DELAY = 1000L;

    private static final Logger LOG = LoggerFactory.getLogger(KaaSensorData.class);

    private static KaaClient kaaClient;

    private static ScheduledFuture<?> scheduledFuture;
    private static ScheduledExecutorService scheduledExecutorService;

    /*------------------------------ Pi4J Setup ------------------------------*/

    // Create gpio controller
    static GpioController gpio;

    // Create custom MCP3008 analog gpio provider
    // we must specify which chip select (CS) that that ADC chip is physically connected to.
    static AdcGpioProvider provider;

    static GpioPinAnalogInput input0;
    static GpioPinAnalogInput input1;
    static GpioPinAnalogInput input2;


    public static void main(String[] args) {
        gpio = GpioFactory.getInstance();

        try {
            provider = new MCP3008GpioProvider(SpiChannel.CS0);
        } catch (IOException e) {
            System.out.println("IOException occured!");
        }

        input0 = gpio.provisionAnalogInputPin(provider, MCP3008Pin.CH0, "MyAnalogInput-CH0");
        input1 = gpio.provisionAnalogInputPin(provider, MCP3008Pin.CH1, "MyAnalogInput-CH1");
        input2 = gpio.provisionAnalogInputPin(provider, MCP3008Pin.CH2, "MyAnalogInput-CH2");
        /*------------------------------ Kaa Setup -------------------------------*/

        LOG.info(KaaSensorData.class.getSimpleName() + " app starting!");

        scheduledExecutorService = Executors.newScheduledThreadPool(1);

        //Create the Kaa desktop context for the application.
        DesktopKaaPlatformContext desktopKaaPlatformContext = new DesktopKaaPlatformContext();

        /*
         * Create a Kaa client and add a listener which displays the Kaa client
         * configuration as soon as the Kaa client is started.
         */
        kaaClient = Kaa.newClient(desktopKaaPlatformContext, new FirstKaaClientStateListener(), true);

        /*
         *  Used by log collector on each adding of the new log record in order to check whether to send logs to server.
         *  Start log upload when there is at least one record in storage.
         */
        RecordCountLogUploadStrategy strategy = new RecordCountLogUploadStrategy(1);
        strategy.setMaxParallelUploads(1);
        kaaClient.setLogUploadStrategy(strategy);

        /*
         * Persist configuration in a local storage to avoid downloading it each
         * time the Kaa client is started.
         */
        kaaClient.setConfigurationStorage(new SimpleConfigurationStorage(desktopKaaPlatformContext, "saved_config.cfg"));

        kaaClient.addConfigurationListener(new ConfigurationListener() {
            @Override
            public void onConfigurationUpdate(SensorConfiguration configuration) {
                LOG.info("Received configuration data. New sample period: {}", configuration.getSamplePeriod());
                onChangedConfiguration(TimeUnit.SECONDS.toMillis(configuration.getSamplePeriod()));
            }
        });

        //Start the Kaa client and connect it to the Kaa server.
        kaaClient.start();

        LOG.info("--= Press any key to exit =--");
        try {
            System.in.read();
        } catch (IOException e) {
            LOG.error("IOException has occurred: {}", e.getMessage());
        }
        LOG.info("Stopping...");
        scheduledExecutorService.shutdown();
        kaaClient.stop();
    }

    private static double getInput0Value() {
        return input0.getValue();
    }

    private static double getInput1Value() {
        return input1.getValue();
    }

    private static double getInput2Value() {
        return input2.getValue();
    }

    private static double getApiValue() {
      new httpconnectionobjectding();
    }

    private static void onKaaStarted(long time) {
        if (time <= 0) {
            LOG.error("Wrong time is used. Please, check your configuration!");
            kaaClient.stop();
            System.exit(0);
        }

        scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        double input0Value = getInput0Value();
                        double input1Value = getInput1Value();
                        double input2Value = getInput2Value();
                        kaaClient.addLogRecord(new DataCollection("1", "pot", input0Value));
                        kaaClient.addLogRecord(new DataCollection("1", "light", input1Value));
                        kaaClient.addLogRecord(new DataCollection("1", "temperature", input2Value));
                        LOG.info("Pot Value: {}", input0Value);
                        LOG.info("Light Value: {}", input1Value);
                        LOG.info("Temp Value: {}", input2Value);
                    }
                }, 0, time, TimeUnit.MILLISECONDS);
    }

    private static void onChangedConfiguration(long time) {
        if (time == 0) {
            time = DEFAULT_START_DELAY;
        }
        scheduledFuture.cancel(false);

        scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        double input0Value = getInput0Value();
                        double input1Value = getInput1Value();
                        double input2Value = getInput2Value();
                        kaaClient.addLogRecord(new DataCollection("1", "pot", input0Value));
                        kaaClient.addLogRecord(new DataCollection("1", "light", input1Value));
                        kaaClient.addLogRecord(new DataCollection("1", "temperature", input2Value));
                        LOG.info("Pot Value: {}", input0Value);
                        LOG.info("Light Value: {}", input1Value);
                        LOG.info("Temp Value: {}", input2Value);                    }
                }, 0, time, TimeUnit.MILLISECONDS);
    }

    private static class FirstKaaClientStateListener extends SimpleKaaClientStateListener {

        @Override
        public void onStarted() {
            super.onStarted();
            LOG.info("Kaa client started");
            SensorConfiguration configuration = kaaClient.getConfiguration();
            LOG.info("Default sample period: {}", configuration.getSamplePeriod());
            onKaaStarted(TimeUnit.SECONDS.toMillis(configuration.getSamplePeriod()));
        }

        @Override
        public void onStopped() {
            super.onStopped();
            LOG.info("Kaa client stopped");
        }
    }
}
