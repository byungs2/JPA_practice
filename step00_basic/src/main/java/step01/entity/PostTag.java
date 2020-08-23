package step01.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString

@NamedQuery(query = "select pt from PostTag pt where pt.tagId.tagId = (select t.tagId from Tag t where t.tagName = :tagname)", name = "PostTag.findByTagName")
public class PostTag {
	
	@Id
	@SequenceGenerator(name = "Post_Tag_seq", sequenceName = "Post_Tag_seq", allocationSize = 1)
	@GeneratedValue(generator = "Post_Tag_seq")
	long postTagId;
	
	@ManyToOne
	@JoinColumn(name = "POST_ID")
	Post postId;
	
	@ManyToOne
	@JoinColumn(name = "TAG_ID")
	Tag tagId;
}
