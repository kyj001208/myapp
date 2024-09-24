package spring_boot_cicd.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring_boot_cicd.domain.dto.post.PostDetailDTO;
import spring_boot_cicd.service.PostSevice;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class PostController {
	
	private final PostSevice service;
	
	@GetMapping("/api/posts")
	public List<?> list() {
		
		/*
		List<?>posts=service.listProcess();
		
		//204 No Content
		if(posts.isEmpty()) {
			return ResponseEntity.noContent().build();
			//컨텐츠를 존재하지 않는 엔터티를 넘겨줬습니다 라는 의미
		}*/
		
		return service.listProcess();
	}
	
	@GetMapping("/api/posts/{pno}")
	public PostDetailDTO detail(@PathVariable(name="pno")Long pno) {
		return service.detailProcess(pno);
	}
	
	
	
	

}
