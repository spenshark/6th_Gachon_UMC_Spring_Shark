package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDto;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
