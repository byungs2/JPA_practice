/*
create table Member (
   id varchar2(255) not null,
    age number(10,0),
    name varchar2(255),
    primary key (id)
)
 */

package step01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@RequiredArgsConstructor //@NotNull과 사용
public class Member {
	//pk가 사용자들이 중복되자 않는 데이터를 입력해야만 하는 상황
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	@NonNull
	@Column(name = "name")
	private String userName;
	
	@NonNull
	@Column(precision = 10)
	private int age;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
