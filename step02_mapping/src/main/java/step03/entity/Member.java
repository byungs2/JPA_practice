package step03.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Member {
	@Id
	@SequenceGenerator(name = "Member_id_seq", sequenceName = "Member_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "Member_id_seq")
	private long id;
	
	@Column(name = "USERNAME", length = 20)
	private String name;
	
	private int age;
	
	/*	Team 멤버 변수가 보유한 Team 클래스의 PK를 기준으로 하여 Member의 멤버가 맵핑이 되어야 한다
	 * 	table 관점에서  Member의 team_id 컬럼은 Team table의 id 컬럼을 참조
	 * 	Team entity에는 id/name
	 */
	
	//@Column(name = "team_id") //컬럼 명으로는 언더바 선호하기 때문에 재설정
	//멤버 한명은 팀 하나에 소속
	/*	@ManyToOne(fetch = FetchType.LAZY)
	 * 	 - 연관 관계의 table 데이터를 실제 사용하고자 하는 시점에 개별적으로 sql문장 실행
	 * 	 - 가령 member 데이터 중 Team table의 데이터를 필요로 하지 않거나, 데이터 양이 너무 많아서 실제 사용시에
	 * 		만 select를 별도로 하고 싶을 경우 권장
	 *  @ManyToOne
	 *   - 연관된 모든 table의 데이터를 한번에 select로 검색
	 *   - 모든 데이터를 사용하고자 할 경우 선호하는 형식
	 * 
	 */
	//@ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	//Team table과 맵핑되는 Member table 컬럼 명시 (join)
	@JoinColumn(name = "TEAM_ID")
	private Team teamId;		//team과 매핑된 정보
	
	@Builder
	public Member(String name, int age, Team teamId) {
		this.name = name;
		this.age = age;
		this.teamId = teamId;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", teamId=" + teamId.getTeamName() + "]";
	}

}
