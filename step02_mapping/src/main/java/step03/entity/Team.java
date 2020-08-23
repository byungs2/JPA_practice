package step03.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Team {
	//ToString 롬복 때문에 재귀적 호출이 발생하여 Stack over flow 발생하므로 재정의할때 members 제외 리턴

	@Id
	@SequenceGenerator(name = "Team_id_seq", sequenceName = "Team_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "Team_id_seq") //오라클 db에 최적화된 시퀀스가 자동 반영
	private long id;
	
	@Column(length = 20)
	private String TeamName;
	
	//다수의 Member 보유 변수 선언
	//@OneToMany //3개의 테이블 생성
	@OneToMany(mappedBy = "teamId") //Member라는 entity의 멤버 변수명 , 2개의 테이블과 fk설정 
	private List<Member> members;
	
	@Builder
	public Team(String name, List<Member> members) {
		this.TeamName = name;
		this.members = members;
	}
	
	//소속된 멤버 수 반환하는 메소드 추가
	//toString() StackOverflowError 발생되지 않도록 재정의 권장
}
