package model.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import step03.entity.Member;

//view, controller, model 전역에 걸쳐 사용하는 데이터 표현용 클래스
//Team.java인 entity는 model 영역에서 사용하는 고유성 보장
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TeamDTO {
	private long id;
	private String name;
	private List<Member> members;
}
