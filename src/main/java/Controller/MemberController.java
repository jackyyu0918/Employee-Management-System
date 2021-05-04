package Controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Member;

@RestController
@RequestMapping("/api")
public class MemberController {
	
	@GetMapping("/api/members")
	public Collection<Member> getMembers() {
		
	}
	

}
