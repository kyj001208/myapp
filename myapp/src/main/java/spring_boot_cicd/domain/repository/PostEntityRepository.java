package spring_boot_cicd.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_boot_cicd.domain.entity.PostEntity;

public interface PostEntityRepository extends JpaRepository<PostEntity, Long>{

}
