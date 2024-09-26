package spring_boot_cicd.domain.dto.post;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;


@Getter
public class PostListDTO {
	
	private Long pno;
	
	private String title;
	
	private String writer;
	
	private LocalDateTime updatedAt;

}
