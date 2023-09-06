package hello.typeconverter.formatter;


import hello.typeconverter.type.IpPort;
import hello.typeconverter.type.IpPortToStringInteger;
import hello.typeconverter.type.StringToIpPortConverter;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService(){
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringInteger());

        conversionService.addFormatter(new MyNumberFormatter());

        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1",8080));

        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000", Integer.class)).isEqualTo(1000L);

    }
}
