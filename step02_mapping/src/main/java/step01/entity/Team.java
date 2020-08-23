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
@NoArgsConstructor
@Getter
@Setter
@ToString
//@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //오라클 db에 최적화된 시퀀스가 자동 반영
	private long id;
	
	@NonNull
	@Column(length = 20)
	private String name;
	
}
