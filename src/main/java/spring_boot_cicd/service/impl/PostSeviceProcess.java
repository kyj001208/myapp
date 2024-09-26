package spring_boot_cicd.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring_boot_cicd.domain.dto.post.PostDetailDTO;
import spring_boot_cicd.domain.dto.post.PostListDTO;
import spring_boot_cicd.domain.dto.post.PostSaveDTO;
import spring_boot_cicd.domain.entity.PostEntity;
import spring_boot_cicd.domain.repository.PostEntityRepository;
import spring_boot_cicd.service.PostSevice;

@Service
@RequiredArgsConstructor
public class PostSeviceProcess implements PostSevice{
	
	//모델 매퍼를 활용한 코드 
	
	private final PostEntityRepository repository;
	private final ModelMapper modelmapper;

	
	@Override
	public List<?> listProcess() {
		List<PostListDTO>result= repository.findAll().stream()
		.map(post->modelmapper.map(post, PostListDTO.class)) //이름이 맞는거 끼리 알아서 매핑해서 dto로 넘겨줌(바인딩)
		.toList(); //불변리스트 (16이상에서 사용가능)
		//.collect(Collectors.toList()); =가변형이고 8이상 사용 가능 
		
		return result ;
	}

	
	@Override
	public PostDetailDTO detailProcess(Long pno) {
		
		return repository.findById(pno).map(post->modelmapper.map(post, PostDetailDTO.class))
				.orElseThrow();
	}


	@Override
	public void saveProcess(PostSaveDTO dto) {
		repository.save(modelmapper.map(dto, PostEntity.class));
		
	}


	


}
