package kodlamaio.hrms;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.time.format.DateTimeFormatter;


@SpringBootApplication
public class HrmsApplication {

    private static final String dateFormat = "yyyy-mm-dd";
    private static final String dateTimeFormat = "yyyy-mm-dd HH:mm:ss";


    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);
    }

    //Dikkat
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer(){
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.simpleDateFormat(dateFormat);
            jacksonObjectMapperBuilder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
            jacksonObjectMapperBuilder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
        };
    }

}
