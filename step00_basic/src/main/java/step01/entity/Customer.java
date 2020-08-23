/**
create table Customer (
   id varchar2(255) not null,
    age number(10,0),
    name varchar2(255),
    primary key (id)
)
*/

package step01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity   
public class Customer {
	@Id //table에 생성하는 컬럼중 id 컬럼을 pk 로 설정함을 의미
	@Column(name="id")
	private String id;
	
	@Column(name="name") //(컬럼명 명시)
	private String userName; //컬럼명에 할당된 변수 명시
	
	//정수 10자리 타입 의미
	@Column(precision=10)  //매핑된 컬럼명은 age로 하나 사이즈는 정수만을 표현하는 number(10,0)
	private int age;
   
}  

