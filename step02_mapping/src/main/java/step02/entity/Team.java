package step02.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
//@Entity
public class Team {
	/*	SeqGenerator의 name은 generator의 이름이고 seqName과는 별개의 것이다.
	 * 	따라서 generator이름은 일치해야 한다
	 */
	@Id
	@SequenceGenerator(name = "Team_id_seq", sequenceName = "Team_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "Team_id_seq") //오라클 db에 최적화된 시퀀스가 자동 반영
	private long id;
	
	@Column(length = 20)
	private String name;
	
	@Builder
	public Team(String name) {
		this.name = name;
	}
	
}
