package step01.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity  
public class Post {
	
	@Id
	long postId;
	
	@OneToMany(mappedBy = "postId")
	List<PostTag> postTags;
	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", writerName=" + writerName + "]";
	}

	String writerName;
}
