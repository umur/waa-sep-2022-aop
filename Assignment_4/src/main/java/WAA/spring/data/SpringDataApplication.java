package WAA.spring.data;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataApplication {

//	@Bean
//	public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
//		return builder -> builder.serializationInclusion(JsonInclude.Include.NON_NULL)
//				.serializers(LOCAL_DATETIME_SERIALIZER);
//	}
	@Bean
	ModelMapper modelMapper(){ return new ModelMapper();}
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

}
