package step01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
//@Builder
//@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@NonNull
	@Column(name = "USERNAME", length = 20)
	private String name;
	
	@NonNull
	private int age;
	
	@NonNull
	@Column(name = "team_id") //컬럼 명으로는 언더바 선호하기 때문에 재설정
	private long teamId;		//team과 매핑된 정보
}
