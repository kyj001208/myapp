package spring_boot_cicd.domain.dto.post;

import lombok.Setter;

@Setter
public class PostSaveDTO {
	
	private String title;
	
	private String content;
	
	private String writer;

}
