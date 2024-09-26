package spring_boot_cicd.service;

import java.util.List;

import spring_boot_cicd.domain.dto.post.PostDetailDTO;
import spring_boot_cicd.domain.dto.post.PostSaveDTO;

public interface PostSevice {

	List<?> listProcess();

	PostDetailDTO detailProcess(Long pno);

	void saveProcess(PostSaveDTO dto);



	



}
