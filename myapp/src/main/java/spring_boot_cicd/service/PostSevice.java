package spring_boot_cicd.service;

import java.util.List;

import spring_boot_cicd.domain.dto.post.PostDetailDTO;

public interface PostSevice {

	List<?> listProcess();

	PostDetailDTO detailProcess(Long pno);

}
