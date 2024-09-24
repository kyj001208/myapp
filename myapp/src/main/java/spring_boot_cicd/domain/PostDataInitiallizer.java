package spring_boot_cicd.domain;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import spring_boot_cicd.domain.entity.PostEntity;
import spring_boot_cicd.domain.repository.PostEntityRepository;


@Configuration
public class PostDataInitiallizer {

	//db에 저장된게 0개 일경우 for문을 통해서 테스트용 데이터 넣는 코드 
	
	@Bean
	ModelMapper modelmapper() {
	    // ModelMapper 객체 생성
	    ModelMapper modelmapper = new ModelMapper();
	    
	    // ModelMapper의 설정을 조정
	    modelmapper.getConfiguration()
	        // 필드 매칭 기능을 활성화
	        .setFieldMatchingEnabled(true)
	        
	        // 필드 접근 수준을 PRIVATE으로 설정
	        .setFieldAccessLevel(AccessLevel.PRIVATE);
	        // .setMatchingStrategy(MatchingStrategy.LOOSE) // 매칭 전략을 LOOSE로 설정할 수 있음
	        
	    // 설정한 ModelMapper 객체를 반환
	    return modelmapper;
	}

	
	
	@Bean
	CommandLineRunner initData(PostEntityRepository repository) {
		return (args)->{
			
			if(repository.count()==0) {
				for(int i=0; i<=10; i++) {
					
					repository.save(PostEntity.builder()
							.title("제목" +i)
							.content("내용"+i)
							.writer("몽여름"+i)
							.build());
				}
			}
		};
	}

}
