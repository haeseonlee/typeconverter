package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import hello.typeconverter.type.IpPortToStringInteger;
import hello.typeconverter.type.StringToIpPortConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void stringToInteger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        assertThat(result).isEqualTo(10);

    }

    @Test
    void IntegerToString(){
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort(){
        IpPortToStringInteger converter = new IpPortToStringInteger();
        IpPort source = new IpPort("127.0.0.1",8080);
        String result = converter.convert(source);

        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
    
    @Test
    void IpPortToString(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080));
    }
}